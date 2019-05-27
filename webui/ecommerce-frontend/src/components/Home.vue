<template>
  <div id="home">
    
    <!-- Code for Carousel  -->
    
      <template v-if= "$route.name === 'Search' ">
           <router-view></router-view>
      </template>
<template v-else>
    <div >
        <v-carousel>
        <v-carousel-item class="item"
          v-for="(item,i) in items"
          :key="i"
          :src="item.src"
          reverse-transition="fade"
          transition="fade"
        ></v-carousel-item>
        </v-carousel> 
      
  </div>
  <div>
    <!--b-button @click="getProductsItems" variant="outline-primary"> GetTopProducts</b-button-->
   
    </div>
  <!-- Code for Body  -->
  <!-- Code for first row -->
  <div style="margin:0px !important">
    <b-container class="bv-example-row">
    <b-row style="max-height: 400px">
    <b-col cols="6"><img src="../images/img2.jpg" @click="goToWomen" style="width:100%;height:400px"></b-col>
    <b-col cols="6">
      <b-row style="max-width:100% ; max-height:200px;">
        <img src="../images/samsung.jpg" @click="goToMobiles" style="width:100%;height:200px; paddong-bottom:5px">
      </b-row>
      <b-row style="max-width:100% ; max-height:200px">
        <img src="../images/lakme.jpg" @click="goToBeautyProducts" style="width:100%;height:200px; padding-top:10px" >
      </b-row>
    </b-col>
    
  </b-row>
</b-container>
</div>
   <!-- Code for second row -->

<div >
<b-container class="bv-example-row" style="max-width:100% !important">
  <b-row style=" margin-left:0 !important;margin-right:0 !important;">
<b-col cols="3" v-for="(item,index) in getTopProducts.data" v-bind:key="index">
    <div>
  

  <v-layout >
    <v-flex xs12 sm6 offset-sm3>
        
      <v-card style="width:250px" v-for="element in item.productImages" :key="element" >
        <v-img
          class="img-fluid"
          :src="element ? element : ''"
          height="400px"
          width="250px"
          style="object-fit:scale-down"
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
           <span style="font-family:Helvetica ; font-size:20px "><b>{{item.productName}}</b></span><br>
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

<!--Code for the Third row -->
  <div class="fourthrow" >
    <b-container class="bv-example-row" style="margin-right:15px !important">
    <b-row style="max-height: 400px">
    <b-col cols="6"><img src="../images/mennew.png" @click="goToMen" style="width:98%;height:400px"></b-col>
    <b-col cols="6">
      <img src="../images/luggage.jpg" @click="goToSuitcases" style="width:100%;height:400px ;margin-right:20px; margin-left:0px">
    </b-col>
    
  </b-row>
</b-container>
</div>
<!-- Code for last row  -->
<div class="fifth row" style="margin-left:8px">


</div>
</template>

  <Footer/>
 </div>
 </div>
  </template>

<style lang="stylus">

/*  Code for Carousel  */
  #example-custom-transition
    .fade
      &-enter-active, &-leave-active, &-leave-to
        transition: .3s ease-out
        position: absolute
        top: 0
        left: 0

      &-enter, &-leave, &-leave-to
        opacity: 0

 .item{
   object-fit :cover !important
 }

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
      paddong-right: 0 !important;
    }
}

.v-btn {
  margin-left :0  !important;
}


</style>



<script >

import newArrival from '../images/ladies.jpg'
import phone from '../images/oneplus6.jpg'
import menfashion from '../images/men7.jpg'
import laptop from '../images/laptop5.jpg'
import {mapGetters, mapActions} from 'vuex'

import axios from 'axios'
import { get } from 'http';



  


  export default {
    props:{
     drawer:{
       type: Boolean
     }
    },
    watch: {
      drawer: function(newValue, oldValue) {
        this.isOpen = newValue
      }
    },
    computed:{
        ...mapGetters(['getTopProducts']),
        
    },
    data () {
      return {
        object1 : 
       {
         value1: '',
         value2: ''
      },
        
        productId:'',
        isOpen: false,
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
            },
         },
         
            
         
        items: [
          {
            src: newArrival
          },
          {
            src: phone
          },
          {
            src: menfashion
          },
          {
            src: laptop
          }
        ]
      }
    },
    components:{
     
    },
    methods: {
        
        goToProduct(item){
          var productId = item.productId

          console.log('Product id:', productId )
          this.$store.dispatch('fetchProductById',productId);
          this.$router.push('/product/'+productId);
          this.$store.dispatch('fetchMerchants',productId);
          },
          goToWomen (){
          this.object1.value1 =  'fashion';
        this.object1.value2 = 'women'

         this.$router.push({name: 'Category'});
        console.log('women',this.object1);
            this.$store.dispatch('fetchCategory',this.object1);
            //this.$store.dispatch('fetchFilters',this.object1);
      },
       goToMobiles (){
        this.object1.value1 = 'electronics';
        this.object1.value2 = 'mobile'

        this.$router.push({name: 'Category'});
        console.log('mobiles', this.object1);
            this.$store.dispatch('fetchCategory',this.object1);
           // this.$store.dispatch('fetchFilters',this.object1);
      },
      goToBeautyProducts(){
        this.object1.value1 = 'beauty';
        this.object1.value2 = 'menAndWomen'

        this.$router.push({name: 'Category'});
        console.log('beauty Products',this.object1);
            this.$store.dispatch('fetchCategory',this.object1);
          //  this.$store.dispatch('fetchFilters',this.object1);
      },
      goToMen (){
          this.object1.value1 = 'fashion';
        this.object1.value2 = 'men'

       this.$router.push({name: 'Category'});
        console.log('men',this.object1);
            this.$store.dispatch('fetchCategory',this.object1);
           // this.$store.dispatch('fetchFilters',this.object1);
      },
      goToSuitcases(){
          this.object1.value1 = 'luggage';
        this.object1.value2 = 'suitcase'

         this.$router.push({name: 'Category'});
        console.log('suitcases',this.object1);
            this.$store.dispatch('fetchCategory',this.object1);
           // this.$store.dispatch('fetchFilters',this.object1);
      }
        
  },
  created(){
            console.log("top products");
            this.$store.dispatch('fetchTopProducts');
           
        },
 
  }
  
</script>
<style>

#home{
  margin-top: 50px;
}
</style>
