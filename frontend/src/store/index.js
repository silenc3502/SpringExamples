import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count: 0,
    weight: 2,
    random: 0
  },
  mutations: {
    increment (state) {
      state.count++
    },
    decrement (state) {
      state.count--
    },
    successGenRandNum (state, payload) {
      state.random = payload
    },
    failGenRandNum () {
      alert('망함')
    }
  },
  getters: {
    count (state, getters) {
      return Math.pow(state.count, getters.weight)
    },
    weight (state) {
      return state.weight
    },
    random (state) {
      return state.random
    }
  },
  actions: {
    generateRandomNumber ({ commit }) {
      console.log(commit)

      axios.get('http://localhost:7777/random')
        .then((res) => {
          commit('successGenRandNum',
            parseInt(res.data.randNumber))
        })
        .catch((res) => {
          commit('failGenRandNum', res)
        })
    }
  },
  modules: {
  }
})
