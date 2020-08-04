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
      <!-- border-collapse는 테두리와 셀 사이 간격 삭제 -->
      <p>count 기반 순회</p>
      <table border="1" style="border-collapse:collapse;">
        <tr v-bind:key=idx v-for="idx in count">
          <td>{{ msg }}</td>
          <td>{{ idx }}</td>
        </tr>
      </table>

      <p>list() 기반 순회</p>
      <table border="1" style="border-collapse:collapse;">
        <tr v-bind:key=idx v-for="idx in list()">
          <td>{{ msg }}</td>
          <td>{{ idx }}</td>
        </tr>
      </table>

      <p>(key, value) 기반 순회</p>
      <table border="1" style="border-collapse:collapse;">
        <tr v-bind:key="(value, key)" v-for="(value, key) in data">
          <td>{{ value }}</td>
          <td>{{ key }}</td>
        </tr>
      </table>
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
      msg: 'Test',
      count: 7,
      list: function () {
        var list = []
        for (var i = 1; i < this.count; i += 2) {
          list.push(i)
        }
        return list
      },
      message: 'Test Page',
      seen: true,
      todos: [
        { text: 'JavaScript' },
        { text: 'Golang' },
        { text: 'C++' }
      ],
      cnt: 0,
      data: {
        bird: 'raven',
        animal: 'tiger',
        fish: 'tuna',
        proj: 'cnn',
        major: 'EE'
      }
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
