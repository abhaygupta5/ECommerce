<template>
    <div>
        <br>
        Your Order History is here.
        <br>
        {{getOrderHistory}}
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
