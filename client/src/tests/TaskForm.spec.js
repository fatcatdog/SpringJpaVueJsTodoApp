// import { shallowMount } from '@vue/test-utils'
import { shallowMount, createLocalVue } from '@vue/test-utils'
import 'regenerator-runtime/runtime'
import TaskForm from '../components/TaskForm.vue'

import VueRouter from 'vue-router'

const localVue = createLocalVue()
localVue.use(VueRouter)
const router = new VueRouter()

let wrapper = shallowMount(TaskForm, {
  localVue,
  router
})

describe('TaskForm', () => {
  test('is a Vue instance', () => {
    expect(wrapper.isVueInstance()).toBeTruthy()
  })
})
