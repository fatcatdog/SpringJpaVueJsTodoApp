import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import Datepicker from 'vuejs-datepicker';

import moment from 'moment'
import routes from './routes';

//You will notice VueRouter is used here to help with navigation
//as well as Moment to assist with rendering dates in a readable format.

Vue.config.productionTip = false

Vue.prototype.moment = moment

Vue.use(VueRouter)

const router = new VueRouter({mode: 'history', routes});

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
