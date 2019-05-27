<template>
<div >
 <b-container style="max-width:100%;height:50px">
   <b-row>       
<b-col cols="1.5"><b-button  @click="goToWomen" variant="outline-primary" style="height:50px; width:140px ;position:relative; top:15px ; font-size:15px ;margin:5px" ><b>Women's Wear</b></b-button></b-col>
<b-col cols="1.5"><b-button  @click="goToMen" variant="outline-primary" style="height:50px; width:140px ;position:relative; top:15px ; font-size:15px ;margin:5px"><b>Men's Wear</b></b-button></b-col>
<b-col cols="1.5"><b-button  @click="goToMobiles" variant="outline-primary" style="height:50px; width:140px ;position:relative; top:15px ; font-size:15px ;margin:5px"><b>Mobiles</b></b-button></b-col>
<b-col cols="1.5"><b-button  @click="goToLaptops" variant="outline-primary" style="height:50px; width:140px ;position:relative; top:15px ; font-size:15px ;margin:5px"><b>Laptops</b></b-button></b-col>
<b-col cols="1.5"><b-button  @click="goToBooks" variant="outline-primary" style="height:50px; width:140px ;position:relative; top:15px ; font-size:15px ;margin:5px"><b>Books</b></b-button></b-col>
<b-col cols="1.5"><b-button  @click="goToSuitcases" variant="outline-primary" style="height:50px; width:140px ;position:relative; top:15px ; font-size:15px ;margin:5px"><b>Suitcases</b></b-button></b-col>
<b-col cols="1.5"><b-button  @click="goToBackpacks" variant="outline-primary" style="height:50px; width:140px ;position:relative; top:15px ; font-size:15px ;margin:5px"><b>Backpacks</b></b-button></b-col>
<b-col cols="1.5"><b-button  @click="goToBeautyProducts" variant="outline-primary" style="height:50px; width:140px ;position:relative; top:15px ; font-size:15px ;margin:5px"><b>Beauty Products</b></b-button></b-col>
   </b-row>
 </b-container>
 </div>
</template>

<script>

export default {
    name:'categoryBar',
    data(){
      return{
         object1 : 
       {
         value1: '',
         value2: ''
      }
    }
    },
    methods:{
        goToSearch(){
         
        this.$router.push({name: 'Search'});
      },
      goToMobiles (){
        this.object1.value1 = 'electronics';
        this.object1.value2 = 'mobile'

        this.$router.push({name: 'Category'});
        console.log('mobiles', this.object1);
            this.$store.dispatch('fetchCategory',this.object1);
          //  this.$store.dispatch('fetchFilters',this.object1);
      },

       goToWomen (){
          this.object1.value1 =  'fashion';
        this.object1.value2 = 'women'

         this.$router.push({name: 'Category'});
        console.log('women',this.object1);
            this.$store.dispatch('fetchCategory',this.object1);
          //  this.$store.dispatch('fetchFilters',this.object1);
      },
      goToMen (){
          this.object1.value1 = 'fashion';
        this.object1.value2 = 'men'

       this.$router.push({name: 'Category'});
        console.log('men',this.object1);
            this.$store.dispatch('fetchCategory',this.object1);
           // this.$store.dispatch('fetchFilters',this.object1);
      },
      goToLaptops (){
          this.object1.value1 = 'electronics'
        this.object1.value2 = 'laptop'

        this.$router.push({name: 'Category'});
        console.log('laptop',this.object1);
            this.$store.dispatch('fetchCategory',this.object1);
         //   this.$store.dispatch('fetchFilters',this.object1);
      },
      goToSuitcases(){
          this.object1.value1 = 'luggage';
        this.object1.value2 = 'suitcase'

         this.$router.push({name: 'Category'});
        console.log('suitcases',this.object1);
            this.$store.dispatch('fetchCategory',this.object1);
          //  this.$store.dispatch('fetchFilters',this.object1);
      },
      goToBooks(){
        this.object1.value1 = 'books';
        this.object1.value2 = 'book'

         this.$router.push({name: 'Category'});
        console.log('books',this.object1);
            this.$store.dispatch('fetchCategory',this.object1);
         //   this.$store.dispatch('fetchFilters',this.object1);
      },
      goToBackpacks(){
        this.object1.value1 = 'luggage';
        this.object1.value2 = 'backpack'

        this.$router.push({name: 'Category'});
        console.log('backpacks',this.object1);
            this.$store.dispatch('fetchCategory',this.object1);
         //   this.$store.dispatch('fetchFilters',this.object1);
      },
      goToBeautyProducts(){
        this.object1.value1 = 'beauty';
        this.object1.value2 = 'menAndWomen'

        this.$router.push({name: 'Category'});
        console.log('beauty Products',this.object1);
            this.$store.dispatch('fetchCategory',this.object1);
          //  this.$store.dispatch('fetchFilters',this.object1);
      }
      
    }
}
</script>
