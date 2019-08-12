<template>
  <div id="task-form">
  <h1>Add Task</h1>
    <form @submit.prevent="handleSubmit">
    <label>Task Name</label>
     <input
       ref="first"
       type="text"
       v-model="task.name"
       @focus="clearStatus"
       @keypress="clearStatus"
     >
     <label>Task Description</label>
      <input
        ref="first"
        type="text"
        v-model="task.description"
        @focus="clearStatus"
        @keypress="clearStatus"
      >
      <label>Task Due Date</label>
       <input
         ref="first"
         type="text"
         v-model="task.dueDate"
         @focus="clearStatus"
         @keypress="clearStatus"
       >
       <label>Task Current Stage</label>
        <input
          ref="first"
          type="text"
          v-model="task.stage"
          @focus="clearStatus"
          @keypress="clearStatus"
        >
        <button>Add Task</button>
    </form>

  </div>
</template>

<script>
export default {
  name: 'task-form',
  data() {
    return {
      error: false,
      submitting: false,
      success: false,
      task: {
        name: '',
        description: '',
        dueDate: '',
        stage: '',
      }
    }
  },


  methods: {
    handleSubmit() {
      this.clearStatus()
      this.submitting = true

      this.$emit('add:task', this.task)
      this.$refs.first.focus()
      this.task = {
        name: '',
        description: '',
        dueDate: '',
        stage: '',
      }
      this.success = true
      this.error = false
      this.submitting = false
    },
    clearStatus() {
      this.success = false
      this.error = false
    }
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
