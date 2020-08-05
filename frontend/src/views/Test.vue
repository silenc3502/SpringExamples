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

      <!-- this.$store가 결국 Vuex를 사용하겠단 의미 -->
      <b>count: {{ this.$store.state.count }}</b><br>
      <b>count^2: {{ this.$store.getters.count }}</b><br>
      <b>weight: {{ this.$store.getters.weight }}</b><br>
      <input type="button" @click="increment()" value="inc"/>
      <input type="button" @click="decrement()" value="dec"/><br>
      <b>random: {{ this.$store.getters.random }}</b><br>
      <input type="button" @click="randomNumber()" value="random"/><br>

      <global-component v-bind:initial-counter="counter">
      </global-component>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
/* eslint-disable no-unused-vars */
import store from '../store'
import cookies from 'vue-cookies'
import GlobalComponent from '../components/GlobalComponent.vue'

Vue.component(GlobalComponent.name, GlobalComponent)

Vue.use(cookies)

export default {
  data: function () {
    return {
      counter: 3,
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
    },
    increment: function () {
      this.$store.commit('increment')
      this.$cookies.set('value', this.$store.state.count, '1h')
    },
    decrement: function () {
      this.$store.commit('decrement')
      this.$cookies.set('value', this.$store.state.count, '1h')
    },
    randomNumber: function () {
      // dispatch는 무조건 action으로 간다.
      // commit은 비동기 처리가 가능하다.
      this.$store.dispatch('generateRandomNumber')
    }
  },
  created: function () {
    this.$store.state.count = this.$cookies.get('value')
  }
}

</script>
