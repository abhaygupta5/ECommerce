<template>
  
  <div>
    <Header/> 
    <SignUp/>
  <!--<Footer/>
    
   <!-- <UserDetails/>
    
    <Cart/>-->
    <!-- <OrderHistory/> -->
    <!-- <CategoriesBar/> -->
    
<Footer/>
  </div>
</template>

<script>
import Footer from './components/Footer.vue'
import SignUp from './components/SignUp'
import UserDetails from './components/UserDetails'
import Header from './components/Header'
import Cart from './components/Cart'
import OrderHistory from './components/OrderHistory'

export default {
  name: 'app',
  components: {
    Footer,
    SignUp,
    UserDetails,
    Header,
    Cart,
    OrderHistory
  }
}
</script>

<style>


</style>
