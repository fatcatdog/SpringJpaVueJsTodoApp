// import { shallowMount } from '@vue/test-utils'
import { shallowMount } from '@vue/test-utils'
import 'regenerator-runtime/runtime'
import TaskView from '../components/TaskView.vue'

describe('TaskView', () => {
  test('is a Vue instance', () => {
    const wrapper = shallowMount(TaskView)
    expect(wrapper.isVueInstance()).toBeTruthy()
  })
})
