<template>
    <div id="Cart">
        <b-row>
            <b-col cols="9">
    <b-card
    no-body
    style="max-width: 50rem;"
  
    <h4 slot="header">Shopping Cart</h4>

    <b-card-body>
      
        <div>

            <!-- <span v-for="item in items" key="item">
          <span>{{item.Product}}</span>
          <span><button @click="remove(item)">Remove</button></span>
      </span> -->
        
       <b-table striped hover :items="items" :fields="fields" ></b-table>   

    <!-- <div>
      <div v-for="item in items" key="item">
          <span>{{item.name}}</span>
          <span><button @click="remove(item)">Remove</button></span>
      </div>
    </div> -->

    
  </div>


      <!--<b-card-text>
        Some quick example text to build on the card title and make up the bulk of the card's
        content.
      </b-card-text>-->
    </b-card-body>


    <!--<b-list-group flush>
      <b-list-group-item>Cras justo odio</b-list-group-item>
      <b-list-group-item>Dapibus ac facilisis in</b-list-group-item>
      <b-list-group-item>Vestibulum at eros</b-list-group-item>
    </b-list-group>-->

    <!-- <b-card-body>
      <button @click="remove(item)">Remove</button> 
    </b-card-body> -->

    <b-card-footer>
        <b-button variant="secondary">< Continue Shopping</b-button>
        <b-button style="float:right;" variant="info">Proceed to Check Out</b-button>
    </b-card-footer>
        
  </b-card>
            </b-col>
            <div class="remove-component">
            </div>
            <b-col class="remove">
                <div class="remove-component">
            </div>
                <!--<b-button variant="danger" class="btn" @click="remove(item)">Remove</b-button><br>
                <!-- <b-button variant="danger">Remove</b-button><br>
                <b-button variant="danger">Remove</b-button><br>
                <b-button variant="danger">Remove</b-button><br> -->
                <div v-for="(item, index) in items" key="item">
                    
                    <b-button @click="remove(item, index)" variant="danger" class="btn">Remove</b-button>
                </div>
            </b-col>
            <b-col cols="3">
                    <b-card
                            no-body
                            style="max-width: 17rem;"
                            img-src="data:image/png;base64,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"
                            img-alt="Order Summary"
                            class="summary"
                            img-top
                        >
                            <h4 slot="header">Order Summary</h4>

                            <!-- <b-card-body>
                        <!-- <b-card-text>
                                Shipping and Additional costs are calculated based on value you have entered.
                            </b-card-text> 
                            </b-card-body> -->
                            <b-list-group flush>
                            <b-list-group-item>Order Sub-Total<p style="float: right;">100</p></b-list-group-item>
                            <b-list-group-item>Shipping and Handling<p style="float: right;">100</p></b-list-group-item>
                            <b-list-group-item>Tax<p style="float: right;">100</p></b-list-group-item>
                            <b-list-group-item>Total<p style="float: right;">100</p></b-list-group-item>
                            </b-list-group>

                            
                        </b-card>
            </b-col>
        </b-row>

  
    </div>
</template>

<script>
export default {
    data() {
      return {
        // Note 'isActive' is left out and will not appear in the rendered table
        fields: [
          {
            key: 'Product',
            sortable: true
          },
          {
            key: 'Quantity',
            sortable: true
          },
          {
            key: 'UnitPrice',
            sortable: true
          },
          {
              key: 'Merchant',
              sortable: false
          },
          {
              key: 'SubTotal',
              sortable: true
          },
          {
              key: 'Delete'
          }
        ],
        items: [
          {  UnitPrice: 40, Product: 'Bread', Quantity: 2 , Merchant:'Lakshman'},
          {  UnitPrice: 21, Product: 'Butter', Quantity: 1, Merchant: 'Ram'},
          {  UnitPrice: 89, Product: 'Jam', Quantity: 2, Merchant: 'Shivaji'},
          {  UnitPrice: 118, Product: 'Corn Flakes', Quantity: 3, Merchant: 'Boss' }
        ]
      }
    },
    methods: {
        getSubTotal(item) {
            return item.UnitPrice * item.Quantity
        },
        prepareTableData() {
            this.items.map(item => {
                item.SubTotal = this.getSubTotal(item)

            })
        },
        remove(item, index) {
               console.log('ITEM:', item)
                this.items.splice(index,1)
        }
    },
    created() {
        this.prepareTableData()
    }
    
}
</script>

<style>

#Cart{
    margin-top: 100px;
    margin-left: 30px;
}
.remove-component{
    margin-top: 106px;
}
.remove{
    margin-top: 0px;
    position: absolute;
    margin-left: 790px;
    
}
.btn{
        padding: 9px;
    margin: 3px
}
.summary{
    
}

</style>
