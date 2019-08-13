<template>
  <div id="task-list" class="task-list">
      <h1>Task List</h1>
      <div id="sortingOptions">
        <button v-on:click="refreshList">Refresh All Tasks</button>
        <button v-on:click="getToday">Due Today</button>
        <button v-on:click="getTomorrow">Due Tomorrow</button>
      </div>
      <thead>
        <tr>
          <th>Name</th>
          <th>Description</th>
          <th>Due Date</th>
          <th>Completed</th>
          <th>Update</th>
        </tr>
      </thead>
      <tbody>
        <tr
            :key="task.id"
            v-for="task in tasks"
          >
            <td>{{ task.name }}</td>
            <td>{{ task.description }}</td>
            <td>{{ moment(task.dueDate).format('YYYY-MM-DD') }}</td>
            <td>{{ task.status }}</td>
            <td><router-link :to="{ path: '/update/'+ task.id }"><a>Update</a></router-link></td>
          </tr>
        </tbody>
    </table>
  </div>
</template>

<script>
  export default {
    name: 'task-list',
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
             const response = await fetch('http://localhost:8081/api')
             const data = await response.json()
             this.tasks = data
           } catch (error) {
             console.error(error)
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
    },
      async getToday() {
        const results = this.tasks.filter(task => ((new Date(task.dueDate).getDate() == new Date().getDate()) && (new Date(task.dueDate).getMonth() == new Date().getMonth())));
        this.tasks = results;
      },
      async getTomorrow() {
        const results = this.tasks.filter(task => ((new Date(task.dueDate).getDate() == new Date().getDate() + 1) && (new Date(task.dueDate).getMonth() == new Date().getMonth())));
        this.tasks = results;
      },
      async refreshList() {
        this.getTasks()
      },
  },
}
</script>

<style scoped>

.task-list {
  text-align: center;
}
.sortingOptions{

}
</style>
