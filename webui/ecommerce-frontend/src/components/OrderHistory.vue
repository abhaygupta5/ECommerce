<template>
    <div class="orderHistory">
        <br>
        <br>
        <div >Your Order History is here.</div>
        <br>
        <br>
        <b-container style="width:100%">
            <b-row>
                <b-col cols="5">
                    Order ID
                    </b-col>
                    <b-col cols="3">
                   Product Name
                    </b-col>
                    <b-col cols="3">
                  Delievery Address
                    </b-col>
                    <b-col cols="1">
                    Price
                    </b-col>
                </b-row>
                <b-row v-for="(item,index) in   getOrderHistory" v-bind:key="index">
               <b-col cols="5">
                   {{item.orderId}}
                    </b-col>
                    <b-col cols="3" >
                   {{item.productDTO.productName}}
                    </b-col>
                    <b-col cols="3">
                   {{item.orderAddress}}
                    </b-col>
                    <b-col cols="1" >
                   {{item.totalPrice}}
                    </b-col>
                </b-row>
            </b-container>
        
    </div>
</template>
<script>
import {mapGetters, mapActions} from 'vuex'
export default {
    computed:{
        ...mapGetters(['getOrderHistory'])
    }
}
</script>
<style>
.orderHistory{
    font-family: Helevetica;
    font-size:20px;
    margin-left:180px

}
</style>
