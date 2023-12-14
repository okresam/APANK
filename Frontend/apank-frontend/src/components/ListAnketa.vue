<template>
    <main v-if="$store.state.user">
        <div v-if="isDodajVisible">
            <div class="antialiased text-black">
                <div class="flex items-center  w-full">
                    <div class="w-full bg-white rounded shadow-lg p-8 m-4 md:max-w-sm md:mx-auto">
                        <button @click="toggleDodaj"
                            class="bg-gray-500 hover:bg-gray-400 text-white text-sm font-semibold px-4 py-2 rounded">
                            Povratak
                        </button>
                        <span class="block w-full text-xl font-bold mt-4 mb-4">Dodaj novu anketu</span>
                        <form @submit.prevent="dodajNovuAnketu" class="mb-4">
                            <div class="mb-4 md:w-full">
                                <label class="block text-xs mb-1">Naslov</label>
                                <input v-model="novaAnketa.naslov" type="text" required placeholder=""
                                    class="w-full border rounded p-2 outline-none focus:outline focus:outline-slate-300">
                            </div>
                            <div class="mb-6 md:w-full">
                                <label class="block text-xs mb-1">Opis</label>
                                <textarea v-model="novaAnketa.opis" type="text" required placeholder=""
                                    class="w-full border rounded p-2 outline-none focus:outline focus:outline-slate-300"></textarea>
                            </div>
                            <button
                                class="bg-apank-primary hover:bg-apank-secondary text-white text-sm font-semibold px-4 py-2 rounded">
                                Dodaj
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div v-else class="container mt-4 text-black bg-white rounded">
            <div class="pt-4 mb-8 relative">
                <div class="">
                    <h1 class="text-2xl py-2 px-1">Ankete</h1>
                    <button @click="toggleDodaj"
                        class="bg-apank-primary hover:bg-apank-secondary text-white text-sm font-semibold px-4 py-2 rounded">
                        Dodaj anketu
                    </button>
                </div>

                <div class="mt-5 pb-4 grid grid-cols-3 gap-4">
                    <div v-if="ankete.length" v-for="anketa in ankete">
                        <div
                            class="w-full h-full rounded overflow-hidden shadow-lg hover:cursor-pointer border bg-slate-200">
                            <div @click="$router.push('/anketa/' + anketa.idAnkete)" class="px-6 py-4">
                                <div class="font-bold text-xl mb-2">{{ anketa.naslov }}</div>
                                <p class="text-gray-700 text-base">
                                    {{ anketa.opis }}
                                </p>
                            </div>
                        </div>
                    </div>

                    <div v-else>
                        <p>Nema anketa za prikaz</p>
                    </div>
                </div>

            </div>
        </div>

    </main>

    <main v-else class="container text-white">
        <div class="pt-8 mb-8 relative">
            <h1 class="text-2xl text-center py-2 px-1">Molimo prijavite se u sustav!</h1>
        </div>
    </main>
</template>
  
<script>
import RequestHandler from "./../RequestHandler.js"
import { SPRING_URL } from "./../constants.js"

export default {
    data() {
        return {
            ankete: [],
            isDodajVisible: false,
            novaAnketa: {
                naslov: '',
                opis: '',
                email: ''
            }
        }
    },
    async mounted() {
        if (this.$store.state.user) {
            this.ankete = await RequestHandler.postRequest(SPRING_URL.concat('/korisnik/ankete'), { id: this.$store.state.user.email })
        }
    },
    methods: {
        toggleDodaj() {
            this.isDodajVisible = !this.isDodajVisible
        },
        async dodajNovuAnketu() {
            this.novaAnketa.email = this.$store.state.user.email
            await RequestHandler.postRequest(SPRING_URL.concat('/anketa/add'), this.novaAnketa)
            this.$router.go()
        }
    }
}
</script>