<template>
    <div class="profile">
        <b-form @submit="onSubmit" @reset="onReset" v-if="show">
    <b-form-group id="input-group-2" label="Full Name" label-for="input-2" ><superscript style="color:red;position:absolute;top: 0px;left: 6rem;">*</superscript>
        <b-form-input
          id="input-2"
          v-model="form.userDisplayName"
          required
          placeholder="Enter name"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-7" label="Username" label-for="input-7"><superscript style="color:red; position:absolute;top: 82px;left: 6rem;">*</superscript>
        <b-form-input
          id="input-7"
          v-model="form.userName"
          required
          placeholder="username"
        ></b-form-input>
      </b-form-group>
    
    <b-form-group id="input-group-3" label="Mobile Number" label-for="input-3"><superscript style="color:red;position: absolute;top: 167px;left: 8.2rem;">*</superscript>
        <b-form-input
        type="number"
          id="input-3"
          v-model="form.userPhone"
          required
          placeholder="Example:1234567891"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-4" label="Password" label-for="input-4"><superscript style="color:red;position: absolute;top: 250px;left: 5.7rem;">*</superscript>
        <b-form-input
        type="password"
          id="input-4"
          v-model="form.userPassword"
          required
        ></b-form-input>
        <b-form-invalid-feedback :state="validation">
        Your password must be 5-12 characters long.
      </b-form-invalid-feedback>
      <b-form-valid-feedback :state="validation">
        Valid Now
      </b-form-valid-feedback>
    </b-form-group>

    <!--<b-form-group id="input-group-8" label="Confirm Password" label-for="input-8"><superscript style="color:red;position: absolute;top: 360px;left: 9.5rem;">*</superscript>
        <b-form-input
        type="password"
          id="input-8"
          v-model="form.password2"
          required
        ></b-form-input>
        <b-form-invalid-feedback :state="validation2">
        Not matching
      </b-form-invalid-feedback>
      <b-form-valid-feedback :state="validation2">
        Looks Good.
      </b-form-valid-feedback>
    </b-form-group   -->

      <b-form-group
        id="input-group-1"
        label="Email address"
        label-for="input-1"
        description="We'll never share your email with anyone else.">
        <b-form-input
          id="input-1"
          v-model="form.userEmail"
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
          v-model="form.userAddress"
          required
          placeholder="Address"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-6" label="Address 2" label-for="input-6"><superscript style="color:red;
    position: absolute;top: 578px;left: 5.7rem;">*</superscript>
        <b-form-input
          id="input-6"
          v-model="form.address2"
          optional
          placeholder="Address"
        ></b-form-input>
      </b-form-group>

      <b-button type="submit" variant="success">Sign Up</b-button>&nbsp;
      <b-button type="reset" variant="danger">Reset</b-button>
      </b-form>
      <!--<UserDetails :parentFunc="userdetails.bind(null,form.name)"/>-->
    </div>
</template>

<script>

import UserDetails from './UserDetails'
import { constants } from 'crypto';

export default {
    name: 'SignUp',
    data() {
      return {
        form: {
          userId : null,
         userDisplayName :'',
         userPhone:{
           type: Number
         } ,
         userName:'',
         userAddress:[],
         userEmail:'',
         userPassword:''
        },
        show: true
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        console.log('****', this.form)
        let add = []
        add.push(this.form.userAddress)

        Object.assign(this.form, {userAddress: add})
        alert(JSON.stringify(this.form))
        this.fetchCreateUser(this.form)
      },
      fetchCreateUser(jsonObject){
        console.log('this.', )
        this.$store.dispatch('addToDoCreateUser', jsonObject)
        // this.$store.dispatch('addToDoCreateUser',jsonObject)
      },
      onReset(evt) {
        evt.preventDefault()
        // Reset our form values
        this.form.email = ''
        this.form.name = ''
        this.form.dob=''
        this.form.mobile=''
        this.form.username=''
        this.form.address1=''
        this.form.address2=''
        this.form.password=''
        this.form.password2=''
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      },
      /*UserDetails(details){
          alert("aagya "+ details);
      }*/
      
    },
    computed: {
      validation() {
        return this.form.userPassword.length > 4 && this.form.userPassword.length < 13;
      },
      validation2() {
        return this.form.password2 === this.form.userPassword;
      }
    }
  
}
</script>

<style>

.profile{
    margin-left: 20px;
    margin-top: 100px;
}

</style>
