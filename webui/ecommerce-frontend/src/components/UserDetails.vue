<template>
<div>
    <div id="UserDetails">
        <h2 style="position:relative; left:90px"><b><u>Login and Security</u></b></h2>
        <br>
        <b-container style="margin-left:0px">
            
            
               <b-row>
                <b-col cols="4">
                <div style="display:inline-block; width:700px; font-family:Helevetica ;font-size:30px">Name:</div>
                </b-col>
                <b-col cols="4">
                     <div v-if="!this.edit.name" id="displayName" style="display:inline-block; width:500px;font-family:Helevetica; margin-top:10px;font-size:20px">{{getUsers.userDisplayName}}</div>
                    <input type="text" v-model="newName" v-if="this.edit.name" placeholder="Enter Name">
                 </b-col>
                <b-col cols="4">
               <b-button   @click="EditFunctionalityName" variant="outline-primary" style="height:30px; width:100px; margin-top:20px ;font-size:15px"><b>Edit</b></b-button>
               </b-col>
               </b-row>
               <b-row>
                <b-col cols="4">
                <div style="display:inline-block; font-family:Helevetica; width:700px;font-size:30px">UserName:</div>
                </b-col>
                <b-col cols="4">
                     <div id="displayName" style="display:inline-block; width:500px;font-family:Helevetica; margin-top:10px; font-size:20px">{{getUsers.userName}}</div>
                        
                 </b-col>
                <b-col cols="4">
               <!-- <b-button  variant="outline-primary" style="height:30px; width:100px; margin-top:20px ;font-size:15px"><b>Edit</b></b-button> -->
               </b-col>
               </b-row>
               <b-row>
                <b-col cols="4">
                <div style="display:inline-block; width:700px;font-size:30px">Email:</div>
                </b-col>
                <b-col cols="4">
                     <div id="displayName" v-if="!this.edit.email" style="display:inline-block; width:500px;font-family:Helevetica;margin-top:10px; font-size:20px">{{getUsers.userEmail}}</div>
                    <input type="email" v-model="newEmail" v-if="this.edit.email" placeholder="Enter Email">
                 </b-col>
                <b-col cols="4">
               <b-button  variant="outline-primary" style="height:30px; width:100px; margin-top:20px ;font-size:15px"><b>Edit</b></b-button>
               </b-col>
               </b-row>
                  <b-row>
                      <b-row>
                <b-col cols="4">
                <div style="display:inline-block; width:700px; font-family:Helevetica ;font-size:30px">Password:</div>
                </b-col>
                <b-col cols="4">
                     <div id="displayName" v-if="!this.edit.password" style="display:inline-block; width:500px;font-family:Helevetica; margin-top:10px;font-size:20px">*******</div>
                        <input type="text" v-model="newPassword" v-if="this.edit.password" placeholder="Enter Password">
                 </b-col>
                <b-col cols="4">
               <b-button   variant="outline-primary" style="height:30px; width:100px; margin-top:20px ;font-size:15px"><b>Edit</b></b-button>
               </b-col>
               </b-row>
                <b-col cols="4">
                <div style="display:inline-block; width:700px;font-size:30px">Mobile Number:</div>
                </b-col>
                <b-col cols="4">
                     <div id="displayName" v-if="!this.edit.phone" style="display:inline-block; width:500px;font-family:Helevetica; margin-top:10px; font-size:20px">{{getUsers.userPhone}}</div>
                    <input type="number" v-model="newPhone" v-if="this.edit.phone" placeholder="Enter Phone Number">
                 </b-col>
                <b-col cols="4">
               <b-button  variant="outline-primary" style="height:30px; width:100px; margin-top:20px ;font-size:15px"><b>Edit</b></b-button>
               </b-col>
               </b-row>
                

               <b-row>
                <b-col cols="4">
                <div style="display:inline-block; width:700px;font-size:30px"> Address:</div>
                </b-col>
                <b-col cols="4">
                    <div id="address">
                   <li v-if="!this.edit.address" style="display:inline-block; width:500px;font-family:Helevetica; font-size:20px">{{getUsers.userAddressList[0]}}</li></div>
                    <li v-if="this.edit.address"><input type="text" v-model="newAddress"></li>
                 </b-col>
                <b-col cols="4">
               <b-button  variant="outline-primary" style="height:30px; width:100px; margin-top:20px ;font-size:15px"><b>Edit</b></b-button>
               </b-col>
               </b-row>
               </b-container>
        
            
    </div>
    <br>
        <div >
                
                <b-button @click="setUpdateRequestObject" variant="primary" style="position:relative; left:90px">Save changes</b-button>
                
            </div>
            <br>
            <div >
                
                <b-button variant="danger" @click="SignOutUser" style="position:relative; left:90px">Sign out</b-button><br><br>
                </div>
                <div>
                 <b-button variant="outline-primary" @click="checkHistory" style="position:relative; left:90px">Order History</b-button><br>
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
            ResponseObject: null,
            edit: {
                name: false,
                password: false,
                address: false,
                phone: false,
                email: false
            }
            // UpdateRequestObject: {
            //     //alert("in new object"),
            //     userId : this.$store.getters.getUsers.userId,
            //     userName: this.$store.getters.getUsers.userName,
            //     userDisplayName : this.$store.getters.getUsers.userDisplayName,
            //     userPhone: this.$store.getters.getUsers.userPhone,
            //     userAddressList: this.$store.getters.getUsers.userAddressList,
            //     userEmail: this.$store.getters.getUsers.userEmail,
            //     userPassword: this.$store.getters.getUsers.userPassword
            // },
            // temporaryStore: {
            //     userId: this.$store.getters.getUsers.userId,
            //     userName: this.$store.getters.getUsers.userName,
            //     userDisplayName: this.$$store.getters.getUsers.userDisplayName,
            //     userPhone: this.$store.getters.getUsers.userPhone,
            //     userAddressList: this.$store.getters.getUsers.userAddressList,
            //     userEmail: this.$store.getters.getUsers.userEmail,
            //     userPassword: this.$store.getters.getUsers.userPassword
            // }
        }
    },
    created() {
        this.$store.dispatch('fetchUserDetails',localStorage.getItem("token"))
        // console.log("userid: created",this.$store.getters.getUsers.userId);
      //alert(this.state.details)
     
       
    },
    computed: {
      ...mapActions(['fetchUserDetails','checkOrderHistory']),
       ...mapGetters(['getUsers'])

    },
    
    methods:{
        EditFunctionalityName(){
            this.edit.name=true
            //this.UpdateDisplayName()
        }
        ,
        EditFunctionalityAddress(){
            this.edit.address=true
            //this.UpdateAddress()
        }
        ,
        EditFunctionalityPassword(){
            this.edit.password=true
            //this.UpdatePassword()
        }
        ,
        EditFunctionalityPhone(){
            this.edit.phone=true
            //this.UpdatePhone()
        }
        ,
        EditFunctionalityEmail(){
            this.edit.email=true
            //this.UpdateEmail()
        }
        ,
        SignOutUser(){
            this.userToken=localStorage.getItem("token")
            localStorage.removeItem("token");
            //this.$router.push({name:'Home'});
            this.fetchUserOut();
            this.$router.push('/')
            window.location.reload(true)
           
        },
        fetchUserOut(){
            this.$store.dispatch('addUserOut',this.userToken)
        },
        checkHistory(){
             console.log('in check history component');
              this.userToken= localStorage.getItem("token")
             console.log('inside store user token',this.userToken)
            this.$store.dispatch('checkOrderHistory',this.userToken)
             this.$router.push({name:'OrderHistory'});
        }
        // },
        // setUpdateRequestObject(){
        //     //alert(this.newEmail +" and "+this.UpdateRequestObject.userDisplayName);
        //     console.log(this.temporaryStore.userDisplayName)
        // this.UpdateRequestObject.userDisplayName=this.temporaryStore.userDisplayName
        // this.UpdateRequestObject.userAddressList=[this.temporaryStore.newAddress," "],
        // this.UpdateRequestObject.userEmail=this.temporaryStore.newEmail,
        // this.UpdateRequestObject.userPhone=this.temporaryStore.newPhone,
        // this.UpdateRequestObject.userPassword=this.temporaryStore.newPassword,
        // console.log(this.UpdateRequestObject)
        // // console.log(this.UpdateRequestObject)
        // // console.log(this.newName)
        // // console.log(this.newPhone)
        // this.fetchUpdateUserDetails();
        // },
        // fetchUpdateUserDetails(){

        // }
    
    // computed: {
    //     UpdateDisplayName(){
    //         this.temporaryStore.userDisplayName=this.newName
    //     },
    //     UpdatePassword(){
    //         this.temporaryStore.userPassword=this.newPassword
    //     },
    //     UpdateEmail(){
    //         this.temporaryStore.userEmail=this.newEmail
    //     },
    //     UpdatePhone(){
    //         this.temporaryStore.userPhone=this.newPhone
    //     },
    //     UpdateAddress(){
    //         this.temporaryStore.userAddressList=this.newAddress
    //     }
    // }
    //
//}
}
}
</script>

<style>
#UserDetails{
    margin-left: 20px;
    margin-top: 100px;
}

section{
   
}
section section span{
    /*text-shadow: 3px 1.5px rgb(0, 255, 234);*/
}
section section{
   
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