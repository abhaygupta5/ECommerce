import axios from 'axios'

export default {
	makeGetRequest (path, callback){
		axios.get(path)
			.then(callback)
			.catch((error) => {console.log(error)})
    },
	makePostRequest(path, callback, jsonObject){
		axios.post(path, jsonObject)
			.then(callback)
			.catch((error) => {console.log(error)})
	}
	/*
	makePutRequest(path, callback, fail, payload, config){
		axios.put(path, payload, config)
			.then(callback)
			.catch((error) => {console.log(error)})
	},
	makeDeleteRequest(path, callback, fail){
		axios.delete(path)
			.then(callback)
			.catch((error) => {console.log(error)})
	}
	*/
}