<template>
  <div class="home">
    <div id="header">
      <router-link :to="{ name: 'Home' }"
          class="nav-link"
          active-class="active">
        Home
      </router-link>
      <router-link :to="{ name: 'About' }"
          class="nav-link"
          active-class="active">
        About Us
      </router-link>
      <router-link :to="{ name: 'Test' }"
          class="nav-link"
          active-class="active">
        Test
      </router-link>
    </div>
    <h2>This is an Test Page</h2>
    <div id="app">
      <p v-if="seen">You can see it!</p>
      <p v-bind:key=todo v-for="todo in todos">
        {{ todo.text }}
      </p>
      <p>{{ message }}</p>
      <button v-on:click="reverseMsg">Reverse Message</button>
      <p>{{ message }}</p>
      <input v-model="message"><br>
      <button @click="incCnt">{{ cnt }}</button><br>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
  data: function () {
    return {
      message: 'Test Page',
      seen: true,
      todos: [
        { text: 'JavaScript' },
        { text: 'Golang' },
        { text: 'C++' }
      ],
      cnt: 0
    }
  },
  methods: {
    reverseMsg: function () {
      this.message = this.message.split('').reverse().join('')
    },
    incCnt: function () {
      this.cnt++
    }
  }
}

</script>
