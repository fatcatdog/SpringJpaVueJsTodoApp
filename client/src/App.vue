<template>
  <div id="app"
    class="small-container"
  >
  <div class="title">
    <h1>ToDoApp</h1>
  </div>
  <nav>
    <div class="links">
      <router-link to='/'>Home(Task List)</router-link>
      <router-link to='/add'>Add Task</router-link>
    </div>
  </nav>
    <router-view />
  </div>
</template>

<script>


export default {
  name: 'app',
  }
</script>

<style>

.small-container {
  max-width: 680px;
}

.title {
 text-align: center
}

.links {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
 }
</style>
