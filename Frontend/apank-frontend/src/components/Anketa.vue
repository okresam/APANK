<template>
    <AnketaEdit v-if="
    this.$store.state.user &&
    this.$store.state.user.idKorisnika === anketa.autorId"/>

    <div v-else class="container mt-4 text-black bg-white rounded">
        <div class="pt-4 mb-8 relative">
            Not anketa owner.
        </div>
    </div>
</template>

<script>
import RequestHandler from "./../RequestHandler.js"
import { SPRING_URL } from "./../constants.js"
import AnketaEdit from "./AnketaEdit.vue"

export default {
    components: {
        AnketaEdit
    },
    data() {
        return {
            anketa: ''
        }
    },
    async mounted() {
        if (this.$store.state.user) {
            this.anketa = await RequestHandler.postRequest(SPRING_URL.concat('/anketa/get'), { id: this.$route.params.id })
        }
    },
    methods: {
        
    }
}
</script>