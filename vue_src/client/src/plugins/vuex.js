import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export const store = new Vuex.Store({
  state: {
    drawer:true
  },
  mutations: {
    toggle (state, n) {
      state.drawer=n
    }
  },
  actions: {
  },
  modules: {
  }
})
