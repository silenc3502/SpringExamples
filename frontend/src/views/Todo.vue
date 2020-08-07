<template>
  <div class="todo">
    <todo-header></todo-header>
    <todo-input v-on:addTodo="onAddTodo"></todo-input>
    <todo-list v-on:removeTodo="onRemoveTodo"
              v-on:updateTodo="onEditTodo"
              v-on:toggleTodoStatus="onToggleTodoStatus">
    </todo-list>
    <todo-footer v-on:removeAll="onClearAll"></todo-footer>
    <b>random: {{ this.$store.getters.random }}</b><br>
    <input type="button" @click="randomNumber()" value="random"/><br>
  </div>
</template>

<script>
import TodoHeader from '../components/TodoHeader.vue'
import TodoInput from '../components/TodoInput.vue'
import TodoList from '../components/TodoList.vue'
import TodoFooter from '../components/TodoFooter.vue'
import { mapActions } from 'vuex'

export default {
  name: 'Todo',
  components: {
    'todo-header': TodoHeader,
    'todo-input': TodoInput,
    'todo-list': TodoList,
    'todo-footer': TodoFooter
  },
  methods: {
    ...mapMutations([
      SET_EDITING_ID,
      RESET_EDITING_ID
    ]),
    ...mapActions([
      'clearAll',
      'addTodo',
      'removeTodo',
      'generateRandomNumber',
      'save',
      'restore',
      'editTodo',
      'toggleTodoStatus'
    ]),
    onEditTodo (content, id) {
      this.editTodo({ id, content })
      this.save()
    },
    onClearAll () {
      this.clearAll()
      this.save()
    },
    onAddTodo (content) {
      const todoItem = { content }

      this.addTodo(todoItem)
      this.save()
    },
    onToggleTodoStatus (id) {
      this.toggleTodoStatus(id)
      this.save()
    },
    onRemoveTodo (todoItem, idx) {
      this.removeTodo(idx)
      this.save()
    },
    randomNumber () {
      this.generateRandomNumber()
    },
    created () {
      this.restore()
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
