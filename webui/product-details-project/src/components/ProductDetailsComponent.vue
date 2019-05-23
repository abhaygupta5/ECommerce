<template>
    <div class="product-details">
        <div class="product-name">
        <b><h3 id="prod-name">iPhone 10</h3></b>
        </div>
        <div class="other-attributes">
        <h4>.4.7-inch Retina HD display</h4>
        <h4>.12MP camera and 4K video</h4>
        <h4>.Touch ID for secure authentication</h4>
        </div>
        <div class="price-and-addtocart">
        <b><h3 id="price">Price: Rs 40000&nbsp;<b-button variant="primary">Add to cart</b-button></h3></b>
        </div>
    </div>
</template>
<script>
export default {
    name: 'ProductDetailsComponent'
}
</script>
<style>
.product-name{
    margin-top: 15%;
    margin-right: 50%;
}
.other-attributes{
    font-family: Roboto,Arial,sans-serif;
}
#prod-name{
    color: blueviolet
}
#price{
    color: chartreuse;
}
.product-details{
    border-left: 1px solid grey;
    border-right: 1px solid gray;
}
</style>
