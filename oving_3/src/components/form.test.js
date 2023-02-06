import {test, expect} from 'vitest'
import { mount } from '@vue/test-utils'
import Calculator from './Calculator.vue'

test("mount component",async()=>{
    expect(Calculator).toBeTruthy();

    const wrapper = mount(Calculator);

    await wrapper.setProps({msg: "Calculator"})

    expect(wrapper.props().msg).toBe("Calculator");
 })