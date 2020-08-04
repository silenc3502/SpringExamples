import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count: 0,
    weight: 2
  },
  mutations: {
    increment (state) {
      state.count++
    },
    decrement (state) {
      state.count--
    }
  },
  getters: {
    count (state, getters) {
      return Math.pow(state.count, getters.weight)
    },
    weight (state) {
      return state.weight
    }
  },
  actions: {
  },
  modules: {
  }
})
