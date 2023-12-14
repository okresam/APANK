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
    <div v-for="pitanje in anketa.pitanja" class="container mt-3 text-black bg-white rounded">
        <div class="pt-4 mb-8 relative">
            <p class="text-2xl">Pitanje:</p>
            <input v-model="pitanje.tekstPitanja" type="text"
                class="py-2 px-1 text-2xl w-full bg-transparent border-b focus:border-apank-primary focus:outline-none" />
            <button @click="obrisiPitanje(pitanje.idPitanja)"
                class="bg-red-600 hover:bg-red-500 text-white text-sm font-semibold px-4 py-2 rounded mt-5">
                Obriši pitanje
            </button>
        </div>
    </div>
    <div class="container mt-3 text-black">
        <button @click="dodajNovoPitanje"
            class="bg-apank-primary hover:bg-cyan-700 text-white text-sm font-semibold px-4 py-2 rounded">
            Novo pitanje
        </button>
    </div>
</template>

<script>
import RequestHandler from "./../RequestHandler.js"
import { SPRING_URL } from "./../constants.js"

export default {
    data() {
        return {
            anketa: ''
        }
    },
    async mounted() {
        this.anketa = await RequestHandler.postRequest(SPRING_URL.concat('/anketa/get'), { id: this.$route.params.id })
    },
    methods: {
        async dodajNovoPitanje() {
            let novoPitanje = { tekstPitanja: '', idAnkete: this.anketa.idAnkete }
            await RequestHandler.postRequest(SPRING_URL.concat('/pitanje/add'), novoPitanje)
            this.$router.go()
        },
        async obrisiPitanje(idPitanja) {
            await RequestHandler.postRequest(SPRING_URL.concat('/pitanje/delete'), { id: idPitanja.toString() })
            this.$router.go()
        }
    }
}
</script>