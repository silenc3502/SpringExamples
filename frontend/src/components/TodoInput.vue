<template>
  <div>
    <h3>Todo Input</h3>
    <input type="text" v-model="newTodoItem"
        v-on:keypress.enter="addTodo">
    <button v-on:click="addTodo">Add</button>
  </div>
</template>

<script>

export default {
  data () {
    return {
      newTodoItem: ''
    }
  },
  methods: {
    addTodo () {
      if (this.newTodoItem !== '') {
        this.newTodoItem.trim()
        console.log('addTodo')
        this.clearInput()
      }
    },
    clearInput () {
      this.newTodoItem = ''
    }
  }
}

</script>

// css를 보면 스타일링을 좀 더 할 수 있다.
<style scoped>
  div {
    background-color: #77cc34
  }
</style>
