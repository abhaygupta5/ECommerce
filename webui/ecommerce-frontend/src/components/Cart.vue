<template>
    <div class="cont"><br/><br/>
    <div v-if="!(getUserCart.data &&  getUserCart.data.cartItemDetails)" style="margin-left:160px">
        <h1>Your Cart is empty. Please Select products and add them to buy.</h1>
        </div>

        <div v-if="getUserCart.data &&  getUserCart.data.cartItemDetails" style="margin-left:200px">
        <b-container >
          <b-row>
            <b-col cols="3">

              </b-col>
            <b-col cols="3">
              Product name
              </b-col>
              <b-col cols="3">
              Merchant name
              </b-col>
              <b-col cols="3">
             Price
             </b-col>
            </b-row>
            <div v-if="getUserCart.data &&  getUserCart.data.cartItemDetails">
                          <b-row v-for="(item,index) in getUserCart.data.cartItemDetails" v-bind:key="index">
                <b-col cols="3" >
                 <input type="radio" v-model="checked" :value="item.productId">
                 

                    </b-col>
                    <b-col cols ='3'>
                      {{item.productName}}
                      </b-col>
                        <b-col cols ='3'>
                      {{item.merchantName}}
                      </b-col>
                       
                        <b-col cols ='3'>
                      {{item.price}}
                      </b-col>
                </b-row>
            </div>
        </b-container>
       <p> Select item to remove from cart and press Place order to confirm your current order.</p>
       <p><b-button variant="danger" @click="removeFromCart">Remove</b-button></p>
        <p>
        <b-button variant="success" @click="placeOrder">Place Order</b-button></p>
        </div>
        </div>
</template>
<style>
.cont{
  font-family: Helevetica;
  font-size:20px
}
</style>
<script>
import {mapGetters, mapActions} from 'vuex'

export default {
    data(){
        return{
            checked :'',
            isCart :false,
            userId :'',
            object1 : 
       {
         value1: '',
         value2:{
           type: Number
         },
         value3:{
           type: Number
         }
        
       },
       cartProducts :[],
       data:['Pragati','Mehrotra']
        }
    },
    computed:{
   ...mapGetters(['getUserCart'])
  },
  created(){
      console.log('from created:',this.$store.getters.getUserCart)
       if(this.$store.getters.getUserCart.data == null){

         this.isCart == true
         return this.isCart
       }
       else {
         this.isCart == false
         return this.isCart
       }
  },
 methods:{
     removeFromCart(){
        alert('Product is removed.')
         console.log(this.checked);
         var token = localStorage.getItem("token");
         var prodId = this.checked ;
         var merchantId
        console.log('product id:',prodId)
         
         var list=[];
         this.userId =  this.$store.getters.getUserCart.data.userId
         console.log('userID:',this.userId)
       this.$store.getters.getUserCart.data.cartItemDetails.map(function(value, key) {
     list.push(value);
   });
       console.log(list)
       list.map(function(key){
           if(key.productId == prodId)
              {
                console.log('inside if')
                  merchantId = key.merchantId
                }
          })
            console.log('Merchantid',merchantId)  
            this.object1.value1= token,
        this.object1.value2 =prodId,
        this.object1.value3 =merchantId,
        this.$store.dispatch('removeItemFromCart',this.object1)
        },
     placeOrder(){
         var id= this.$store.getters.getUserCart.data.userId
         console.log(id);
         this.$router.push('/confirmaddress/'+id);
     }
 }
  
  
}

</script>