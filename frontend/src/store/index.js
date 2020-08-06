import Vue from 'vue'
import Vuex from 'vuex'
// import axios from 'axios'

import state from './states'
import actions from './actions'
import mutations from './mutations'
import getters from './getters'

Vue.use(Vuex)

export default new Vuex.Store({
  state,
  actions,
  mutations,
  getters
//  state: {
//    count: 0,
//    weight: 2,
//    random: 0,
//    todoItems: []
//  },
//  mutations: {
//    increment (state) {
//      state.count++
//    },
//    decrement (state) {
//      state.count--
//    },
//    successGenRandNum (state, payload) {
//      state.random = payload
//    },
//    failGenRandNum () {
//      alert('망함')
//    },
//    ADD_TODO (state, todoItems) {
//      state.todoItems.push(todoItems)
//    },
//    REMOVE_TODO (state, idx) {
//      state.todoItems.splice(idx, 1)
//    },
//    CLEAR_ALL (state) {
//      state.todoItems = []
//    }
//  },
//  getters: {
//    count (state, getters) {
//      return Math.pow(state.count, getters.weight)
//    },
//    weight (state) {
//      return state.weight
//    },
//    random (state) {
//      return state.random
//    }
//  },
//  actions: {
//    generateRandomNumber ({ commit }) {
//      console.log(commit)
//
//      axios.get('http://localhost:7777/random')
//        .then((res) => {
//          commit('successGenRandNum',
//            parseInt(res.data.randNumber))
//        })
//        .catch((res) => {
//          commit('failGenRandNum', res)
//        })
//    },
//    addTodo (context, payload) {
//      context.commit('ADD_TODO', payload)
//    },
//    removeTodo (context, payload) {
//      context.commit('REMOVE_TODO', payload)
//    },
//    clearAll (context, payload) {
//      context.commit('CLEAR_ALL')
//    }
//  },
//  modules: {
//  }
})
