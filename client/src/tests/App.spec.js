// import { shallowMount } from '@vue/test-utils'
import { shallowMount, createLocalVue } from '@vue/test-utils'
import 'regenerator-runtime/runtime'
import App from '../App.vue'
import VueRouter from 'vue-router'

const localVue = createLocalVue()
localVue.use(VueRouter)
const router = new VueRouter()

const wrapper = shallowMount(App, {
  localVue,
  router
})

describe('App', () => {
  test('is a Vue instance', () => {
    expect(wrapper.isVueInstance()).toBeTruthy()
  })
})
