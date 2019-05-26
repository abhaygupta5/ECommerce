<template>
<div class="filter">
    <br><br>
            <strong><h2>&nbsp;Filters:</h2></strong>
            <br/>
            <div class="filter1" v-for="(item,index) in filters " v-bind:key="index">
                <strong><p>&nbsp;{{item.key}}</p></strong>
                <template v-for="element in item.Values">
                    <li :key="element" type="none"> <p>&nbsp;<input type="radio" name="filters" value="some">&nbsp;{{element}}</p> </li>
                </template>
                
                
           
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
    border-right: 2px solid gray;
    margin-left: 40px;
    font-family: Helvetica;
    font-size: x-large;

}
.filter1{
   font-family: Helvetica; 
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