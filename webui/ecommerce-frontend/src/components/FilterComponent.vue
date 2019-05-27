<template>
<div class="filter">
    <br><br>
            <strong><h2>Filters:</h2></strong>
           <br>
            <div class="filter1" v-for="(item,index) in filters " v-bind:key="index">
                <strong>{{item.key}}:</strong>
                <div v-for="element in item.Values" v-bind:key="element">
                    <li type="none"> <input type="radio" name="filters" value="some" style="display:inline-block">{{element}} </li>
                </div>
                
                
           
            </div>
            
             
            </div>
</template>
<script>
export default {
    name: "FilterComponent",
    data(){
        return{
            filters:{
                filter1:{
                    key: "Filter1",
                    Values:['Value1','Value2','Value3']
            },
                filter2:{
                    key: "Filter1",
                    Values:['Value1','Value2','Value3']
                }
                }
            }
        }
    }

</script>
<style>
.filter{
   
    margin-left: 10px;
    font-family: Helvetica;
    font-size: 20px;

}
.filter1{
   font-family: Helvetica; 
   font-size: 15px
}
.filter2{
    font-family: Helvetica;
}
.filter3{
    font-family: Helvetica;
}
p {
  font-family: "Amazon Ember",Arial,sans-serif;
}
</style>