<template>
  <div id="app">
    <div >
        
         <b-row><b><h3 id="prod-name" > {{getProductById.data.productName}}</h3></b></b-row>
            <b-row style="height:600px">
           <b-col cols="4">
             
              <div class="image" v-for="(element,index) in getProductById.data.productImages" v-bind:key="index">
          <img :src="element ? element : ''" class="image" style="height:400px;width:300px">
              </div>
       </b-col>
   <b-col cols="8">
     <div class="product-details">
        <div class="product-name">
       
        <b><h3 id="prod-name">Brand:  {{getProductById.data.brand}}</h3></b>
        </div>
        <div class="other-attributes">
        <h4>{{getProductById.data.description}}</h4>
       <b-row>
  <b-col cols="12">
    <div class="merchants" v-for="(item,index) in getMerchants.data " v-bind:key="index" style="font-size:30px">
      <input type="radio" :value="item.merchantId" name="radio" v-model="checked"><strong>&nbsp;{{item.merchantName}}</strong> has a rating of
                <strong>&nbsp;{{item.averageRating}}</strong> and selling at Rs 
                <strong>&nbsp;{{item.productPrice}}</strong>
                
            
            </div>
            <br/><b>&nbsp;<b-button variant="primary" @click="addToCart">Add to cart</b-button></b>
             <br/><b>&nbsp;<b-button variant="primary" @click="goToCart">Go to cart</b-button></b>
  </b-col>
</b-row>
        </div>
        
    </div></b-col>
         </b-row>
    </div>
    <br>
    <div>

</div>
  
  </div>
</template>

<script>


import {mapGetters, mapActions} from 'vuex'
import Cart from './Cart.vue'

export default {
  name: 'Product',
  data(){
    return{
       price : '',
       checked :'',
       object1 : 
       {
         value1: '',
         value2:{
           type: Number
         },
         value3:{
           type: Number
         },
         value4:{
           type: Number
         }
       }
         }
    },
  
  components: {
    Cart
    
  },
  methods:{
    addToCart(){
      var token = localStorage.getItem("token");
      var productId = this.$route.params.id ;
       var merchantId = this.checked;
      var quantity = '1';
      
       this.object1.value1= token,
        this.object1.value2 =productId,
        this.object1.value3 =merchantId,
        this.object1.value4 =quantity
      
      
      this.$store.dispatch('addToCart',this.object1);

    },
    goToCart(){
      var token = localStorage.getItem("token");
      this.$store.dispatch('fetchFromCart',token);
      this.$router.push({name: 'Cart'});
      
    }

  },
  created(){
      
      console.log('this.route',this.$route);
      var productID = this.$route.params.id;
      console.log(productID);
  },

  computed:{
   ...mapGetters(['getProductById','getMerchants'])
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
}
</style>