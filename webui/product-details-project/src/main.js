import Vue from 'vue'
import './plugins/bootstrap-vue'
import App from './App.vue'
import PicZoom from 'vue-piczoom'

Vue.config.productionTip = false
Vue.use(PicZoom)

new Vue({
  render: h => h(App)
}).$mount('#app')
