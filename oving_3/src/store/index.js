import { createStore } from 'vuex'

export default createStore({
  state: {
    name: "",
    email: "",
  },
  getters: {
  },
  mutations: {
    SET_DATA(state, name, email){
        state.name = name;
        state.email = email;
    }
  },
  actions: {
  },
  modules: {
  }
})