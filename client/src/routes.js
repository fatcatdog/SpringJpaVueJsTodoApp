import TaskList from './components/TaskList.vue';
import TaskForm from './components/TaskForm.vue';
import TaskUpdate from './components/TaskUpdate.vue';

//our app's routes

const routes = [
  { path: '/', component: TaskList },
  { path: '/add', component: TaskForm },
  { path: '/update/:id', component: TaskUpdate },
  { path: '/delete/:id', component: TaskUpdate },
];

export default routes;
