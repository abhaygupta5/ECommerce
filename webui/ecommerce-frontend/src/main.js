import Vue from 'vue'
import App from './App.vue'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import Vuetify from 'vuetify'
import axios from 'axios'
import VueAxios from 'vue-axios'
import VueRouter from 'vue-router'
import Vuex from 'vuex'
import store from './store/index.js'
import router from './router.js'
import { URLSearchParams } from 'url';
Vue.use(store)

Vue.use(VueRouter)

Vue.use(VueAxios, axios)
Vue.use(Vuetify)
Vue.use(BootstrapVue)
Vue.use(Vuex)





Vue.config.productionTip = false

new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')
