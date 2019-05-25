import Vue from 'vue'
import Router from 'vue-router'
import IntegratedHomeComponent from './components/IntegratedHomeComponent.vue'
import Login from './components/Login.vue'
import UserDetails from './components/UserDetails.vue'

Vue.use(Router)

const router =new Router({
    mode: 'history',
    routes: [
        {
            name: '',
            path: '',
            component: IntegratedHomeComponent
        },
        {
            name: 'loginPopup',
            path: '/loginPopup',
            component: Login
        },
        {
            name: 'userDetails',
            path: '/userDetails',
            component: UserDetails
        }
    ]
})

export default router