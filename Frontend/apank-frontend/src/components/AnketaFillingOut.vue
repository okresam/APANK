<template>
    <div class="container mt-4 text-black bg-white rounded">
        <div class="pt-4 mb-8 relative">
            <h1 class="text-2xl py-2 px-1 mt-2">{{ anketa.naslov }}</h1>
            <p>{{ anketa.opis }}</p>
        </div>
    </div>
    <div v-for="pitanje in anketa.pitanja" class="container mt-3 text-black bg-white rounded">
        <div class="pt-4 mb-8 relative">
            <div>
                {{ pitanje }}
            </div>
            
            <div class="flow-root mb-2 mt-2">
                <p class="float-left text-3xl">{{ pitanje.tekstPitanja }}</p>
                <div class="float-right opacity-50">{{ pitanje.tipPitanja.nazivTipaPitanja }}</div>
            </div>

            <div v-if="pitanje.tipPitanja.idTipaPitanja === 1">
                <label v-for="opcija in pitanje.opcijePitanja" class="block text-lg">
                    <input type="radio" :value="opcija.vrijednost"  />
                    <span class="ml-2">{{ opcija.vrijednost }}</span>
                </label>
            </div>
            <div v-else-if="pitanje.tipPitanja.idTipaPitanja === 2">
                Pitanje tipa višestruki odabir
            </div>
            <div v-else>
                Pitanje tipa tekst
            </div>

        </div>
    </div>

</template>

<script>
import axios from "axios"
import RequestHandler from "./../RequestHandler.js"
import { SPRING_URL } from "./../constants.js"

export default {
    data() {
        return {
            anketa: ''
        }
    },
    async mounted() {
        this.anketa = (await axios.post(SPRING_URL.concat('/anketa/get'), { id: this.$route.params.id })).data
        this.anketa.pitanja.sort((a, b) => (a.idPitanja > b.idPitanja) ? 1 : -1)
        for(let pitanje of this.anketa.pitanja) {
            pitanje.opcijePitanja.sort((a, b) => (a.idOpcijePitanja > b.idOpcijePitanja) ? 1 : -1)
        }
    },
    methods: {
        
    }
}
</script>