import TaskList from './components/TaskList.vue';
import TaskForm from './components/TaskForm.vue';
import TaskUpdate from './components/TaskUpdate.vue';
import TaskView from './components/TaskView.vue';
import NotFound from './components/NotFound.vue';

//our app's routes

const routes = [
  { path: '/', component: TaskList },
  { path: '/add', component: TaskForm },
  { path: '/update/:id', component: TaskUpdate },
  { path: '/view/:id', component: TaskView },
  { path: '*', component: NotFound }
];

export default routes;
