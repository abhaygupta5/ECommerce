<template>
    <div class="col12 text-right" >
  <b-dropdown id="dropdown-1" text="Sort by" variant="info" class="m-md-2">
    <b-dropdown-item @click="getSortedProductsAscending">Ascending Price</b-dropdown-item>
    <b-dropdown-item @click="getSortedProductsDescending">Descending Price</b-dropdown-item>
  </b-dropdown>
</div>

</template>
<script>
export default {
    name: "SortByBarComponent",
    methods: {
      getSortedProductsAscending: function(){

      },
      getSortedProductsDescending: function(){

      }
    }
}
</script>
<style>
#dropdown-1{
  padding-right: 50px;
}
</style>