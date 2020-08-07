<template>
  <div>
    <ul>
      <h3>Todo List</h3>
      <todo-item v-for="todoItem in todoItems"
        v-bind:key="todoItem.id"
        v-bind:todoItem="todoItem"
        v-bind:editingId="editingId"
        v-on:removeTodo="onRemoveTodo"
        v-on:updateTodo="onUpdateTodo"
        v-on:setEditingId="SET_EDITING_ID"
        v-on:resetEditingId="RESET_EDITING_ID"
        v-on:toggleTodoStatus="onToggleTodoStatus"/>
    </ul>
  </div>
</template>

<script>
import TodoItem from './TodoItem.vue'
import { mapState, mapMutations, mapGetters } from 'vuex'
import { RESET_EDITING_ID, SET_EDITING_ID } from '../store/mutation-types'
export default {
  components: {
    'todo-item': TodoItem
  },
  computed: {
    todoItems () {
      return this.filteredTodoItems
    },
    ...mapState([
      'editingId'
    ]),
    ...mapGetters([
      'filteredTodoItems'
    ])
  },
  methods: {
    ...mapMutations([
      SET_EDITING_ID,
      RESET_EDITING_ID
    ]),
    onRemoveTodo (id) {
      this.$emit('removeTodo', id)
    },
    onUpdateTodo (content, id) {
      this.$emit('updateTodo', content, id)
    },
    onToggleTodoStatus (id) {
      this.$emit('toggleTodoStatus', id)
    }
  }
}
</script>

<style scoped>
  div {
    background-color: #44cc34
  }
  .monospace {
    font-family: "Lucida Console", Courier, monospace;
    text-decoration: underline;
  }
</style>
