<template>
  <div class="todo">
    <input type="radio"
      v-bind:checked="filter === null"
      v-on:change="SET_FILTER(null)">All
    <input type="radio"
      v-bind:checked="filter === 'A'"
      v-on:change="SET_FILTER('A')">Not Yet
    <input type="radio"
      v-bind:checked="filter === 'B'"
      v-on:change="SET_FILTER('B')">Done
  </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
import { SET_FILTER } from '../store/mutation-types'
export default {
  computed: {
    ...mapState([
      'filter'
    ])
  },
  methods: {
    ...mapMutations([
      SET_FILTER
    ])
  }
}
</script>
