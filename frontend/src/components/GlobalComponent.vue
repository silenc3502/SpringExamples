<template>
  <button @click="addCounter">{{ counter }}</button>
</template>

<script>
export default {
  name: 'global-component',
  props: ['initialTest'],
  template: '<button @click="addCounter">{{ counter }}</button>',
  data: function () {
    return {
      counter: this.initialTest
    }
  },
  methods: {
    addCounter: function () {
      this.counter += 1
    }
  }
}
</script>
