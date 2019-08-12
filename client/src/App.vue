<template>
  <div
    id="app"
    class="small-container"
  >
    <h1>Tasks</h1>

    <task-list
      :tasks="tasks"
    />
    <task-form @add:task="addTask" />

  </div>
</template>

<script>
import TaskList from './components/TaskList.vue'
import TaskForm from './components/TaskForm.vue'

export default {
  name: 'app',
  components: {
    TaskList,
    TaskForm,
  },
  data() {
    return {
      tasks: [],
    }
  },

  mounted() {
    this.getTasks()
  },

  methods:{
  async getTasks() {
       try {
         const response = await fetch('http://localhost:8080/api')
         const data = await response.json()
         this.tasks = data
       } catch (error) {
         console.error(error)
       }
     },
     async addTask(task) {
      try {
        const response = await fetch('http://localhost:8080/api/add', {
          method: 'POST',
          body: JSON.stringify(task),
          headers: { "Content-type": "application/json; charset=UTF-8" }
        })
        const data = await response.json()
        this.tasks = [...this.tasks, data]
      } catch (error) {
        console.error(error)
      }
    },
  },
}
</script>

<style>

.small-container {
  max-width: 680px;
}
</style>
