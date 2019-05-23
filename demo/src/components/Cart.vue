<template>
    <div id="Cart">
        
    <b-card
    no-body
    style="max-width: 50rem;"
  >
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
              key: 'Size',
              sortable: false
          },
          {
              key: 'SubTotal',
              sortable: true
          }
        ],
        items: [
          {  UnitPrice: 40, Product: 'Bread', Quantity: 2 , Size:'L'},
          {  UnitPrice: 21, Product: 'Butter', Quantity: 1, Size: 'M'},
          {  UnitPrice: 89, Product: 'Jam', Quantity: 2, Size: 'S'},
          {  UnitPrice: 118, Product: 'Corn Flakes', Quantity: 3, Size: 'L' }
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
        remove(item) {
            
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

</style>
