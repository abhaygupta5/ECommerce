import Vue from 'vue'
import './plugins/bootstrap-vue'
import App from './App.vue'
import BootstrapVue from 'bootstrap-vue'
import store from './store/index.js'
import Vuex from 'vuex'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
Vue.use(Vuetify)

Vue.use(Vuex)
Vue.use(BootstrapVue)

Vue.config.productionTip = false

new Vue({
  store,
  render: h => h(App)
}).$mount('#app')
