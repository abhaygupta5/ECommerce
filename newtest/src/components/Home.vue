<template>
  <div id="home">
    <v-navigation-drawer v-model="isOpen"  app absolute temporary style="width:300px;height:500px ;background-color:#f4f4f4">
  <b-container >
    <b-row style="font-size:30px; font-family:Helevetica ;margin-left:10px; color:black ;height:50px ">
     <b>Fashion</b>
      </b-row>
      <b-row style="font-size:20px; margin-left:10px">
      <b>Men's Wear</b>
      </b-row>
       <b-row style="font-size:20px; margin-left:10px">
      <b>Women's Wear</b>
      </b-row>
     <b-row style="font-size:30px; font-family:Helevetica ;margin-left:10px; color:black ;height:50px">
      <b>Electronics</b>
      </b-row>
       <b-row style="font-size:20px; margin-left:10px">
      <b>Mobiles</b>
      </b-row>
       <b-row style="font-size:20px; margin-left:10px">
      <b>Laptops</b>
      </b-row>
      <b-row style="font-size:30px; font-family:Helevetica ;margin-left:10px; color:black ;height:50px">
      <b>Books</b>
      </b-row>
      <b-row style="font-size:30px; font-family:Helevetica ;margin-left:10px; color:black ;height:50px">
      <b>Luggage</b>
      </b-row>
       <b-row style="font-size:20px; margin-left:10px">
      <b>Suitcases</b>
      </b-row>
       <b-row style="font-size:20px; margin-left:10px">
      <b>Backpacks</b>
      </b-row>
      <b-row style="font-size:30px; margin-left:10px; text-align:left;font-family:Helevetica;color:black ;height:50px">
      <b>Beauty Products</b>
      </b-row>
  </b-container>
</v-navigation-drawer>
    <!-- Code for Carousel  -->
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
  <!-- Code for Body  -->
  <!-- Code for first row -->
  <div style="margin:0px !important">
    <b-container class="bv-example-row">
    <b-row style="max-height: 400px">
    <b-col cols="6"><img src="../images/img2.jpg" style="width:100%;height:400px"></b-col>
    <b-col cols="6">
      <b-row style="max-width:100% ; max-height:200px;">
        <img src="../images/samsung.jpg" style="width:100%;height:200px; paddong-bottom:5px">
      </b-row>
      <b-row style="max-width:100% ; max-height:200px">
        <img src="../images/lakme.jpg" style="width:100%;height:200px; padding-top:10px" >
      </b-row>
    </b-col>
    
  </b-row>
</b-container>
</div>
   <!-- Code for second row -->

<div >
<b-container class="bv-example-row" style="max-width:100% !important">
  <b-row style="max-height: 400px; margin-left:0 !important;margin-right:0 !important;">
<b-col cols="3">
    <div>
  

  <v-layout >
    <v-flex xs12 sm6 offset-sm3>
      <v-card style="width:365px">
        <v-img
          class="white--text"
          height="300px"
          src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
        >
          <v-container fill-height fluid>
            <v-layout fill-height>
              <v-flex xs12 align-end flexbox>
                <span class="headline">Top 10 Australian beaches 2</span>
              </v-flex>
            </v-layout>
          </v-container>
        </v-img>
        <center>
        <div class="row">
           <b-col cols="12" class="text-center">
           <span style="font-family:Helvetica ; font-size:20px "><b>Name of Product</b></span><br>
            <span style="font-family:Helvetica ; font-size:14px ">Brand of Product</span><br>
            <span style="font-family:Helvetica ; font-size:14px"><b>Price</b></span>
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
  <b-col cols="3">
    <div>
  

  <v-layout >
    <v-flex xs12 sm6 offset-sm3>
      <v-card style="width:365px">
        <v-img
          class="white--text"
          height="300px"
          src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
        >
          <v-container fill-height fluid>
            <v-layout fill-height>
              <v-flex xs12 align-end flexbox>
                <span class="headline">Top 10 Australian beaches 2</span>
              </v-flex>
            </v-layout>
          </v-container>
        </v-img>
        <center>
        <div class="row">
           <b-col cols="12" class="text-center">
           <span style="font-family:Helvetica ; font-size:20px "><b>Name of Product</b></span><br>
            <span style="font-family:Helvetica ; font-size:14px ">Brand of Product</span><br>
            <span style="font-family:Helvetica ; font-size:14px"><b>Price</b></span>
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
  <b-col cols="3">
    <div>
  

  <v-layout >
    <v-flex xs12 sm6 offset-sm3>
      <v-card style="width:365px">
        <v-img
          class="white--text"
          height="300px"
          src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
        >
          <v-container fill-height fluid>
            <v-layout fill-height>
              <v-flex xs12 align-end flexbox>
                <span class="headline">Top 10 Australian beaches 2</span>
              </v-flex>
            </v-layout>
          </v-container>
        </v-img>
        <center>
        <div class="row">
           <b-col cols="12" class="text-center">
           <span style="font-family:Helvetica ; font-size:20px "><b>Name of Product</b></span><br>
            <span style="font-family:Helvetica ; font-size:14px ">Brand of Product</span><br>
            <span style="font-family:Helvetica ; font-size:14px"><b>Price</b></span>
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
  <b-col cols="3">
    <div>
  

  <v-layout >
    <v-flex xs12 sm6 offset-sm3>
      <v-card style="width:365px">
        <v-img
          class="white--text"
          height="300px"
          src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
        >
          <v-container fill-height fluid>
            <v-layout fill-height>
              <v-flex xs12 align-end flexbox>
                <span class="headline">Top 10 Australian beaches 2</span>
              </v-flex>
            </v-layout>
          </v-container>
        </v-img>
        <center>
        <div class="row">
           <b-col cols="12" class="text-center">
           <span style="font-family:Helvetica ; font-size:20px "><b>Name of Product</b></span><br>
            <span style="font-family:Helvetica ; font-size:14px ">Brand of Product</span><br>
            <span style="font-family:Helvetica ; font-size:14px"><b>Price</b></span>
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
<!--Code for the Third row -->
  <div class="fourthrow" style="margin:0px !important">
    <b-container class="bv-example-row">
    <b-row style="max-height: 400px">
    <b-col cols="6"><img src="../images/mennew.png" style="width:100%;height:400px"></b-col>
    <b-col cols="6">
      <img src="../images/luggage.jpg" style="width:100%;height:400px ;margin-right:20px">
    </b-col>
    
  </b-row>
