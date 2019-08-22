//this page renders our task list to users
<template>
  <div id="task-list" class="task-list">
      <h1>Task List</h1>

      <div v-if="this.apiIsDown === true">
      <p>It looks like the API is down currently. Please try again later</p>
      </div>
      <div v-else>
      <!--Buttons to allow user to manipulate table-->
      <button v-on:click="refreshList">Refresh All Tasks</button>
      <p>(After sorting with one of the below buttons, please refresh to see all tasks)</p>
      <div class="sortingOptions">
        <button v-on:click="getNotCompleted">Not Complete</button>
        <button v-on:click="getCompleted">Completed</button>
        <button v-on:click="getToday">Due Today</button>
        <button v-on:click="getTomorrow">Due Tomorrow</button>
        <button v-on:click="getOutdated">Past Due</button>
      </div>
      <div class="tableStyles">
      <div v-if="tasks.length < 1">
        <p>It looks like we don't have any tasks yet.</p>
        <p>You can add one by clicking the link in the upper right hand corner!</p>
      </div>
      <div v-else>
      <thead>
      <!--Table headers-->
        <tr>
          <th>Code</th>
          <th>Name</th>
          <th>Description</th>
          <th>Due Date</th>
          <th>Completed</th>
        </tr>
      </thead>
      <tbody class="ourTable" id="ourTable">
        <tr
            :key="task.id"
            v-for="task in tasks"
          >
          <!--Information in each table column-->
            <td><router-link :to="{ path: '/view/' + task.code }"><a>{{ task.code }}</a></router-link></td>
            <td>{{ task.name }}</td>
            <td>{{ task.description }}</td>
            <td>{{ moment(task.dueDate).format('MM/DD/YYYY') }}</td>
            <td>{{ task.status }}</td>
            <!--This passes task.id to url param for updating task. We could have passed object as a prop to reduce unneccesary fetching but i didn't do that.-->
            <td><router-link :to="{ path: '/update/'+ task.id }"><a>Update</a></router-link></td>
          </tr>
        </tbody>
    </table>
    </div>
    </div>
  </div>
  </div>
</template>

<script>
  export default {
    name: 'task-list',
    data() {
      return {
        apiIsDown: false,
        tasks: [],
      }
    },
    updated() {
      this.addOutdatedStyling()
    },
    mounted(){
       this.getTasks()
    },
    methods:{
    //our REST API fetch all tasks
      async getTasks() {
           try {
             const response = await fetch('http://localhost:8081/api/tasks')
             const data = await response.json()
             this.tasks =  data
           } catch (error) {
             this.apiIsDown = true;
             reject(error)
           }
         },
         //checking if date is today
      async getToday() {
        const results = this.tasks.filter(task => ((new Date(task.dueDate).getDate() == new Date().getDate()) && (new Date(task.dueDate).getMonth() == new Date().getMonth())));
        this.tasks = results;
      },
      //checking if date is tomorrow
      async getTomorrow() {
        const results = this.tasks.filter(task => ((new Date(task.dueDate).getDate() == new Date().getDate() + 1) && (new Date(task.dueDate).getMonth() == new Date().getMonth())));
        this.tasks = results;
      },
      //checking is status is not complete
      async getNotCompleted() {
        const results = this.tasks.filter(task => task.status == false);
        this.tasks = results;
      },
      //checking is status is complete
      async getCompleted() {
        const results = this.tasks.filter(task => task.status == true);
        this.tasks = results;
      },
      //checking is date is in the past (there are edge cases where this breaks)
      async getOutdated() {
        const results = this.tasks.filter(task => (((new Date(task.dueDate).getDate() < new Date().getDate()) && (new Date(task.dueDate).getMonth() <= new Date().getMonth())) || (new Date(task.dueDate).getYear() < new Date().getYear())));
        this.tasks = results;
      },
      //refreshing task list
      async refreshList() {
        this.getTasks()
      },
      //ive never done this before. We are looking over inner html values of date
      //to check if they are in the past and then adding red styling to show user they are outdated
      //checking is date is in the past (there are edge cases where this breaks)
      async addOutdatedStyling() {
        var table = document.getElementById("ourTable");
        for (let row of table.rows)
          {
              for(let cell of row.cells)
              {
              if(/^\d{1,2}\/\d{1,2}\/\d{4}$/.test(cell.innerText)){
                const ourTempDate = new Date(cell.innerText);

                //if dates in the past color is red
                if (((ourTempDate.getDate() < new Date().getDate()) && ((ourTempDate.getMonth() <= new Date().getMonth())) && (ourTempDate.getYear() < new Date().getYear()))  || (ourTempDate.getYear() < new Date().getYear())) {
                  cell.style.color = "red";
                } else if (((ourTempDate.getDate() == new Date().getDate()) && ((ourTempDate.getMonth() == new Date().getMonth())) && (ourTempDate.getYear() == new Date().getYear()))) {
                //if todays date color is green
                  cell.style.color = "green";
                } else {
                //if future date color is blue
                  cell.style.color = "blue";
                }
              }
              }
          }
      },
  },
}
</script>

<style scoped>

.task-list {
  text-align: center;
}
.sortingOptions{
margin-bottom: 20px;
}
.tableStyles{
  margin-left:10%;
  margin-right:10%;

}
</style>
