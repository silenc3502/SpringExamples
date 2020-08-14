export default {
  filteredTodoItems (state) {
    if (!state.filter) {
      return state.todoItems
    }

    if (state.filter === 'A') {
      return state.todoItems.filter(todoItem => {
        return todoItem.done === false
      })
    }

    if (state.filter === 'B') {
      return state.todoItems.filter(todoItem => {
        return todoItem.done === true
      })
    }
  },
  count (state, getters) {
    return Math.pow(state.count, getters.weight)
  },
  weight (state) {
    return state.weight
  },
  random (state) {
    return state.random
  },
  isAuthorized (state) {
    return state.accessToken.length > 0 && !!state.myinfo
  }
}
