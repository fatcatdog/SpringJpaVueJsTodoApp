// import { shallowMount } from '@vue/test-utils'
import { shallowMount, createLocalVue } from '@vue/test-utils'
import 'regenerator-runtime/runtime'
import Footer from '../components/Footer.vue'
import VueRouter from 'vue-router'

const localVue = createLocalVue()
localVue.use(VueRouter)
const router = new VueRouter()

const wrapper = shallowMount(Footer, {
  localVue,
  router
})

describe('Footer', () => {
  test('is a Vue instance', () => {
    expect(wrapper.isVueInstance()).toBeTruthy()
  })

  it('renders the correct markup', () => {
   expect(wrapper.html()).toContain('<p>Created with love by Jake Duchen</p>')
 })
})
