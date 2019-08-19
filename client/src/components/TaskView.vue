//this page allows users to view a task in detail
<template>
  <div id="task-view">
  <div class="sectionheader">
    <h1>Task Code: {{task.code}}</h1>
  </div>

  <div v-if="task.name === ''">
    <div class="sectionbody">
      <p>It looks like we don't have an image with this code.</p>
      <p>Please go back to view all tasks :)</p>
    </div>

  </div>
  <div v-else>

    <div class="sectionheader">
      <h3>Task Name</h3>
    </div>

    <div class="sectionbody">
      {{task.name}}
    </div>

    <div class="sectionheader">
      <h3>Task Description</h3>
    </div>

    <div class="sectionbody">
      {{task.description}}
    </div>

    <!-- We used VueJsDatePicker to render the fancy calendar on this page -->
    <!-- moment formats the string for us -->

    <div class="sectionheader">
      <h3>Task Due Date</h3>
    </div>

    <div class="sectionbody">
    {{ moment(task.dueDate).format('MM/DD/YYYY') }}
    </div>

    <div class="sectionheader">
        <h3>Status</h3>
    </div>

    <div class="sectionbody">
      Completed status: {{task.status}}
    </div>
    </div>

  </div>
</template>

<script>

export default {
  name: 'task-view',

  data() {
    return {
    //our task object is what we really care about here
      task: {
        name: '',
        description:  '',
        dueDate: '',
        code: '',
        status:  ''
      }
    }
  },
  mounted() {
  //loading correct task that user wants to view with a fetch to RestAPI
  //also checking if we should forward over 404 page if input is not valid
    this.init()
  },
  methods: {
    async init(){
      this.getTask()
    },

    //our GET method to fetch from DB with user selected id from taskList from url param
    async getTask(task) {
      const tempId = this.$route.params.id;

      try {
        const response = await fetch('http://localhost:8081/api/code/' + Number(tempId))
        const data = await response.json()
        this.task = data
      } catch (error) {
        console.log(error)
      }
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

.sectionheader {
  text-align: center;
}

.sectionbody {
  text-align: center;
}

</style>
