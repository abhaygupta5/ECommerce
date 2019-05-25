<template>
  <div id="app">
   <Header :openDrawer="drawerOpen"/>
   <br/>
   <br/>
    <categoryBar/>
   <Home :drawer= "isDrawerOpen"/>
  
  
  </div>
</template>

<script>
import Header from '../components/Header.vue'
import Home from '../components/Home.vue'
import categoryBar from '../components/categoryBar.vue'


import HelloWorld from '../components/HelloWorld.vue'

export default {
  name: 'app',
  components: {
    HelloWorld,
    Header,
    Home,
    categoryBar
   
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

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
