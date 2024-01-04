<template>
    <div class="container mt-4 text-black bg-white rounded">
        <div class="pt-4 mb-8 relative">
            <button @click="$router.push('/')"
                class="bg-gray-500 hover:bg-gray-400 text-white text-sm font-semibold px-4 py-2 rounded">
                Povratak
            </button>
            <h1 class="text-2xl py-2 px-1 mt-2">{{ anketa.naslov }}</h1>
            <p>{{ anketa.opis }}</p>
        </div>
    </div>
    <div v-for="(pitanje, i) in anketa.pitanja" class="container mt-3 text-black bg-white rounded">
        <div>{{ pitanje }}</div>
        <div class="pt-4 mb-8 relative">
            <div class="flow-root">
                <p class="float-left text-2xl">Pitanje:</p>
                <div class="float-right opacity-50">{{ pitanje.tipPitanja.nazivTipaPitanja }}</div>
            </div>
            <input v-model="pitanje.tekstPitanja" @input="spremiTekstPitanja(pitanje.idPitanja, i)" type="text"
                class="py-2 px-1 text-2xl w-full bg-transparent border-b focus:border-apank-primary focus:outline-none" />


            <!-- Question core -->
            <div v-if="pitanje.tipPitanja.idTipaPitanja === 1" class="mt-6">
                <div v-for="(opcija, j) in pitanje.opcijePitanja">
                    <input v-model="opcija.vrijednost" @input="spremiOpciju(opcija.idOpcijePitanja, i, j)"
                        class="mb-2 p-2 bg-transparent border focus:border-apank-primary focus:outline-none" type="text" />
                    <button @click="deleteOpcija(opcija.idOpcijePitanja, i, j)"
                        class="bg-red-600 hover:bg-red-500 text-white font-semibold ml-2 px-3 py-1 rounded-full">
                        X
                    </button>
                </div>
                <button @click="novaOpcija(pitanje.idPitanja, i)"
                    class="bg-apank-primary hover:bg-apank-secondary text-white text-sm font-semibold px-4 py-2 rounded-full">
                    +
                </button>
            </div>
            <div v-else-if="pitanje.tipPitanja.idTipaPitanja === 2" class="mt-6">Višestruki odabir</div>
            <div v-else class="mt-6 opacity-50">Korisnik unosi tekst.</div>


            <button @click="spremiPitanje(pitanje.idPitanja, i)"
                class="bg-apank-primary hover:bg-apank-secondary text-white text-sm font-semibold px-4 py-2 rounded mt-5">
                Spremi
            </button>
            <button @click="obrisiPitanje(pitanje.idPitanja)"
                class="bg-red-600 hover:bg-red-500 text-white text-sm font-semibold px-4 py-2 rounded mt-5 ml-1">
                Obriši pitanje
            </button>
        </div>
    </div>

    <div class="container mt-3 text-black">
        <select class="mr-3" v-model="novoPitanjeVrsta">
            <option v-for="vPitanja in vrstePitanja" :value="vPitanja.idTipaPitanja">{{ vPitanja.nazivTipaPitanja }}
            </option>
        </select>

        <button @click="dodajNovoPitanje"
            class="bg-apank-primary hover:bg-cyan-700 text-white text-sm font-semibold px-4 py-2 mb-5 rounded">
            Novo pitanje
        </button>
    </div>
</template>

<script>
import RequestHandler from "./../RequestHandler.js"
import { SPRING_URL } from "./../constants.js"
import { debounce } from "throttle-debounce"
import PQueue from "p-queue"

//const queue = new PQueue({ concurrency: 1 });

const debounceFunc = debounce(700, async (url, data) => {
    //queue.clear();
    //let newFn = async function(url, data) {
    //    await RequestHandler.postRequest(SPRING_URL.concat(url), data)
    //}
    //queue.add(newFn(url, data))
    await RequestHandler.postRequest(SPRING_URL.concat(url), data)
});

export default {
    data() {
        return {
            anketa: '',
            novoPitanjeVrsta: '',
            vrstePitanja: ''
        }
    },
    async mounted() {
        this.anketa = await RequestHandler.postRequest(SPRING_URL.concat('/anketa/get'), { id: this.$route.params.id })
        this.anketa.pitanja.sort((a, b) => (a.idPitanja > b.idPitanja) ? 1 : -1)

        this.vrstePitanja = await RequestHandler.getRequest(SPRING_URL.concat('/tippitanja/all'))
        this.novoPitanjeVrsta = this.vrstePitanja[0].idTipaPitanja
    },
    methods: {
        async dodajNovoPitanje() {
            let novoPitanje = { tekstPitanja: '', idAnkete: this.anketa.idAnkete, idTipaPitanja: this.novoPitanjeVrsta }
            await RequestHandler.postRequest(SPRING_URL.concat('/pitanje/add'), novoPitanje)
            this.$router.go()
        },
        async obrisiPitanje(idPitanja) {
            await RequestHandler.postRequest(SPRING_URL.concat('/pitanje/delete'), { id: idPitanja.toString() })
            this.$router.go()
        },
        async spremiPitanje(idPitanja, i) {
            await RequestHandler.postRequest(SPRING_URL.concat('/pitanje/update'), { idPitanja: idPitanja, tekstPitanja: JSON.parse(JSON.stringify(this.anketa.pitanja[i])).tekstPitanja })
            //console.log(JSON.parse(JSON.stringify(this.anketa.pitanja[i])))
            this.$router.go()
        },
        async novaOpcija(idPitanja, i) {
            let novaOpcija = await RequestHandler.postRequest(SPRING_URL.concat('/opcijapitanja/add'), { vrijednost: "", idPitanja: idPitanja })
            this.anketa.pitanja[i].opcijePitanja.push(novaOpcija)
        },
        async deleteOpcija(idOpcije, i, j) {
            await RequestHandler.postRequest(SPRING_URL.concat('/opcijapitanja/delete'), { id: idOpcije.toString() })
            this.anketa.pitanja[i].opcijePitanja.splice(j, 1)
        },
        spremiTekstPitanja(idPitanja, i) {
            //console.log(this.anketa.pitanja[i].tekstPitanja)
            //let funkcija = async function() {
            //    await RequestHandler.postRequest(SPRING_URL.concat('/pitanje/update'), { idPitanja: idPitanja, tekstPitanja: this.anketa.pitanja[i].tekstPitanja })
            //}
            debounceFunc('/pitanje/update', { idPitanja: idPitanja, tekstPitanja: this.anketa.pitanja[i].tekstPitanja })
        },
        spremiOpciju(idOpcije, i, j) {
            debounceFunc('/opcijapitanja/update', { idOpcijePitanja: idOpcije, vrijednost: this.anketa.pitanja[i].opcijePitanja[j].vrijednost })
        }
    }
}
</script>