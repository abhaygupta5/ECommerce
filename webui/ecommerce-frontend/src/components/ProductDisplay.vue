<template>
 <div class="products-display">
<div class="row1">
           <b-container class="bv-example-row" style="max-width:100% !important">
  <b-row>
 <b-col cols="4" v-for="(item,index) in getMobile" v-bind:key="index">
  <div >
  <v-layout >
    <v-flex xs12 sm6 offset-sm3>
    
      <v-card style="width:365px" v-for="element in item.productImages" :key="element">
        <v-img
          class="white--text"
          height="400px"
          :src="element ? element : ''" 
         
        >
          <v-container fill-height fluid>
            <v-layout fill-height>
              <v-flex xs12 align-end flexbox>
                
              </v-flex>
            </v-layout>
          </v-container>
        </v-img>
        <center>
        <div class="row">
           <b-col cols="12" class="text-center">
           <span style="font-family:Helvetica ; font-size:20px " ><b>{{item.productName}}</b></span><br>
            <span style="font-family:Helvetica ; font-size:14px ">{{item.brand}}</span><br>
            <span style="font-family:Helvetica ; font-size:14px"><b>Rs {{item.price}}</b></span>
          </b-col> 
        </div>
         <div class="row">
           <b-col cols="12" class="text-center">
              <!-- <v-card-actions class="text-center"> -->
                 <v-btn round color="green" style="margin-left:75px; margin-top:0px" @click="goToProduct(item)">Go To Product Details</v-btn>
              <!-- </v-card-actions> -->
           </b-col>  
        </div>
        
        </center>
      </v-card>
    
    </v-flex>
  </v-layout>
</div>
  </b-col>
  
</b-row>
 </b-container> 
</div>


</div>
</template>
<script>
import {mapGetters, mapActions} from 'vuex'

export default {
    name: 'ProductsDisplay',
    data(){
      return{
        
        getProduct:{
            item1:{
              imageURLs :"https://1909ventilo.files.wordpress.com/2015/02/velvet-edge-11.jpg",
            productName : "Mobile",
            brand: "Samsung",
            price :"1100"
            },
            item2:{
              imageURLs :"https://1909ventilo.files.wordpress.com/2015/02/velvet-edge-11.jpg",
            productName : "Mobile",
            brand: "Samsung",
            price :"1100"
            },
            item3:{
              imageURLs :"https://1909ventilo.files.wordpress.com/2015/02/velvet-edge-11.jpg",
            productName : "Mobile",
            brand: "Samsung",
            price :"1100"
            },
             item4: {
              imageURLs :"https://1909ventilo.files.wordpress.com/2015/02/velvet-edge-11.jpg",
            productName : "Mobile",
            brand: "Samsung",
            price :"1100"
            }
            
        },
        
        numberOfProducts: 20,
      productsDisplayed: this.$route.query.page==undefined?0:9*(this.$route.query.page)-9,
      //productsInCurrentPage: 0,
      startIndex: this.$route.query.page==undefined?0:9*(this.$route.query.page)-9,
      //endIndex: 0,
      currentIndex: this.$route.query.page==undefined?0:9*(this.$route.query.page)-9
      }
    },
    methods: {
      goToProduct(item){
          console.log('Product id:',item.productId )
          this.$store.dispatch('fetchProductById',item.productId);
          this.$router.push('/product/'+item.productId);
          this.$store.dispatch('fetchMerchants',item.productId);
          }
      
    },
    props: {
    },
    created(){
        console.log("mobiles", this.$route.params);
            // this.$store.dispatch('fetchMobiles');
    },
    computed: {
       ...mapGetters(['getMobile']),

      moreProductsAvailable: function(){
      
        if(this.numberOfProducts>this.productsDisplayed){
          this.currentIndex+=1;
          this.productsDisplayed+=1;
          console.log(this.productsDisplayed);
          return true;
        }
        return false;
      }
    }
}
</script>
<style>
/* Code for first row */
 .bv-example-row {
   max-width :100% !important;
   margin-left: 20px !important;

   padding-left :0px !important;
   padding-right :20px !important;
 }
   @media (min-width: 600px) {
     .offset-sm3 {
       margin-left: 0 !important;
    }

    .col-3 {
      padding-left: 0 !important;
      padding-right: 0 !important;
    }
}

.v-btn {
  margin-left :0  !important;
}

</style>