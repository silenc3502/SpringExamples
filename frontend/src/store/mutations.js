import {
  successGenRandNum,
  failGenRandNum,
  ADD_TODO,
  REMOVE_TODO,
  CLEAR_ALL,
  RESTORE,
  EDIT_TODO,
  SET_EDITING_ID,
  RESET_EDITING_ID,
  TOGGLE_TODO_STATUS,
  SET_FILTER
} from './mutation-types'

export default {
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
  },
  [SET_EDITING_ID] (state, id) {
    state.editingId = id
  },
  [RESET_EDITING_ID] (state) {
    state.editingId = 0
  },
  [EDIT_TODO] (state, payload) {
    const { id, content } = payload
    const targetIdx = state.todoItems.findIndex(v => v.id === id)
    const targetTodoItem = state.todoItems[targetIdx]
    // JavaScript에서 ...은 배열등에서 값을 가져올 때
    // 아직 처리하지 않은게 있다면 남은 모든것을 가져온다.
    state.todoItems.splice(targetIdx, 1, { ...targetTodoItem, content })
  },
  [RESTORE] (state, { todoItems, nextTodoId }) {
    state.todoItems = todoItems
    state.nextTodoId = nextTodoId
  },
  increment (state) {
    state.count++
  },
  decrement (state) {
    state.count--
  },
  [successGenRandNum] (state, payload) {
    state.random = payload
  },
  [failGenRandNum] () {
    alert('망함')
  },
  [ADD_TODO] (state, todoItem) {
    state.todoItems.push(todoItem)
  },
  [REMOVE_TODO] (state, idx) {
    state.todoItems.splice({ id: state.nextTodoId, content, done: false })
  },
  [CLEAR_ALL] (state) {
    state.todoItems = []
  }
}
