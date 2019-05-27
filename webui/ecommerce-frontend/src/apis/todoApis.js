import makeApiCall from './makeApiCalls.js'
export default {
    getTodos(callback) {
        var url = 'api/getTopProducts'
        makeApiCall.makeGetRequest(url,callback)
    },
    getCategory(callback,object1){
        var url= '/api/products/' + object1.value1+ '/'+ object1.value2
        console.log("category url: ",url)
        makeApiCall.makeGetRequest(url,callback)
    },
    getSearch(callback,text){
        //console.log('in the todoApis '+text)

        var url= '/search/search?query='+text
        makeApiCall.makeSearchRequest(url,callback)
    },
    getProductById(callback,id){
        console.log('id:',id)
        var url ='/api/getProduct?productId='+id
        console.log('URL:',url)
        makeApiCall.makeProductRequest(url,callback)
    },
    getMerchants(callback,id){
        console.log('id:',id)
        var url ='/merchant/merchants?productId='+id
        console.log('URL: ',url)
        makeApiCall.makeMerchantRequest(url,callback)
    },
    getFilters(callback,object1){
/* do edit url */
        var url ='/'
        console.log('URL FILTERS: ',url)
        makeApiCall.makeGetRequest(url,callback)
    },
    getUserDetails(callback, userToken){
		makeApiCall.makeGetUserRequest('/user'+'/user?token='+userToken,callback)
	},
	CreateUser(callback, jsonObject){
		makeApiCall.makePostUserRequest('/user' +'/users',callback,jsonObject)
	},
	LoginUser(callback, arrayLogin){
		
		makeApiCall.makePostLoginRequest('/user'+'/login/?username='+arrayLogin[0]+'&password='+arrayLogin[1],callback)
	},
	logOutUser(callback, userToken){
		alert("you are logging out")
		makeApiCall.makeDeleteUserRequest('/user'+'/logout?token='+userToken,callback)
    },
    addItemToCart(callback,object1){
        console.log('token: from url making',object1.value1)
        console.log('product id:',object1.value2)
        console.log('merchant id:',object1.value3)
        var url ='/ordercart/cart/'+object1.value1+'?product='+object1.value2+'&merchant='+object1.value3+'&qty='+object1.value4;
       console.log("URL :",url)
        makeApiCall.makeAddItemToCartRequest(url,callback)
    },
    getItemFromCart(callback,token){
        var url = '/ordercart/detailsCart/'+token;
        console.log("URL:",url)
        makeApiCall.makeGetitemFromCartRequest(url,callback)
    },
    removeItemFromCart(callback,object1){
        console.log('token: from url making',object1.value1)
        console.log('product id:',object1.value2)
        console.log('merchant id:',object1.value3)
        var url ='/ordercart/cart/'+ object1.value1+'?product='+object1.value2+'&merchant='+object1.value3;
        console.log("URL:",url)
        console.log('inside todoapis')
        makeApiCall.makeDeleteItemRequest(url,callback)
    },
    placeOrder(callback,object1){
        var url ='/ordercart/order/'+ object1.value1+'?orderAddress='+object1.value2;
        makeApiCall.makePostOrderRequest(url,callback)
    },
    checkOrderHistory(callback,token){
        console.log('inside todoapis')
        var url ='/ordercart/order/' +token;
        console.log("URL:",url)
        makeApiCall.makeGetOrderHistoryRequest(url,callback)
    }
}