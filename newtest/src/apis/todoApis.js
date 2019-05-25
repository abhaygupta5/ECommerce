import makeApiCall from './makeApiCall.js'

export default { 
	getUserDetails(callback, userToken){
		makeApiCall.makeGetRequest('/api'+'/user?token='+userToken,callback)
	},
	CreateUser(callback, jsonObject){
		makeApiCall.makePostRequest('/api' +'/users',callback,jsonObject)
	},
	LoginUser(callback, arrayLogin){
		alert("in todoapi "+arrayLogin)
		makeApiCall.makePostLoginRequest('/api'+'/login/?username='+arrayLogin[0]+'&password='+arrayLogin[1],callback)
	},
	logOutUser(callback, userToken){
		alert("you are logging out")
		makeApiCall.makeDeleteRequest('/api'+'/logout?token='+userToken,callback)
	}
	
}