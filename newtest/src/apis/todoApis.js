import makeApiCall from './makeApiCall.js'

export default { 
	getUserDetails(callback){
		makeApiCall.makeGetRequest('',callback)
	},
	CreateUser(callback, jsonObject){
		makeApiCall.makePostRequest('/api' +'/users',callback,jsonObject)
	},
	LoginUser(callback, arrayLogin){
		alert("in todoapi "+arrayLogin)
		makeApiCall.makePostLoginRequest('/api'+'/login/?username='+arrayLogin[0]+'&password='+arrayLogin[1],callback)
	}
	
}