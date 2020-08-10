<template>
  <div class="home">
    <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
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
      <router-link :to="{ name: 'Todo' }"
          class="nav-link"
          active-class="active">
        Todo
      </router-link>
      <router-link :to="{ name: 'Concave' }"
          class="nav-link"
          active-class="active">
        Concave
      </router-link>
    </div>
    <h2>This is an Home Page</h2>
    <div id="app">
      {{ message }}<br>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'
/* eslint-disable no-unused-vars */
import store from '../store'
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
  name: 'Home',
  data: function () {
    return {
      message: 'Vue Test Message'
    }
  },
  components: {
  }
}
</script>

<style scoped>
div {
  border: 1px solid #ccc;
}

#header {
  padding: 15px;
  margin-bottom: 15px;
  margin: 5px 5px;
}

img {
  width: auto;
  height: auto;
  max-width: 1000px;
  max-height: 350px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

</style>
