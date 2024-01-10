<template>
    <template v-if="!this.zavrseno">
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

                <div v-if="pitanje.tipPitanja.idTipaPitanja === 1">
                    <label v-for="opcija in pitanje.opcijePitanja" class="block text-lg">
                        <input type="radio" :value="opcija.idOpcijePitanja" v-model="pitanje.odgovor.idOpcijaPitanja[0]" />
                        <span class="ml-2">{{ opcija.vrijednost }}</span>
                    </label>
                </div>
                <div v-else-if="pitanje.tipPitanja.idTipaPitanja === 2">
                    <label v-for="opcija in pitanje.opcijePitanja" class="block text-lg">
                        <input type="checkbox" :value="opcija.idOpcijePitanja" v-model="pitanje.odgovor.idOpcijaPitanja" />
                        <span class="ml-2">{{ opcija.vrijednost }}</span>
                    </label>
                </div>
                <div v-else>
                    <textarea class="w-full mt-2 p-2 border" v-model="pitanje.odgovor.tekstOdgovora" />
                </div>
            </div>
        </div>
        <div class="container mt-3 text-black">
            <button @click="podnesiOdgovore()"
                class="float-right bg-apank-primary hover:bg-cyan-700 text-white text-sm font-semibold px-4 py-2 mb-5 rounded">
                Pohrani odgovore
            </button>
        </div>
    </template>

    <template v-else>
        <div class="container mt-4 text-black bg-white rounded">
            <div class="pt-4 mb-8 relative">
                <h1 class="text-4xl mt-2 mb-2">Anketa je ispunjena! Hvala!</h1>
            </div>
        </div>
    </template>
</template>

<script>
import axios from "axios"
import RequestHandler from "./../RequestHandler.js"
import { SPRING_URL } from "./../constants.js"

export default {
    data() {
        return {
            anketa: '',
            zavrseno: false
        }
    },
    async mounted() {
        this.anketa = (await axios.post(SPRING_URL.concat('/anketa/get'), { id: this.$route.params.id })).data
        this.anketa.pitanja.sort((a, b) => (a.idPitanja > b.idPitanja) ? 1 : -1)
        for (let pitanje of this.anketa.pitanja) {
            pitanje.opcijePitanja.sort((a, b) => (a.idOpcijePitanja > b.idOpcijePitanja) ? 1 : -1)
            pitanje.odgovor = { tekstOdgovora: '', emailKorisnika: null, idPitanja: pitanje.idPitanja, idOpcijaPitanja: [] }
        }
    },
    methods: {
        async podnesiOdgovore() {
            if (confirm("Jeste li sigurni?")) {
                let odgovori = []
                for (let pitanje of this.anketa.pitanja) {
                    odgovori.push(JSON.parse(JSON.stringify(pitanje.odgovor)))
                }
                await axios.post(SPRING_URL.concat('/odgovor/add'), odgovori)
                this.zavrseno = true
            }
        }
    }
}
</script>