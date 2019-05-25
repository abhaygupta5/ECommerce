<template>
    <div class="header">
        
  
  <a href="" class="logo" style="font-size:45px;font-family:Helevetica"><b>VING.com</b></a>
  <input class="menu-btn" type="checkbox" id="menu-btn" />
  <label class="menu-icon" for="menu-btn"><span class="navicon"></span></label>
  <ul class="menu">

    <li><a href="#work"><b-form-input v-model="text" placeholder="Search Products" style="width:700px;height:50px;position:relative; bottom:5px"></b-form-input></a></li>
    <li> <b-button variant="outline-primary" style="height:50px; width:100px; position:relative; top:15px ;font-size:20px"><b>Search</b></b-button></li>
    <li><a href="#careers"><i class="fas fa-shopping-cart fa-2x"></i></a></li>
     <li><b-button v-b-modal.modal-1 variant="outline-primary" style="height:50px; width:180px ;position:relative; top:15px ; font-size:20px"><b>Login & Signup</b></b-button></li>
      <b-modal id="modal-1" >

        <div class="form1" v-if="isLogin" >
           <b-form @submit="onSubmit"  v-if="show">
          <b-form-group id="input-group-11" label="Username" label-for="input-11">
        <b-form-input
          id="input-11"
          v-model="username"
          required
          placeholder="username"
        ></b-form-input>
      </b-form-group>

       <b-form-group id="input-group-12" label="Password" label-for="input-12">
        <b-form-input
        type="password"
          id="input-12"
          v-model="userpassword"
          required
        ></b-form-input>
        </b-form-group>
        
        <b-button type="submit" variant="success">Sign In</b-button>&nbsp;
        <b-button @click="disableLogin" variant="danger" >New User? Sign Up</b-button>

      
      </b-form>
      </div >

    <div class="profile" v-if="isSignUp">
 <b-form @submit="onSubmitSignUp" @reset="onReset" v-if="show">
      <b-form-group id="input-group-2" label="Full Name" label-for="input-2" ><superscript style="color:red;position:absolute;top: 0px;left: 6rem;">*</superscript>
        <b-form-input
          id="input-2"
          v-model="name1"
          required
          placeholder="Enter name"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-7" label="Username" label-for="input-7"><superscript style="color:red; position:absolute;top: 82px;left: 6rem;">*</superscript>
        <b-form-input
          id="input-7"
          v-model="name2"
          required
          placeholder="username"
        ></b-form-input>
      </b-form-group>
    
    <b-form-group id="input-group-3" label="Mobile Number" label-for="input-3"><superscript style="color:red;position: absolute;top: 167px;left: 8.2rem;">*</superscript>
        <b-form-input
        type="number"
          id="input-3"
          v-model="phone"
          required
          placeholder="Example:1234567891"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-4" label="Password" label-for="input-4"><superscript style="color:red;position: absolute;top: 250px;left: 5.7rem;">*</superscript>
        <b-form-input
        type="password"
          id="input-4"
          v-model="pass1"
          required
        ></b-form-input>
        <b-form-invalid-feedback :state="validation">
        Your password must be 5-12 characters long.
      </b-form-invalid-feedback>
      <b-form-valid-feedback :state="validation">
        Valid now
      </b-form-valid-feedback>
    </b-form-group>

    <b-form-group id="input-group-8" label="Confirm Password" label-for="input-8"><superscript style="color:red;position: absolute;top: 360px;left: 9.5rem;">*</superscript>
        <b-form-input
        type="password"
          id="input-8"
          v-model="pass2"
          required
        ></b-form-input>
        <b-form-invalid-feedback :state="validation2">
        Not matching
      </b-form-invalid-feedback>
      <b-form-valid-feedback :state="validation2">
        Looks good
      </b-form-valid-feedback>
    </b-form-group>      

      <b-form-group
        id="input-group-1"
        label="Email address"
        label-for="input-1"
        description="We'll never share your email with anyone else."
      >
        <b-form-input
          id="input-1"
          v-model="email"
          type="email"
          required
          placeholder="Enter email"
        ></b-form-input>
      </b-form-group>

    <b-form-group id="input-group-5" label="Address 1" label-for="input-5"><superscript style="color:red;position: absolute;
    top: 471px;
    left: 7.7rem;">*</superscript>
        <b-form-input
          id="input-5"
          v-model="address1"
          required
          placeholder="Address"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-6" label="Address 2" label-for="input-6"><superscript style="color:red;
    position: absolute;top: 578px;left: 5.7rem;">*</superscript>
        <b-form-input
          id="input-6"
          v-model="address2"
          optional
          placeholder="Address"
        ></b-form-input>
      </b-form-group>

      <b-button type="reset" variant="danger">Reset</b-button>&nbsp;
      <b-button type="submit" variant="success" >Sign Up</b-button>&nbsp;
  </b-form>
      <!--<UserDetails :parentFunc="userdetails.bind(null,userDisplayName)"/>-->
    </div> 
            
            



      </b-modal>



      <b-modal id="modal-2" v-if="isSignUp">

  
  </b-modal>
    
  
  </ul>

 
