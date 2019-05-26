<template>
    <div>
       <br>
       <br>
       <br>
      This is confirm address page. {{getUsers.userAddressList}}
      <div v-for="(item,index) in getUsers.userAddressList" v-bind:key="index">
     <input type="radio" :value="item" name="radio" v-model="checked"><strong>&nbsp;{{item}}</strong>
      </div>
      <b-btn variant="success" @click="confirmOrder">Confirm Order</b-btn>
 </div>
</template>

<script>
import {mapGetters, mapActions} from 'vuex'
export default {
    data(){
        return{
            checked:'',
           object1 : {
         value1: '',
         value2: ''
       }
        }
    },
    created(){
       
        var token = localStorage.getItem("token")
         this.$store.dispatch('fetchUserDetails',token);
    },
    computed:{
        ...mapGetters(['getUsers']) 
    },
    methods:{
         confirmOrder(){
             console.log('Order placed',this.checked)
             this.object1.value1 = localStorage.getItem("token")
             this.object1.value2 = this.checked
             this.$store.dispatch('placeOrder',this.object1);
              this.$router.push({name: 'Home'});
         }
    }
}
</script>

