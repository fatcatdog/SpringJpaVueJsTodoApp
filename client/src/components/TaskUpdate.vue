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
      <!-- We used VueJsDatePicker to render the fancy calendar on this page -->

      <datepicker v-model="task.dueDate" placeholder="Select Date"></datepicker>
      <label>Task Status (If complete please check box)</label>
       <input
         ref="first"
         type="checkbox"
         v-model="task.status"
       >
       <p></p>
       <!-- This v-if statement renders an error if present  -->
       <div>
         <p v-if="error && submitting" class="error-message">
             Please fill out all required fields. It looks like one of the fields is empty :(
         </p>
       </div>
       <div class="updateButtonLeft">
          <button type="submit" @click.stop.prevent="handleSubmit">Update</button>
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
    //these variables are used to assist error handling
      submitting: false,
      error: false,
    //our task object is what we really care about here
      task: {
        name: '',
        description: '',
        dueDate: '',
        status: ''
      }
    }
  },
  mounted() {
  //loading correct task that user wants to update with a fetch to RestAPI
    this.getTask()
  },
  methods: {
    handleSubmit() {
    //error handling portion (just checking if not == "")
      this.submitting = true
      this.clearStatus()

      if (this.invalidName || this.invalidDescription || this.invalidDueDate || this.invalidStatus) {
         this.error = true
         return
       }
       //sending post to REST API

      this.addTask(this.task)

      //reseting empty object for form
      this.task = {
        name: '',
        description: '',
        dueDate: '',
        status: ''
      }
    },
    //our GET method to fetch from DB with user selected id from taskList from url param
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
    //our POST method to REST API fetch
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
    //our DELETE method for REST API fetch
    async deleteTask(){
      const task = this.task;
      try {
        const response = await fetch('http://localhost:8081/api/delete', {
        method: 'DELETE',
        body: JSON.stringify(task),
        headers: { "Content-type": "application/json; charset=UTF-8" }
      })
        const data = await response.json()
      } catch (error) {
        console.error(error);
      }
      this.$router.push("/");
    },
    //resetting error messages
    clearStatus() {
      this.error = false
    },
  },
  //our computed methods to help with error handling
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
//our styling
<style scoped>
form {
  margin-bottom: 2rem;
}
[class*="-message"] {
  font-weight: 500;
}
.error-message {
  color: red;
}

.updateButtonRight{
  float: right;
}

.updateButtonLeft{
  float: left;
}

</style>
