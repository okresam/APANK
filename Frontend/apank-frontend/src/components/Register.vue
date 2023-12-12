<template>
    <div class="antialiased text-black">
        <div class="flex items-center  w-full">
            <div class="w-full bg-white rounded shadow-lg p-8 m-4 md:max-w-sm md:mx-auto">
                <span class="block w-full text-xl font-bold mb-4">Registracija</span>
                <form class="mb-4" action="/" method="post">
                    <div class="mb-4 md:w-full">
                        <label for="ime" class="block text-xs mb-1">Ime</label>
                        <input class="w-full border rounded p-2 outline-none focus:shadow-outline" type="text" name="ime"
                            id="ime" placeholder="Ivo">
                    </div>
                    <div class="mb-4 md:w-full">
                        <label for="prezime" class="block text-xs mb-1">Prezime</label>
                        <input class="w-full border rounded p-2 outline-none focus:shadow-outline" type="text" name="prezime"
                            id="prezime" placeholder="Ivić">
                    </div>
                    <div class="mb-4 md:w-full">
                        <label for="email" class="block text-xs mb-1">Email</label>
                        <input class="w-full border rounded p-2 outline-none focus:shadow-outline" type="email" name="email"
                            id="email" placeholder="example@fer.hr">
                    </div>
                    <div class="mb-6 md:w-full">
                        <label for="password" class="block text-xs mb-1">Lozinka</label>
                        <input class="w-full border rounded p-2 outline-none focus:shadow-outline" type="password"
                            name="password" id="password" placeholder="******">
                    </div>
                    <button
                        class="bg-apank-primary hover:bg-apank-secondary text-white text-sm font-semibold px-4 py-2 rounded">Registriraj se</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
import { SPRING_URL } from './../constants.js'

export default {

}
</script>