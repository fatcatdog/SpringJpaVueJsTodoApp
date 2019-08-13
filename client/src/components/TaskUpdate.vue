<template>
  <div id="task-update">
  <h1>Update Task</h1>
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
      <label>Task Status (If complete please check box)</label>
       <input
         ref="first"
         type="checkbox"
         v-model="task.status"
       >
       <p></p>
       <div class="updateButtonLeft">
      <button type="submit" @click.stop.prevent="handleSubmit">Submit</button>
      </div>
      <div class="updateButtonRight">
      <button type="submit" @click.stop.prevent="deleteTask">Delete</button>
      </div>

    </form>
  </div>
</template>

<script>
import Datepicker from 'vuejs-datepicker';

export default {
  name: 'task-update',

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
        status: ''
      }
    }
  },
  mounted() {
    this.getTask()
  },
  methods: {
    handleSubmit() {
      this.addTask(this.task)
      this.task = {
        name: '',
        description: '',
        dueDate: '',
        status: ''
      }
    },
    async getTask(task) {
      const tempId = this.$route.params.id;
      try {
        const response = await fetch('http://localhost:8081/api/get/' + Number(tempId))
        const data = await response.json()
        this.task = data
      } catch (error) {
        console.log(error)
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
    async deleteTask(){
      console.log("deleted");
      const task = this.task;

      console.log("id: " + task.id);
      console.log("name: " + task.name);
      console.log("dueDate: " + task.dueDate);
      console.log("description: " + task.description);
      console.log("status: " + task.status);

      try {
        const response = await fetch('http://localhost:8081/api/delete', {
        method: 'DELETE',
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

.updateButtonRight{
float: right;
}

.updateButtonLeft{
float: left;
}

</style>
