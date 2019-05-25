import Vue from 'vue'
import App from './App.vue'
import BootstrapVue from 'bootstrap-vue'
import Vuetify from 'vuetify'
import VueScrollReveal from 'vue-scroll-reveal'
import VueRouter from 'vue-router'
import router from './router.js'
import Vuex from 'vuex'
import store from './store/index.js'

import 'vuetify/dist/vuetify.min.css'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(store)
Vue.use(Vuex)
Vue.use(Vuetify)
Vue.use(VueRouter)
Vue.use(BootstrapVue)
Vue.use(VueScrollReveal, {
  class: 'v-scroll-reveal', // A CSS class applied to elements with the v-scroll-reveal directive; useful for animation overrides.
  duration: 800,
  scale: 1,
  distance: '10px',
  mobile: false
});

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
