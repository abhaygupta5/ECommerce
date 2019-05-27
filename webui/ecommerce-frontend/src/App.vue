<template>
  <div id="app" style="max-width:100%;max-height:100% ; overflow:scroll;margin-left:20px">
    <b-container  class="box"style="max-width:100%;max-height:100% ; overflow:scroll">
    <b-row>  
   <Header/> </b-row>
   <b-row style="margin-left:10px">
  <CategoryBar/>
   </b-row>
   <b-row>
    <router-view></router-view>
   </b-row>
   </b-container>
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

@media (min-width: 500px) and (max-width: 600px) {
  .box {
      margin-left: 0 !important 
    }

    .desc:after {
      content:" In fact, it's between 500px and 600px wide.";
    }
  }
</style>
