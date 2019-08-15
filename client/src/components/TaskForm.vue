<template>
  <div id="task-form">
  <h1>Add Task</h1>
    <form @submit.prevent="handleSubmit">
    <label>Task Name</label>
     <input
       ref="first"
       type="text"
       v-model="task.name"
       :class="{ 'has-error': submitting && invalidName }"
       @focus="clearStatus"
       @keypress="clearStatus"
     >
     <label>Task Description</label>
      <input
        ref="first"
        type="text"
        v-model="task.description"
        :class="{ 'has-error': submitting && invalidDescription }"
        @focus="clearStatus"
        @keypress="clearStatus"
      >
      <label>Task Due Date</label>

      <datepicker
        v-model="task.dueDate"
        placeholder="Select Date"
        :class="{ 'has-error': submitting && invalidDueDate }"
        @focus="clearStatus"
        @keypress="clearStatus"
      >
        </datepicker>
        <p v-if="error && submitting" class="error-message">
            Please fill out all required fields. It looks like one of the fields is empty :(
          </p>
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
      submitting: false,
      error: false,
      success: false,
      task: {
        name: '',
        description: '',
        dueDate: '',
        status: false,
      },
    }
  },
  methods: {
    handleSubmit() {
      this.submitting = true
      this.clearStatus()

      if (this.invalidName || this.invalidDescription || this.invalidDueDate || this.invalidStatus) {
         this.error = true
         return
       }

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
      } catch (error) {
        console.error(error);
      }
      this.$router.push("/");
    },
    clearStatus() {
      this.success = false
      this.error = false
    },
  },
  computed: {
    invalidName() {
      return this.task.name === ''
    },
    invalidDescription() {
      return this.task.description === ''
    },
    invalidDueDate() {
      return this.task.dueDate === ''
    },
    invalidStatus() {
      return this.task.status === ''
    },
  },
  }
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
[class*='-message'] {
  font-weight: 500;
}
.error-message {
  color: #d33c40;
}
</style>
