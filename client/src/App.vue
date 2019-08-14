<template>
  <div id="app"
    class="small-container"
  >
  <div class="title">
    <h1>TaskApp</h1>
  </div>
  <nav>
  <!-- this is our app's header -->
    <div class="links">
      <router-link to='/'>Home(Task List)</router-link>
      <router-link to='/add'>Add Task</router-link>
    </div>
  </nav>
  <!-- Enabling React Router -->
    <router-view />
    <div class="footer">
      <p>Created with love by Jake Duchen</p>
    </div>
  </div>
</template>

<script>


export default {
  name: 'app',
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
 margin-top: 100px;
 }
</style>
