import Vue from 'vue'
import Vuex from 'vuex'
import module1 from './module1.js'

Vue.use(Vuex)

export default new Vuex.Store({
	modules: {
		module1
	}
})