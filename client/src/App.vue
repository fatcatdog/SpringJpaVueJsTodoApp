//this is our main app page for our user
<template>
  <div id="app" class="small-container">
    <!-- Header component -->
    <app-header />

    <!-- Enabling React Router -->
    <!-- All of our functional components live inside of here -->
    <router-view />

    <!-- Footer component -->
    <app-footer />
  </div>
</template>

<script>
import Footer from '@/components/Footer'
import Header from '@/components/Header'

export default {
  name: 'app',
  components: {
    'app-header': Header,
    'app-footer' : Footer
  }
  }
</script>

<style>

.small-container {
  max-width: 900px;
}

.title {
 text-align: center
}

.links {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
 }

 .footer {
   text-align: center;
   margin-top: 250px;
 }
</style>
