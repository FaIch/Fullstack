import {test, expect} from 'vitest'
import { mount } from '@vue/test-utils'
import { createStore } from 'vuex'
import Form from '../Form.vue'

test("mount component, and pass prop",async()=>{
    expect(Form).toBeTruthy();

    const mockStore = createStore({
        state: {
            name: "",
            email: ""
          },
          getters: {
          },
          mutations: {
            SET_NAME(state, name){
              state.name = name
            },
        
            SET_EMAIL(state, email){
              state.email = email
            }
          },
    })

    const wrapper = mount(Form, {
        global: {
            plugins: [mockStore]
        }
    });

    await wrapper.setProps({msg: "Form test"})

    expect(wrapper.props().msg).toBe("Form test");
 })