</b-container>
</div>
<!-- Code for last row  -->
<div class="fifth row">
<b-container class="bv-example-row" style="max-width:100% !important">
  <b-row style="max-height: 400px; margin-left:0 !important;margin-right:0 !important;">
<b-col cols="3">
    <div>
  

  <v-layout >
    <v-flex xs12 sm6 offset-sm3>
      <v-card style="width:365px">
        <v-img
          class="white--text"
          height="300px"
          src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
        >
          <v-container fill-height fluid>
            <v-layout fill-height>
              <v-flex xs12 align-end flexbox>
                <span class="headline">Top 10 Australian beaches 2</span>
              </v-flex>
            </v-layout>
          </v-container>
        </v-img>
        <center>
        <div class="row">
           <b-col cols="12" class="text-center">
           <span style="font-family:Helvetica ; font-size:20px "><b>Name of Product</b></span><br>
            <span style="font-family:Helvetica ; font-size:14px ">Brand of Product</span><br>
            <span style="font-family:Helvetica ; font-size:14px"><b>Price</b></span>
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
  <b-col cols="3">
    <div>
  

  <v-layout >
    <v-flex xs12 sm6 offset-sm3>
      <v-card style="width:365px">
        <v-img
          class="white--text"
          height="300px"
          src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
        >
          <v-container fill-height fluid>
            <v-layout fill-height>
              <v-flex xs12 align-end flexbox>
                <span class="headline">Top 10 Australian beaches 2</span>
              </v-flex>
            </v-layout>
          </v-container>
        </v-img>
        <center>
        <div class="row">
           <b-col cols="12" class="text-center">
           <span style="font-family:Helvetica ; font-size:20px "><b>Name of Product</b></span><br>
            <span style="font-family:Helvetica ; font-size:14px ">Brand of Product</span><br>
            <span style="font-family:Helvetica ; font-size:14px"><b>Price</b></span>
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
  <b-col cols="3">
    <div>
  

  <v-layout >
    <v-flex xs12 sm6 offset-sm3>
      <v-card style="width:365px">
        <v-img
          class="white--text"
          height="300px"
          src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
        >
          <v-container fill-height fluid>
            <v-layout fill-height>
              <v-flex xs12 align-end flexbox>
                <span class="headline">Top 10 Australian beaches 2</span>
              </v-flex>
            </v-layout>
          </v-container>
        </v-img>
        <center>
        <div class="row">
           <b-col cols="12" class="text-center">
           <span style="font-family:Helvetica ; font-size:20px "><b>Name of Product</b></span><br>
            <span style="font-family:Helvetica ; font-size:14px ">Brand of Product</span><br>
            <span style="font-family:Helvetica ; font-size:14px"><b>Price</b></span>
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
  <b-col cols="3">
    <div>
  

  <v-layout >
    <v-flex xs12 sm6 offset-sm3>
      <v-card style="width:365px">
        <v-img
          class="white--text"
          height="300px"
          src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
        >
          <v-container fill-height fluid>
            <v-layout fill-height>
              <v-flex xs12 align-end flexbox>
                <span class="headline">Top 10 Australian beaches 2</span>
              </v-flex>
            </v-layout>
          </v-container>
        </v-img>
        <center>
        <div class="row">
           <b-col cols="12" class="text-center">
           <span style="font-family:Helvetica ; font-size:20px "><b>Name of Product</b></span><br>
            <span style="font-family:Helvetica ; font-size:14px ">Brand of Product</span><br>
            <span style="font-family:Helvetica ; font-size:14px"><b>Price</b></span>
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

  <Footer/>
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
import Header from './Header.vue'
import Footer from './Footer.vue'
import newArrival from '../images/ladies.jpg'
import phone from '../images/oneplus6.jpg'
import menfashion from '../images/men7.jpg'
import laptop from '../images/laptop5.jpg'


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
    data () {
      return {

        isOpen: false,
         
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
       Footer,
       Header
    }
  }


</script>
<style>

#home{
  margin-top: 50px;
}
</style>