</div>
</template>

<style>
body {
  margin: 0;
  font-family: Helvetica, sans-serif;
  background-color: #f4f4f4;
}

a {
  color: #000;
}

/* header */

.header {
    overflow: hidden;
  background-color: #fff;
  box-shadow: 1px 1px 4px 0 rgba(0,0,0,.1);
  position: fixed;
  top:0;
  width: 100%;
  z-index: 3;
}

.header ul {
  margin: 0;
  padding: 0;
  list-style: none;
  overflow: hidden;
  background-color: #fff;
}

.header li a {
  display: block;
  padding: 20px 20px;
  border-right: 1px solid #f4f4f4;
  text-decoration: none;
}

.header li a:hover,
.header .menu-btn:hover {
  background-color: #f4f4f4;
}

.header .logo {
  display: block;
  float: left;
  font-size: 2em;
  padding: 10px 20px;
  text-decoration: none;
}

/* menu */

.header .menu {
  clear: both;
  max-height: 0;
  transition: max-height .2s ease-out;
}

/* menu icon */

.header .menu-icon {
  cursor: pointer;
  display: inline-block;
  float: right;
  padding: 28px 20px;
  position: relative;
  user-select: none;
}

.header .menu-icon .navicon {
  background: #333;
  display: block;
  height: 2px;
  position: relative;
  transition: background .2s ease-out;
  width: 18px;
}

.header .menu-icon .navicon:before,
.header .menu-icon .navicon:after {
  background: #333;
  content: '';
  display: block;
  height: 100%;
  position: absolute;
  transition: all .2s ease-out;
  width: 100%;
}

.header .menu-icon .navicon:before {
  top: 5px;
}

.header .menu-icon .navicon:after {
  top: -5px;
}

/* menu btn */

.header .menu-btn {
  display: none;
}

.header .menu-btn:checked ~ .menu {
  max-height: 240px;
}

.header .menu-btn:checked ~ .menu-icon .navicon {
  background: transparent;
}

.header .menu-btn:checked ~ .menu-icon .navicon:before {
  transform: rotate(-45deg);
}

.header .menu-btn:checked ~ .menu-icon .navicon:after {
  transform: rotate(45deg);
}

.header .menu-btn:checked ~ .menu-icon:not(.steps) .navicon:before,
.header .menu-btn:checked ~ .menu-icon:not(.steps) .navicon:after {
  top: 0;
}

/* 48em = 768px */

@media (min-width: 48em) {
  .header li {
    float: left;
  }
  .header li a {
    padding: 20px 30px;
  }
  .header .menu {
    clear: none;
    float: right;
    max-height: none;
  }
  .header .menu-icon {
    display: none;
  }
}


