import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import Datepicker from 'vuejs-datepicker';

import moment from 'moment'
import routes from './routes';

Vue.config.productionTip = false

Vue.prototype.moment = moment

Vue.use(VueRouter)

const router = new VueRouter({mode: 'history', routes});

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')



// <my-header></my-header>
// <router-view></router-view>
//
// <task-list
//   :tasks="tasks"
// />
// <task-form @add:task="addTask" />

//
// name: 'app',
// components: {
//   'my-header':Header,
//   TaskList,
//   TaskForm,
// },

// export default {
//   name: 'app',
//
//   data() {
//     return {
//       tasks: [],
//     }
//   },
//
//   mounted() {
//     this.getTasks()
//   },
//
//   methods:{
//   async getTasks() {
//        try {
//          const response = await fetch('http://localhost:8081/api')
//          const data = await response.json()
//          this.tasks = data
//        } catch (error) {
//          console.error(error)
//        }
//      },
//      async addTask(task) {
//       try {
//         const response = await fetch('http://localhost:8081/api/add', {
//           method: 'POST',
//           body: JSON.stringify(task),
//           headers: { "Content-type": "application/json; charset=UTF-8" }
//         })
//         const data = await response.json()
//         this.tasks = [...this.tasks, data]
//       } catch (error) {
//         console.error(error)
//       }
//     },
//   },
// }
// </script>
//
// <style>
//
// .small-container {
//   max-width: 680px;
// }
//
// .title {
//  text-align: center
// }
//
// .links {
//   display: flex;
//   justify-content: space-between;
//   margin-bottom: 20px;
//  }
// </style>









/////////////////////////////////
// name: 'task-form',
// components: {
//     Datepicker,
//   },
//   data() {
//     return {
//       error: false,
//       submitting: false,
//       success: false,
//       task: {
//         name: '',
//         description: '',
//         dueDate: '',
//       },
//     }
//   },
//   methods:{
//      async addTask(task) {
//       try {
//         const response = await fetch('http://localhost:8081/api/add', {
//           method: 'POST',
//           body: JSON.stringify(task),
//           headers: { "Content-type": "application/json; charset=UTF-8" }
//         })
//         const data = await response.json()
//         this.tasks = [...this.tasks, data]
//       } catch (error) {
//         console.error(error)
//       }
//     },
//     handleSubmit() {
//       this.clearStatus()
//       this.submitting = true
//
//       this.$emit('add:task', this.task)
//       this.$refs.first.focus()
//       this.task = {
//         name: '',
//         description: '',
//         dueDate: '',
//       }
//       this.success = true
//       this.error = false
//       this.submitting = false
//     },
//     clearStatus() {
//       this.success = false
//       this.error = false
//      }
//      },
/////////////////////////////////////////
