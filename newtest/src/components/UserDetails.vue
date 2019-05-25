<template>
<div>
    <div id="UserDetails">
        <h3 style="margin:20px;">Login and Security</h3>
        <section>
            <section>
                <span>Name:</span>
                <button id="rcorners">Edit</button><br>
                <div id="displayName">{{this.userDisplayName}}</div>
            </section>
            <section>
                <span>Username:</span>
                <br>
                <div id="userName">{{this.userName}}</div>
            </section>
            <section>
                <span>Email:</span>
                <button id="rcorners"><div>Edit</div></button><br>
                <div id="email">{{this.userEmail}}</div>
            </section>
            <section>
                <span>Mobile Number</span>
                <button id="rcorners"><div>Edit</div></button><br>
                <div id="phoneNumber">{{this.userPhone}}</div>
            </section>
            <section>
                <span>Password</span>
                <button id="rcorners"><div>Edit</div></button><br>
                <div id="password">{{this.userPassword}}</div>
            </section>
            <section>
                <span>Default Address</span>
                <button id="rcorners"><div>Edit</div></button><br>
                <div id="address">{{this.userAddressList}}</div>
            </section>
            
            <section>
                <span>Order History</span>
                <button style="border-radius: 20px;border: 2px solid #73AD21;width: 60px;height: 58px; float: right;"><div>Buy Now</div></button><br>
            </section>
            <!-- <section>
                <span>Name:</span>
                <button id="rcorners">Edit</button><br>
                <div>rohan sharma</div>
            </section>
            <section>
                <span>Username:</span>
                <br>
                <div> rythmm_sharma</div>
            </section>
            <section>
                <span>Email:</span>
                <button id="rcorners"><div>Edit</div></button><br>
                <div>rohan@gmail.com</div>
            </section>
            <section>
                <span>Mobile Number</span>
                <button id="rcorners"><div>Edit</div></button><br>
                <div>7988995970</div>
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
                <button style="border-radius: 20px;border: 2px solid #73AD21;width: 60px;height: 58px; float: right;"><div>Archieves</div></button><br>
                <div>blablabla</div>
            </section> -->
            
        </section>
    </div>
    <br>
        <div >
                
                <b-button variant="primary">Save changes</b-button>
                
            </div>
            <br>
            <div >
                
                <b-button variant="danger" @click="SignOutUser" >Sign out</b-button><br>
                
            </div>
    </div>
</template>

<script>
import { mapActions, mapGetters} from 'vuex'
export default {
    name: 'UserDetails',
    data(){
        return {
            userId: '',
            userName: '',
            userDisplayName: '',
            userPassword: '',
            userEmail: '',
            userPhone: '',
            userAddressList: [],
            ResponseObject: null
        }
    },
    created() {},
    computed: {
      ...mapActions(['fetchDetails'])
    },
    mounted() {
        //alert("calling");
       this.$store.dispatch('fetchDetails',localStorage.getItem("token"))
      //alert(this.state.details)
      this.setUserDetails()
    },
    methods:{
        // getDetails(){
        //     ...mapActions(['fetchDetails']),
        //     this.$store.dispatch('fetchDetails')
        // }
        cookie(){
            $cookies.set(this.userName,Math.random())
        },
        getCookie(){
            $cookies.get(this.userName)
        },
        SignOutUser(){
            this.userToken=localStorage.getItem("token")
            localStorage.removeItem("token")
            this.fetchUserOut();
            this.$router.go("-1")
        },
        setUserDetails(){
            alert("hi im in setuserdetails "+this.details.userName);
            this.userName=this.getUserDetails.userName;
            this.userDisplayName=this.getUserDetails.userDisplayName;
            this.userEmail=this.getUserDetails.userEmail;
            this.userPhone=this.getUserDetails.userPhone;
            this.userPassword=this.getUserDetails.userPassword;
            this.userAddressList=this.getUserDetails.userAddressList;
        },
        fetchUserOut(){
            this.$store.dispatch('addUserOut',this.userToken)
        }
    },
    computed: {
        ...mapGetters(['getUserDetails'])
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