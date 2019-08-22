// import { shallowMount } from '@vue/test-utils'
import { shallowMount, createLocalVue } from '@vue/test-utils'
import 'regenerator-runtime/runtime'
import TaskList from '../components/TaskList.vue'
import VueRouter from 'vue-router'

const localVue = createLocalVue()
localVue.use(VueRouter)
const router = new VueRouter()

let wrapper = shallowMount(TaskList, {
  localVue,
  router
})

let dummyData = [
  {
    "id": 1,
    "name": "first task",
    "description": "first description",
    "dueDate": "2019-08-21T22:15:49.000+0000",
    "code": 1,
    "status": false
  },
  {
    "id": 2,
    "name": "second task",
    "description": "second description second description second description second description",
    "dueDate": "2009-12-31T05:00:00.000+0000",
    "code": 2,
    "status": true
  }
]

describe('TaskList', () => {
  test('is a Vue instance', () => {
    expect(wrapper.isVueInstance()).toBeTruthy()
  })

  it('displays a list of tasks when component is mounted', () => {
   wrapper.vm.$emit('tasks')
   wrapper.vm.$emit('tasks', dummyData)

   expect(wrapper.emitted().tasks.length).toBe(2)
})
})
