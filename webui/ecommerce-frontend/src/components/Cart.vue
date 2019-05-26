<template>
    <div><br/>
        <h1>This is User's cart</h1>
        <b-container>
            <b-row v-for="(item,index) in getUserCart.data.cartItemDetails" v-bind:key="index">
                <b-col cols="3" >
                 <input type="radio" v-model="checked" :value="item.productId">
                 

                    </b-col>
                </b-row>
        </b-container>
        <p>{{getUserCart.data.cartItemDetails}}</p>
        <b-button variant="danger" @click="removeFromCart">Remove</b-button>
        <p>
        <b-button variant="success" @click="placeOrder">Place Order</b-button></p>
        </div>
</template>
<script>
import {mapGetters, mapActions} from 'vuex'

export default {
    data(){
        return{
            checked :'',
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
 methods:{
     removeFromCart(){
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