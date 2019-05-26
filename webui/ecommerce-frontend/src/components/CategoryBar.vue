<template>
<div >
        
<b-button  @click="goToSearch" variant="outline-primary" style="height:50px; width:180px ;position:relative; top:15px ; font-size:20px ;margin:5px" ><b>Women's Wear</b></b-button>
<b-button  @click="goToSearch" variant="outline-primary" style="height:50px; width:180px ;position:relative; top:15px ; font-size:20px ;margin:5px"><b>Men's Wear</b></b-button>
<b-button  @click="goToMobiles" variant="outline-primary" style="height:50px; width:180px ;position:relative; top:15px ; font-size:20px ;margin:5px"><b>Mobiles</b></b-button>
<b-button  @click="goToSearch" variant="outline-primary" style="height:50px; width:180px ;position:relative; top:15px ; font-size:20px ;margin:5px"><b>Laptops</b></b-button>
<b-button  @click="goToSearch" variant="outline-primary" style="height:50px; width:180px ;position:relative; top:15px ; font-size:20px ;margin:5px"><b>Books</b></b-button>
<b-button  @click="goToSearch" variant="outline-primary" style="height:50px; width:180px ;position:relative; top:15px ; font-size:20px ;margin:5px"><b>Suitcases</b></b-button>
<b-button  @click="goToSearch" variant="outline-primary" style="height:50px; width:180px ;position:relative; top:15px ; font-size:20px ;margin:5px"><b>Backpacks</b></b-button>
<b-button  @click="goToSearch" variant="outline-primary" style="height:50px; width:180px ;position:relative; top:15px ; font-size:20px ;margin:5px"><b>Beauty Products</b></b-button>
 </div>
</template>

<script>

export default {
    name:'categoryBar',
    methods:{
        goToSearch: function(){
         
        this.$router.push({name: 'Search'});
      },
      goToMobiles: function(){

        this.$router.push({name: 'Mobiles'});
        console.log("mobiles");
            this.$store.dispatch('fetchMobiles');
            this.$store.dispatch('fetchFilters',electronics,mobile);
      }
    }
}
</script>
