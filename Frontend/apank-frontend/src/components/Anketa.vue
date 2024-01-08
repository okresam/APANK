<template>
    <AnketaEdit v-if="this.$store.state.user &&
        this.$store.state.user.idKorisnika === anketa.autorId &&
        this.anketa.idStatusaAnkete === 1" />

    <AnketaResults v-else-if="this.$store.state.user &&
        this.$store.state.user.idKorisnika === anketa.autorId &&
        (this.anketa.idStatusaAnkete === 2 || this.anketa.idStatusaAnkete === 3 )" />

    
    <template v-else>
        <div v-if="this.anketa.idStatusaAnkete === 1" class="container mt-4 text-black bg-white rounded">
            <div class="pt-4 mb-8 relative text-2xl">
                Anketa je još u pripremi.
            </div>
        </div>
        <AnketaFillingOut v-if="this.anketa.idStatusaAnkete === 2" />
        <div v-if="this.anketa.idStatusaAnkete === 3" class="container mt-4 text-black bg-white rounded">
            <div class="pt-4 mb-8 relative text-2xl">
                Anketa je završila.
            </div>
        </div>
    </template>
</template>

<script>
import axios from "axios"
import RequestHandler from "./../RequestHandler.js"
import { SPRING_URL } from "./../constants.js"
import AnketaEdit from "./AnketaEdit.vue"
import AnketaFillingOut from "./AnketaFillingOut.vue"
import AnketaResults from "./AnketaResults.vue"

export default {
    components: {
        AnketaEdit,
        AnketaFillingOut,
        AnketaResults
    },
    data() {
        return {
            anketa: ''
        }
    },
    async mounted() {
        try {
            this.anketa = (await axios.post(SPRING_URL.concat('/anketa/getAutorStatus'), { id: this.$route.params.id })).data
        } catch(e) {
            this.$router.push({name:'AnketaNotFound'})
        }
        
    },
    methods: {

    }
}
</script>