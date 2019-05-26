<template>
  <div id="app" style="max-width:100%;max-height:100% ; overflow:scroll">
   <Header/> 
   <br/>
   <CategoryBar/>
    <router-view></router-view>
   <Footer/>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import CategoryBar from './components/CategoryBar.vue'
import Home from './components/Home.vue'
import Footer from './components/Footer.vue'
export default {
  name: 'app',
  components: {
    Header,
    CategoryBar,
    Home,
    Footer
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
