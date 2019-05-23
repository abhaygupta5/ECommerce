<template>
    <div id="UserDetails">
        <h3 style="margin:20px;">Login and Security</h3>
        <section>
            <section>
                <span>Name:</span>
                <button id="rcorners">Edit</button><br>
                <div>rohan sharma</div>
            </section>
            <section>
                <span>Username:</span>
                <br>
                <div>ronny</div>
            </section>
            <section>
                <span>Email:</span>
                <button id="rcorners"><div>Edit</div></button><br>
                <div>rohan@gmail.com</div>
            </section>
            <section>
                <span>Mobile Number</span>
                <button id="rcorners"><div>Edit</div></button><br>
                <div>798899</div>
            </section>
            <section>
                <span>Password</span>
                <button id="rcorners"><div>Edit</div></button><br>
                <div>blablabla</div>
            </section>
            <section>
                <span>Default Address</span>
                <button id="rcorners"><div>Edit</div></button><br>
                <div>blablabla</div>
            </section>
            
            <section>
                <span>Order History</span>
                <button style="border-radius: 20px;border: 2px solid #73AD21;width: 60px;height: 58px; float: right;"><div>Buy Now</div></button><br>
                <div>blablabla</div>
            </section>
        </section>
    </div>
</template>

<script>
import { mapActions} from 'vuex'
export default {
    name: 'UserDetails',
    created() {},
    computed: {
      ...mapActions(['fetchDetails'])
    },
    mounted() {
      this.$store.dispatch('fetchDetails')  
    },
    methods:{
        // getDetails(){
        //     ...mapActions(['fetchDetails']),
        //     this.$store.dispatch('fetchDetails')
        // }
    }
}
</script>

<style>
#UserDetails{
    margin-left: 20px;
    margin-top: 100px;
}

section{
    border-style: outset;
}
section section span{
    /*text-shadow: 3px 1.5px rgb(0, 255, 234);*/
}
section section{
    border-style:solid;
    border-color: rgb(107, 202, 214);
    padding: 15px;
}
#rcorners {
  border-radius: 20px;
  border: 2px solid rgb(131, 196, 58);
  width: 60px;
  height: 50px; 
  float: right;
}
button{
    text-align: center;
}
</style>