import Vue from 'vue'
import Router from 'vue-router'
import Search from './components/Search.vue'
import Product from './components/Product.vue'
import Mobiles from './components/mobiles.vue'
import Home from './components/Home.vue'
import UserDetails from './components/UserDetails.vue'
import Cart from './components/Cart.vue'
import ConfirmAddress from './components/ConfirmAddress.vue'
import OrderHistory from './components/OrderHistory.vue'
Vue.use(Router)

const router =new Router({
    mode: 'history',
    routes: [
        {
            name: 'Home',
            path: '/',
            component: Home
        },
        {
            name: 'Search',
            path: '/category',
            component: Search
        },
        {
            name: 'Product',
            path: '/product/:id',
            component: Product
        },
        {
            name: 'Mobiles',
            path: '/electronics/mobiles',
            component: Mobiles
        },
        {
            name: 'UserDetails',
            path: '/userDetails',
            component: UserDetails
        },
        {
            name: 'Cart',
            path: '/cart',
            component: Cart
        },
        {
            name: 'ConfirmAddress',
            path: '/confirmaddress/:id',
            component: ConfirmAddress
        },
        {
            name: 'OrderHistory',
            path: '/orderhistory',
            component: OrderHistory
        }

       
    ]
})

export default router