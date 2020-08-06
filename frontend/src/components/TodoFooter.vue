<template>
  <div>
    <h3>Todo Footer</h3>
    <button v-on:click="clearTodo">Delete All</button>
  </div>
</template>

<script>
export default {
  methods: {
    clearTodo () {
      console.log('clearTodo')
      this.$emit('removeAll')
    }
  }
}
</script>

<style scoped>
  div {
    background-color: #7789c3
  }
</style>
