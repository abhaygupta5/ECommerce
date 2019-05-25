<template>
  
  <div>
       <H1>LOGIN</H1>
       
      </div>
</template>

<script>
import Header from '../components/Header.vue'

export default {
     name: "Login",
     components:{
         Header
     },
     data(){
    return {
      isDrawerOpen :false
    }
  },
  methods:{
    drawerOpen(){
      console.log('&&&&&&&', this.isDrawerOpen)
      this.isDrawerOpen = !this.isDrawerOpen
    }
  }
}
</script>

