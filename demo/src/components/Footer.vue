<template>
  <section class="footer">
    <div class="container" text-center>
      <div class="row">
        <div class="col-md-3">
          <h1>Useful Links</h1>
          <p>Privacy Policy</p>
          <p>Terms of Use</p>
          <p>Return Policy</p>
          <p>Discount Coupons</p>
        </div>
        <div class="col-md-3">
          <h1>Company</h1>
          <p v-b-modal.modal-scrollable>About Us</p>
          <b-modal id="modal-scrollable" scrollable title="About Us">
            <p class="my-4" v-for="i in 20" :key="i">
              Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis
              in, egestas eget quam. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
            </p>
          </b-modal>
          <p>Contact Us</p>
          <p>Career</p>
          <p>Affiliate</p>
        </div>
        <div class="col-md-3">
          <h1>Follow Us On</h1>
          <p>Facebook</p>
          <p>Youtube</p>
          <p>Linkedin</p>
          <p>Twitter</p>
        </div>
        <div class="col-md-3 footer-image">
            <!--<h1>Download App</h1>-->
            <img src="data:image/png;base64,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">
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'Footer',
  props: {
    //msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.footer{
  margin-top: 50px;
  background: #000;
  color: #fff;
}
.footer p{
  font-size: 12px;
}
.footer h1{
  font-size: 15px;
  margin: 25px 0;
}
span{
  font-size: 12px;
}
</style>
