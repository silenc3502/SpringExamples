import {
  ADD_TODO,
  REMOVE_TODO,
  CLEAR_ALL,
  successGenRandNum,
  failGenRandNum,
  RESTORE,
  EDIT_TODO,
  SET_EDITING_ID,
  RESET_EDITING_ID,
  TOGGLE_TODO_STATUS,
  SET_FILTER
} from './mutation-types'

export default {
  [ADD_TODO] (state, payload) {
    const { content } = payload
    state.todoItems.push({ id: state.nextTodoId, content, done: false })
    state.nextTodoId++
  },
  [REMOVE_TODO] (state, id) {
    const targetIndex = state.todoItems.findIndex(v => v.id === id)
    state.todoItems.splice(targetIndex, 1)
  },
  [CLEAR_ALL] (state) {
    console.log('CLEAR_ALL')
    state.todoItems = []
  },
  [successGenRandNum] (state, payload) {
    console.log('payload = ' + payload)
    state.random = payload
  },
  [failGenRandNum] () {
    console.log('Error')
  },
  increment (state) {
    state.count++
  },
  decrement (state) {
    state.count--
  },
  [RESTORE] (state, { todoItems, nextTodoId }) {
    state.todoItems = todoItems
    state.nextTodoId = nextTodoId
  },
  [EDIT_TODO] (state, payload) {
    const { id, content } = payload
    const targetIndex = state.todoItems.findIndex(v => v.id === id)
    const targetTodoItem = state.todoItems[targetIndex]
    state.todoItems.splice(targetIndex, 1, { ...targetTodoItem, content })
  },
  [SET_EDITING_ID] (state, id) {
    state.editingId = id
  },
  [RESET_EDITING_ID] (state) {
    state.editingId = 0
  },
  [TOGGLE_TODO_STATUS] (state, id) {
    const filtered = state.todoItems.filter(todoItem => {
      return todoItem.id === id
    })

    filtered.forEach(todoItem => {
      todoItem.done = !todoItem.done
    })
  },
  [SET_FILTER] (state, filter) {
    state.filter = filter
  }
}
