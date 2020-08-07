<template>
  <div>
    <h3 class="monospace">Todo List</h3>
    <ul>
      <todo-item v-for="todoItem in todoItems"
          v-bind:key="todoItem.id"
          v-bind:todoItem="todoItem"
          v-bind:editingId="editingId"
          v-on:removeTodo="onRemoveTodo"
          v-on:updateTodo="onUpdateTodo"
          v-on:setEditingId="SET_EDITING_ID"
          v-on:resetEditingId="RESET_EDITING_ID"
          v-on:toggleTodoStatus="onToggleTodoStatus">
      </todo-item>
    </ul>
  </div>
</template>

<script>
import TodoItem from './TodoItem.vue'
import { mapState, mapMutations, mapGetters } from 'vuex'
import { SET_EDITING_ID, RESET_EDITING_ID } from '../store/mutation-types'

export default {
  components: {
    'todo-item': TodoItem
  },
  computed: {
    todoItems () {
      return this.filteredItems
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
      this.$emit('updateTodo', id)
    },
    onToggleTodoStatus (id) {
      this.$emit('toggleTodoStatus', id)
    },
    rt (todoItem, idx) {
      console.log('removeTodo')
      // this.todoItems.splice(idx, 1)
      this.$emit('removeTodo', todoItem, idx)
    },
    hdc (idx) {
      const { id } = this.todoItems[idx]
      this.$emit('setEditingId', id)

      // this.todoItems[idx].isEditing = true

      // refs 자바스크립트에 보면 DOM이란것이 있다.
      // DOM에 각종 HTML 태그들이 연결이 되는데
      // Vue, React 것들은 자동으로 template을 맵핑시켜서 재활용성을 높여주는 녀석들임
      // 특정 키워드를 통해서 Automatic HTML Tag를 생성해준다고도 말 할 수 있다.
      // 그러다보니 HTML내에 있는 값들을 참조할때 $refs 통해 접근할 수 있게 해준다.
      // console.log('handleDblClick this.$refs:', this.$refs.content)
      // console.log('handleDblClick this.$refs.content[0]:', this.$refs.content[0])

      // UI 처리가 끝난 시점에 혹시 처리가 되지 않을 수도 있는 녀석들이 있다 판단하면
      // nextTick()에서 처리를 해주면 미처 처리되지 않았을 수도 있는 것들을 완벽하게 처리할 수 있다.
      this.$nextTick(() => {
        // console.log('handleDblClick this.$refs.content[0]:', this.$refs.content[0])
        this.$refs.content[0].focus()
      })
    },
    hb (idx) {
      // this.todoItems[idx].isEditing = false
      this.$emit('resetEditingId')
    },
    ut (id, e) {
      // console.log('updateTodo e:', e)

      const content = e.target.value.trim()

      if (content.length <= 0) {
        return false
      }

      this.$emit('updateTodo', content, id)

      this.$refs.content[0].blur()
    },
    ie (idx) {
      if (this.todoItems[idx]) {
        return this.todoItems[idx].id === this.editingId
      }

      return false
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
