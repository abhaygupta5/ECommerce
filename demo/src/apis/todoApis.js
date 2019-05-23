import makeApiCall from './makeApiCall.js'

export default { 
	getUserDetails(callback){
			makeApiCall.makeGetRequest('',callback)
	}
	
}