@import url(https://fonts.googleapis.com/css?family=Roboto);

/****** LOGIN MODAL ******/
.loginmodal-container {
  padding: 30px;
  max-width: 350px;
  width: 100% !important;
  background-color: #F7F7F7;
  margin: 0 auto;
  border-radius: 2px;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  overflow: hidden;
  font-family: roboto;
}

.loginmodal-container h1 {
  text-align: center;
  font-size: 1.8em;
  font-family: roboto;
}

.loginmodal-container input[type=submit] {
  width: 100%;
  display: block;
  margin-bottom: 10px;
  position: relative;
}

.loginmodal-container input[type=text], input[type=password] {
  height: 44px;
  font-size: 16px;
  width: 100%;
  margin-bottom: 10px;
  -webkit-appearance: none;
  background: #fff;
  border: 1px solid #d9d9d9;
  border-top: 1px solid #c0c0c0;
  /* border-radius: 2px; */
  padding: 0 8px;
  box-sizing: border-box;
  -moz-box-sizing: border-box;
}

.loginmodal-container input[type=text]:hover, input[type=password]:hover {
  border: 1px solid #b9b9b9;
  border-top: 1px solid #a0a0a0;
  -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
  -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
  box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
}

.loginmodal {
  text-align: center;
  font-size: 14px;
  font-family: 'Arial', sans-serif;
  font-weight: 700;
  height: 36px;
  padding: 0 8px;
/* border-radius: 3px; */
/* -webkit-user-select: none;
  user-select: none; */
}

.loginmodal-submit {
  /* border: 1px solid #3079ed; */
  border: 0px;
  color: #fff;
  text-shadow: 0 1px rgba(0,0,0,0.1); 
  background-color: #4d90fe;
  padding: 17px 0px;
  font-family: roboto;
  font-size: 14px;
  /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#4787ed)); */
}

.loginmodal-submit:hover {
  /* border: 1px solid #2f5bb7; */
  border: 0px;
  text-shadow: 0 1px rgba(0,0,0,0.3);
  background-color: #357ae8;
  /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#357ae8)); */
}

.loginmodal-container a {
  text-decoration: none;
  color: #666;
  font-weight: 400;
  text-align: center;
  display: inline-block;
  opacity: 0.6;
  transition: opacity ease 0.5s;
} 

.login-help{
  font-size: 12px;
}

.login-btn {
  text-align:center;
  margin-top: 50px;
}

.button {
  line-height: 55px;
  padding: 0 30px;
  background: #004a80;
  color: #fff;
  display: inline-block;
  font-family: roboto;
  text-decoration: none;
  font-size: 18px;
}

.button:hover,
.button:visited {
  background: #006cba;
  color: #fff;
}

</style>
<script>

import UserDetails from './UserDetails'
import { constants } from 'crypto';

  export default {
    
    data() {
      return {
        slide: 0,
        isLogin: true,
        isSignUp : false,
        sliding: null,
        drawer : false,
        name1: '',
        name2: '',
        address1:'',
        address2: '',
        email: '',
        phone: '',
        pass1: '',
        pass2: '',
        DataSendingObject:{ 
          userId : null,
         userDisplayName :'',
         userPhone:{
           type: Number
         } ,
         userName:'',
         userAddressList:[],
         userEmail:'',
         userPassword:''
        },
        show: true,
        comp: [
          { title: 'Home', icon: 'dashboard' },
          { title: 'About', icon: 'question_answer' }
        ]
      }
    },
    props: {
      openDrawer: {
        type: Function,
        default: () => {}
      }
    },
    methods: {
      fetchLoginData(){
        let loginArray=[this.username,this.userpassword]
        //alert("in header "+loginArray)
        this.$store.dispatch('addLoginData',loginArray)
      },
      onSubmit(evt) {
        evt.preventDefault()
        this.fetchLoginData();
      },
      fetchCreateUser(jsonObject){
        //console.log(this.$store);
        console.log('im in fetchcreateuser')
        this.$store.dispatch('addToDoCreateUser', jsonObject)
        // this.$store.dispatch('addToDoCreateUser',jsonObject)
      },
      fetchUserId(){
          this.$store.dispatch('addToDoFetchUserId', getCookie(this.userName))
      },
      fetchUserDetailsById(){
          this.$store.dispatch('getUserDetails',fetchUserId())
      },
      onSlideStart(slide) {
        this.sliding = true
      },
      onSlideEnd(slide) {
        this.sliding = false
      },
      enableDrawer (){
        console.log('---enableDrawer')
         this.openDrawer()
      },
      loadLoginPopup: function(){
        this.$router.push({name: 'loginPopup'})
      },
      onSubmitSignUp(evt) {
        evt.preventDefault()
        alert(JSON.stringify(this.DataSendingObject))
        this.setDataSendingObject()
        alert(JSON.stringify(this.DataSendingObject))
        this.fetchCreateUser(this.DataSendingObject)
      },
      setDataSendingObject(){
        this.DataSendingObject.userId=null,
        this.DataSendingObject.userName=this.name1,
        this.DataSendingObject.userDisplayName=this.name2,
        // let add = [];
        // add.push(this.address1)
        // add.push(this.address2)
        //let DataSendingObject={}
        //Object.assign(this.DataSendingObject, {userAddressList: add})
        //alert(JSON.stringify(this.DataSendingObject)
        this.DataSendingObject.userAddressList=[this.address1,this.address2],
        this.DataSendingObject.userEmail=this.email,
        this.DataSendingObject.userPhone=this.phone,
        this.DataSendingObject.userPassword=this.pass1
      },
      disableLogin(){
        this.isLogin = false,
        this.isSignUp = true
        console.log('ertyuiopsdfgpdfghjkl;')
      },
      enableLogin(){
        this.isSignUp = false,
        this.isLogin = true
      },
      onReset(evt) {
        evt.preventDefault()
        // Reset our DataSendingObject values
        this.email = ''
        this.name1 = ''
        this.phone=''
        this.name2=''
        this.address1=''
        this.address2=''
        this.pass1=''
        this.pass2=''
        // Trick to reset/clear native browser DataSendingObject validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
     },
     computed: {
        validation: function() {
          console.log("hello")
        return this.pass1.length > 4 && this.pass1.length < 13
      },
      validation2: function() {
        console.log("world")
        return this.pass1 === this.pass2;
      }
    }
  }
  
</script>