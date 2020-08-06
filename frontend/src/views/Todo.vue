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
// import store from '../store'
import { mapState, mapActions } from 'vuex'

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
    ...mapActions([
      'clearAll',
      'addTodo',
      'removeTodo'
    ]),
    onClearAll () {
      this.clearAll()
    },
    onAddTodo (todoItem) {
      this.addTodo(todoItem)
    },
    onRemoveTodo (todoItem, idx) {
      this.removeTodo(idx)
    }
    // clearAll () {
    //   this.todoItems = []
    //   store.dispatch('clearAll')
    // },
    // addTodo (todoItem) {
    //   this.todoItems.push(todoItem)
    //   store.dispatch('addTodo', todoItem)
    // },
    // removeTodo (todoItem, idx) {
    //   this.todoItems.splice(idx, 1)
    //   store.dispatch('removeTodo', idx)
    // }
  },
  computed: {
    ...mapState([
      'todoItems'
    ])
    // todoItems () {
    //   return store.state.todoItems
    // }
  }
}
</script>

<style>
  body {
    text-align: center;
    background-color: #CEDEBD;
  }
</style>
