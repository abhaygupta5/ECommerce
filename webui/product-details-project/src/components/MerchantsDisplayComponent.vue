<template>
<div>
<b-row>
  <b-col cols="12">
    <div class="merchants">
        <h4 class="merchant1">Sellers:</h4>
        <label class="container"><p class="merchant1">Seller name: Merchant 1 Price: Rs 10000 Rating: <img src="https://nrchealth.com/wp-content/uploads/2016/12/star-ratings-blog2.png" class="rating-img"></p>
  <input type="radio" name="radio" checked="checked">
  <span class="checkmark"></span>
</label>
<label class="container"><p class="merchant2">Seller name: Merchant 2 Price: Rs 10100 Rating: <img src="https://nrchealth.com/wp-content/uploads/2016/12/star-ratings-blog2.png" class="rating-img"></p>
  <input type="radio" name="radio">
  <span class="checkmark"></span>
</label>
<label class="container"><p class="merchant3">Seller name: Merchant 3 Price: Rs 10200 Rating: <img src="https://nrchealth.com/wp-content/uploads/2016/12/star-ratings-blog2.png" class="rating-img"></p>
  <input type="radio" name="radio">
  <span class="checkmark"></span>
</label>
    </div>
  </b-col>
</b-row>
</div>
</template>
<script>
export default {
    name: 'MerchantsDisplayComponent'
}
</script>
<style>
.container {
  display: block;
  position: relative;
  padding-left: 35px;
  margin-bottom: 12px;
  text-align: start;
  cursor: pointer;
  font-size: 22px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  margin-left: 5px;
}

/* Hide the browser's default radio button */
.container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
}

/* Create a custom radio button */
.checkmark {
  position: absolute;
  top: 0;
  left: 5px;
  height: 25px;
  width: 25px;
  background-color: #eee;
  border-radius: 50%;
}

/* On mouse-over, add a grey background color */
.container:hover input ~ .checkmark {
  background-color: #ccc;
}

/* When the radio button is checked, add a blue background */
.container input:checked ~ .checkmark {
  background-color: #2196F3;
}

/* Create the indicator (the dot/circle - hidden when not checked) */
.checkmark:after {
  content: "";
  position: absolute;
  display: none;
}

/* Show the indicator (dot/circle) when checked */
.container input:checked ~ .checkmark:after {
  display: block;
}

/* Style the indicator (dot/circle) */
.container .checkmark:after {
 	top: 9px;
	left: 9px;
	width: 8px;
	height: 8px;
	border-radius: 50%;
	background: white;
}
.merchants{
  top: 9px;
	left: 9px;
}
.merchant1,.merchant2,.merchant3{
  font-family: Roboto,Arial,sans-serif;
  text-align: start;
}
.rating-img{
  width: 80px;
  height: 25px;
}
</style>
