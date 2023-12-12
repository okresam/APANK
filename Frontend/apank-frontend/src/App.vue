<template>
  <div class="flex flex-col min-h-screen font-Roboto bg-apank-secondary">
    <Navbar />
    <router-view />
  </div>
</template>

<script>
import Navbar from './components/Navbar.vue'

export default {
  components: {
    Navbar
  }
}
</script>
