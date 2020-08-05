<template>
  <div>
    <h3 class="monospace">Todo List</h3>
    <ul>
      <li v-for="(todoItem, idx) in todoItems"
          v-bind:key="idx">
        {{ todoItem }}
        <button v-on:click="removeTodo(todoItem, idx)">
          Delete
        </button>
      </li>
    </ul>
  </div>
</template>

<script>

export default {
  data () {
    return {
      todoItems: ['item1', 'item2', 'item3']
    }
  },
  methods: {
    removeTodo (todoItem, idx) {
      console.log('removeTodo')
      this.todoItems.splice(idx, 1)
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
