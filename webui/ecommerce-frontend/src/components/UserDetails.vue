<template>
<div>
    <div id="UserDetails">
        <h3 style="margin:20px;">Login and Security</h3>
        <section>
            <section>
                <span>Name:</span>
                <button id="rcorners">Edit</button><br>
                <div id="displayName">{{getUsers.userDisplayName}}</div>
            </section>
            <section>
                <span>Username:</span>
                <br>
                <div id="userName">{{getUsers.userName}}</div>
            </section>
            <section>
                <span>Email:</span>
                <button id="rcorners"><div>Edit</div></button><br>
                <div id="email">{{getUsers.userEmail}}</div>
            </section>
            <section>
                <span>Mobile Number</span>
                <button id="rcorners"><div>Edit</div></button><br>
                <div id="phoneNumber">{{getUsers.userPhone}}</div>
            </section>
            <section>
                <span>Password</span>
                <button id="rcorners"><div>Edit</div></button><br>
                <div id="password">{{getUsers.userPassword}}</div>
            </section>
            <section>
                <span>Default Address</span>
                <button id="rcorners"><div>Edit</div></button><br>
                <div id="address" v-for="(item,index) in getUsers.userAddressList" v-bind:key="index">
                   <li>{{item}}</li></div>
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
                 <b-button variant="danger" @click="checkHistory" >Order History</b-button><br>
            </div>
    </div>
</template>

<script>
import {mapGetters, mapActions} from 'vuex'
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
            userToken : '',
            ResponseObject: null
        }
    },
    created() {
        this.$store.dispatch('fetchUserDetails',localStorage.getItem("token"))
      //alert(this.state.details)
     
       
    },
    computed: {
      ...mapActions(['fetchUserDetails','checkOrderHistory']),
       ...mapGetters(['getUsers'])

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
            localStorage.removeItem("token");
            this.$router.push({name:'Home'});
            this.fetchUserOut();
           
        },
        setUserDetails(){
            alert("hi im in setuserdetails ");
            console.log('in user details',getUsers.data);
             console.log(getUsers.data.userId);
            this.userName = getUsers.data.userName;
          
            this.userDisplayName=getUsers.userDisplayName;
            this.userEmail=getUsers.userEmail;
            this.userPhone=getUsers.userPhone;
            this.userPassword=getUsers.userPassword;
            this.userAddressList=getUsers.userAddressList;
        },
        fetchUserOut(){
            this.$store.dispatch('addUserOut',this.userToken)
        },
        checkHistory(){
             console.log('in check history component');
             console.log('inside store user token',localStorage.getItem("token"))
            this.$store.dispatch('checkOrderHistory',localStorage.getItem("token"))
             this.$router.push({name:'OrderHistory'});
        }
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