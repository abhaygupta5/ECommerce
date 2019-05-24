import makeApiCall from './makeApiCall.js'

export default { 
	getUserDetails(callback){
		makeApiCall.makeGetRequest('',callback)
	},
	CreateUser(callback, jsonObject){
		makeApiCall.makePostRequest('/api' +'/users',callback,jsonObject)
	}
	
}