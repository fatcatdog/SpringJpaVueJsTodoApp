<template>
  <div id="task-form">
  <h1>Add Task</h1>
    <form @submit.prevent="handleSubmit">
    <label>Task Name</label>
     <input
       ref="first"
       type="text"
       v-model="task.name"
     >
     <label>Task Description</label>
      <input
        ref="first"
        type="text"
        v-model="task.description"
      >
      <label>Task Due Date</label>

      <datepicker v-model="task.dueDate" placeholder="Select Date"></datepicker>

      <button type="submit" @click.stop.prevent="handleSubmit">Submit</button>
    </form>
  </div>
</template>

<script>
import Datepicker from 'vuejs-datepicker';
import router from '../main';

export default {
  name: 'task-form',

  components: {
    Datepicker,
  },

  data() {
    return {
      success: false,
      task: {
        name: '',
        description: '',
        dueDate: '',
        status: false,
      }
    }
  },
  methods: {
    handleSubmit() {
      this.addTask(this.task)
      this.task = {
        name: '',
        description: '',
        dueDate: '',
        status: false,
      }
    },
    async addTask(task) {
      try {
        const response = await fetch('http://localhost:8081/api/add', {
        method: 'POST',
        body: JSON.stringify(task),
        headers: { "Content-type": "application/json; charset=UTF-8" }
      })
        const data = await response.json()

        this.tasks = [...this.tasks, data]
      } catch (error) {
        console.error(error)
      }
      this.$router.push("/");
    },
  }}
</script>

<style scoped>
form {
  margin-bottom: 2rem;
}
[class*="-message"] {
  font-weight: 500;
}
.error-message {
  color: #d33c40;
}
.success-message {
  color: #32a95d;
}
</style>
