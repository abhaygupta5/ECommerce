<template>
  <div id="app">
 <SortByBar/>
    <br><br><br>
     <div>
         <b-row>
           <b-col cols="3"><FilterComponent/></b-col>
           <b-col cols="9"><div><div class="products-display">
<div class="row1">
           <b-container class="bv-example-row" style="max-width:100% !important">
  <b-row>
 <b-col cols="4" v-for="(item,index) in getMobile.data" v-bind:key="index">
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
                 <v-btn round color="green" style="margin-left:75px; margin-top:0px">Add to Cart</v-btn>
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


</div></div><br>
          
          </b-col>
         </b-row>
     </div>
      
  </div>
 
</template>

<script>
import SortByBar from './SortByBar.vue'
import ProductDisplay from '../components/ProductDisplay.vue'
import FilterComponent from './FilterComponent.vue'
import Product from './Product.vue'
import {mapGetters, mapActions} from 'vuex'

export default {
    name:'Mobiles',
    components: {
   
    SortByBar,
    ProductDisplay,
    Product,
    FilterComponent

  },
  created(){
    console.log("mobiles", this.$route.params);
     this.$store.dispatch('fetchMobiles');
  },
  computed:{
      ...mapGetters(['getMobile'])
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