import {
  successGenRandNum,
  failGenRandNum,
  ADD_TODO,
  REMOVE_TODO,
  CLEAR_ALL
} from './mutation-types'

import axios from 'axios'

export default {
  generateRandomNumber ({ commit }) {
    console.log(commit)

    axios.get('http://localhost:7777/random')
      .then((res) => {
        commit(successGenRandNum,
          parseInt(res.data.randNumber))
      })
      .catch((res) => {
        commit(failGenRandNum, res)
      })
  },
  addTodo (context, payload) {
    context.commit(ADD_TODO, payload)
  },
  removeTodo (context, payload) {
    context.commit(REMOVE_TODO, payload)
  },
  clearAll (context, payload) {
    context.commit(CLEAR_ALL)
  }
}
// actions: {
//  generateRandomNumber ({ commit }) {
//    console.log(commit)
//
//    axios.get('http://localhost:7777/random')
//      .then((res) => {
//        commit('successGenRandNum',
//          parseInt(res.data.randNumber))
//      })
//      .catch((res) => {
//        commit('failGenRandNum', res)
//      })
//  },
//  addTodo (context, payload) {
//    context.commit('ADD_TODO', payload)
//  },
//  removeTodo (context, payload) {
//    context.commit('REMOVE_TODO', payload)
//  },
//  clearAll (context, payload) {
//    context.commit('CLEAR_ALL')
//  }
