//this is our header component
<template>
  <div id="header" class="small-container">
  <!-- our app's title -->
  <div class="title">
    <h1>TaskApp</h1>
  </div>
  <!-- this is our app's header nav links -->
  <nav>
    <div class="links">
      <router-link to='/'>Home(Task List)</router-link>
      <router-link to='/add'>Add Task</router-link>
    </div>
  </nav>
  </div>
</template>

<script>

export default {
  name: 'Header',
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
