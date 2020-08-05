<template>
  <div>
    <h3>Todo List</h3>
    <ul>
      <li v-for="(todoItem, idx) in todoItems"
          v-bind:key="idx">
        {{ todoItem }}<button>Delete</button>
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
  }
}

</script>

<style scoped>
  div {
    background-color: #44cc34
  }
</style>
