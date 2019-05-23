<template>
  <div id="app">
    <NavBarComponent/>
    <div>
         <b-row>
           <b-col cols="4"><ProductImageComponent/></b-col>
           <b-col cols="8"><ProductDetailsComponent/></b-col>
         </b-row>
    </div>
    <br>
    <MerchantsDisplayComponent/>
    <!-- <ProductDescriptionComponent/> -->
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import NavBarComponent from './components/NavBarComponent.vue'
import ProductImageComponent from './components/ProductImageComponent.vue'
import ProductDescriptionComponent from './components/ProductDescriptionComponent.vue'
import MerchantsDisplayComponent from './components/MerchantsDisplayComponent.vue'
import ProductDetailsComponent from './components/ProductDetailsComponent.vue'

export default {
  name: 'app',
  components: {
    HelloWorld,
    NavBarComponent,
    ProductImageComponent,
    ProductDescriptionComponent,
    MerchantsDisplayComponent,
    ProductDetailsComponent
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
  margin: 3px black;
  margin-left: 30px;
  margin-right: 20px;
  margin-top: 60px;
  margin-bottom: 20px;
  border-left: 2px solid gray;
}
</style>
