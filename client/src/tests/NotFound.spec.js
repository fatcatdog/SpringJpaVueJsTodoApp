// import { shallowMount } from '@vue/test-utils'
import { shallowMount, createLocalVue } from '@vue/test-utils'
import 'regenerator-runtime/runtime'
import NotFound from '../components/NotFound.vue'
import VueRouter from 'vue-router'

const localVue = createLocalVue()
localVue.use(VueRouter)
const router = new VueRouter()

let wrapper = shallowMount(NotFound, {
  localVue,
  router
})

describe('NotFound', () => {
  test('is a Vue instance', () => {
    expect(wrapper.isVueInstance()).toBeTruthy()
  })

  it('renders the correct markup', () => {
   expect(wrapper.html()).toContain('<p>Sorry it looks like this page does not exist. Please try click the link in the upper left corner of this page to go back :(</p>')
  })
})
