<template>
    <header class="top-0 bg-apank-primary shadow-lg">
      <nav class="container flex flex-col sm:flex-row items-center gap-4 text-white py-6">
        <RouterLink :to="{ name: 'home' }">
          <div class="flex items-center gap-3">
            <p class="text-2xl">APANK</p>
          </div>
        </RouterLink>
        
        <div class="flex gap-10 flex-1 justify-end">
          <RouterLink :to="{ name: 'Login' }">
            <p class="text-xl hover:text-gray-300">Prijava</p>
          </RouterLink>
          <RouterLink :to="{ name: 'Register' }">
            <p class="text-xl hover:text-gray-300">Registracija</p>
          </RouterLink>
        </div>
      </nav>
    </header>
</template>
  
<script>
import { RouterLink } from 'vue-router';

</script>