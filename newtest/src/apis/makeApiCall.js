import axios from 'axios'

export default {
	makeGetRequest (path, callback){
		alert("in get request");
		axios.get(path)
			.then(callback)
			.catch((error) => {console.log(error)})
    },
	makePostRequest(path, callback, jsonObject){
		axios.post(path, jsonObject)
			.then(callback)
			.catch((error) => {console.log(error)})
	},
	makePostLoginRequest(path, callback){
		axios.post(path)
			.then(callback)
			.catch((error) =>{console.log(error)})
	},
	makeDeleteRequest(path,callback) {
		axios.delete(path)
			.then(callback)
			.catch((error) => {console.log(error) })
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