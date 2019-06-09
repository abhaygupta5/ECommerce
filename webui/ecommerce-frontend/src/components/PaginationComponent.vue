<template>
    <div class="overflow-auto" id="pag">
      <br>
    <b-pagination-nav v-on:click.native="reloadPage" :link-gen="linkGen" :number-of-pages="numberOfPages()" use-router></b-pagination-nav>
  </div>
</template>

<script>
export default {
    name: 'PaginationComponent',
    components:{
      
    },
    data() {
      return {
        perPage: 3,
        currentPage: 1
      }
    },
    computed: {
      rows() {
        return this.items.length
      }
    },
    methods: {
      linkGen(pageNum) {
        return pageNum === 1 ? '?' : `?page=${pageNum}`
      },
      reloadPage: function(data){
        console.log("reloading", data)
        // window.location.reload()
      },
      numberOfPages(){
        return Math.ceil(this.$store.getters.getCategory.data.length/3)
      }
    }
}

</script>
<style>
#pag{
    margin-left: 35%;
}
#current-page{
  text-align: center;
}
</style>