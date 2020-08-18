import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import cookies from 'vue-cookies'
import vuex from 'vuex'
import vuetify from './plugins/vuetify'

Vue.config.productionTip = false

Vue.use(cookies)
Vue.use(vuex)

function init () {
  // const savedToken = null
  const savedToken = cookies.get('accessToken')

  if (savedToken) {
    return store.dispatch('loginByToken', savedToken)
  } else {
    // Promise는 비동기 처리
    // 스레드, 컨텍스트 스위칭, 뮤텍스, 세마포어, 비동기 처리, 동기 처리
    return Promise.resolve()
  }
}

init().then(() => {
  new Vue({
    router,
    store,
    vuetify,
    render: h => h(App)
  }).$mount('#app')
})
