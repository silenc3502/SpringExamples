<template>
  <div class="todo">
    <todo-header></todo-header>
    <todo-input v-on:addTodo="addTodo"></todo-input>
    <todo-list v-bind:todoItems="todoItems"
              v-on:removeTodo="removeTodo"></todo-list>
    <todo-footer v-on:removeAll="clearAll"></todo-footer>
  </div>
</template>

<script>
import TodoHeader from '../components/TodoHeader.vue'
import TodoInput from '../components/TodoInput.vue'
import TodoList from '../components/TodoList.vue'
import TodoFooter from '../components/TodoFooter.vue'
import store from '../store'

export default {
  name: 'Todo',
  components: {
    'todo-header': TodoHeader,
    'todo-input': TodoInput,
    'todo-list': TodoList,
    'todo-footer': TodoFooter
  },
  // data () {
  //   return {
  //     todoItems: []
  //   }
  // },
  methods: {
    clearAll () {
      this.todoItems = []
    },
    addTodo (todoItem) {
      this.todoItems.push(todoItem)
    },
    removeTodo (todoItem, idx) {
      this.todoItems.splice(idx, 1)
    }
  },
  computed: {
    todoItems () {
      return store.state.todoItems
    }
  }
}
</script>

<style>
  body {
    text-align: center;
    background-color: #CEDEBD;
  }
</style>
