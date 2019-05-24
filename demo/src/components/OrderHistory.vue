<template>
<div id="OrderHistory">
    <h1>Order History</h1>
    <b-card >
        <b-row>
            <b-col cols="4">
        <div>
            <v-layout >
                <v-flex xs12 sm6 offset-sm3>
                <v-card style="width:365px">
                    <v-img
                    class="white--text"
                    height="300px"
                    src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
                    >
                    <v-container fill-height fluid>
                        <v-layout fill-height>
                        <v-flex xs12 align-end flexbox>
                            <span class="headline">Top 10 Australian beaches 2</span>
                        </v-flex>
                        </v-layout>
                    </v-container>
                    </v-img>
                    <center>
                    <div class="row">
                    <b-col cols="12" class="text-center">
                    <span style="font-family:Helvetica ; font-size:20px "><b>Name of Product</b></span><br>
                        <span style="font-family:Helvetica ; font-size:14px ">Brand of Product</span><br>
                        <span style="font-family:Helvetica ; font-size:14px"><b>Price</b></span>
                    </b-col> 
                    </div>
                  </center>
                </v-card>
                </v-flex>
            </v-layout>
        </div>
        </b-col>
        <b-col cols="3">
      <b-card-text id="address">
          <br><br>
          <h1 style="font-family:Helvetica ;">Address:</h1>
            
      </b-card-text><br>
      </b-col>
        </b-row>
    </b-card>
    

</div>
</template>

<script>
export default {
    
}
</script>

<style>

#OrderHistory{
    margin-top: 100px;
    margin-left: 20px;
}

.bv-example-row {
   max-width :100% !important;
   margin-left: 20px !important;

   padding-left :0px !important;
   padding-right :20px !important;
 }
   @media (min-width: 600px) {
     .offset-sm3 {
       margin-left: 0 !important;
    }

    .col-3 {
      padding-left: 0 !important;
      padding-right: 0 !important;
    }
}


.v-btn {
  margin-left :0  !important;
}
</style>
