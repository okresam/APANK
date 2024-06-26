<template>
    <div class="container mt-4 text-black bg-white rounded">
        <div class="pt-4 mb-8 relative">
            <h1 class="text-4xl mt-2 mb-2">{{ anketa.naslov }}</h1>
            <p class="p-1">{{ anketa.opis }}</p>
        </div>
    </div>
    <div v-for="pitanje in anketa.pitanja" class="container mt-3 text-black bg-white rounded">
        <div class="pt-4 mb-8 relative">
            <div class="flow-root mb-2 mt-2">
                <p class="float-left text-3xl">{{ pitanje.tekstPitanja }}</p>
                <div class="float-right opacity-50">{{ pitanje.tipPitanja.nazivTipaPitanja }}</div>
            </div>
            <Bar v-if="pitanje.tipPitanja.idTipaPitanja !== 3 && pitanje.chartData.datasets[0].data.length > 3" :data="pitanje.chartData" :options="barOptions" />
            <div v-else-if="pitanje.tipPitanja.idTipaPitanja !== 3 && pitanje.chartData.datasets[0].data.length <= 3" class="block ml-auto mr-auto w-1/2 h-3/4">
                <Pie class=""  :data="pitanje.chartData" :options="pieOptions" />
            </div>
            <div v-else class="overflow-auto h-52 p-2 mt-4 border">
                <template v-for="odgovor in pitanje.odgovori">
                    <p>{{ odgovor.tekstOdgovora }}</p>
                    <hr/>
                </template>
            </div>
        </div>
    </div>
    <div v-if="this.status !== 3" class="container mt-3 text-black">
        <button @click="promjeniStatus()"
            class="float-right bg-apank-primary hover:bg-cyan-700 text-white text-sm font-semibold px-4 py-2 mb-5 rounded">
            Završi anketu
        </button>
    </div>
    <div class="mt-8"></div>
</template>

<script>
import RequestHandler from "./../RequestHandler.js"
import { SPRING_URL } from "./../constants.js"
import { Bar, Pie } from 'vue-chartjs'
import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale, ArcElement } from 'chart.js'

ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale, ArcElement)


export default {
    components: {
        Bar,
        Pie
    },
    data() {
        return {
            anketa: '',
            status: '',
            barOptions: {
                responsive: true,
                scale: {
                    ticks: {
                        precision: 0
                    }
                },
                plugins: {
                    legend: {
                        display: false
                    }
                }
            },
            pieOptions: {
                responsive: false,
                maintainAspectRatio: true,
                scale: {
                    yAxes: [
                        {
                            ticks: {
                                beginAtZero: true
                            }
                        }
                    ]
                },
                plugins: {
                    legend: {
                        display: true
                    }
                }
            },
        }
    },
    async mounted() {
        this.anketa = await RequestHandler.postRequest(SPRING_URL.concat('/anketa/getResults'), { id: this.$route.params.id })
        this.anketa.pitanja.sort((a, b) => (a.idPitanja > b.idPitanja) ? 1 : -1)
        this.status = this.anketa.statusAnkete.idStatusaAnkete

        for (let pitanje of this.anketa.pitanja) {
            if (pitanje.tipPitanja.idTipaPitanja !== 3) {
                let odgovorSum = {}
                for (let odgovor of pitanje.odgovori) {
                    for (let opcija of odgovor.opcijePitanja) {
                        if (opcija.vrijednost in odgovorSum) {
                            odgovorSum[opcija.vrijednost]++
                        } else {
                            odgovorSum[opcija.vrijednost] = 1
                        }
                    }
                }
                pitanje.odgovorSum = odgovorSum
                pitanje.chartData = {}
                pitanje.chartData.labels = Object.keys(odgovorSum)
                pitanje.chartData.datasets = [ { data: Object.values(odgovorSum) } ]
                if (pitanje.chartData.datasets[0].data.length <= 3) {
                    pitanje.chartData.datasets[0].backgroundColor = ['#41B883', '#E46651', '#00D8FF']
                } else {
                    pitanje.chartData.datasets[0].backgroundColor = ['#388697']
                }
            }
        }
    },
    methods: {
        async promjeniStatus() {
            if (confirm("Jeste li sigurni?")) {
                await RequestHandler.postRequest(SPRING_URL.concat('/anketa/changestate'), { id: this.anketa.idAnkete.toString() })
                this.$router.go()
            }
        }
    }
}
</script>