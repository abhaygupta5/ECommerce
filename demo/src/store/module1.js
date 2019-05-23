import todoApis from '../apis/todoApis.js'

export default{
	state:{
		details: {}
	},
	getters:{
		getUserDetails: state=>state.details
	},
	mutations:{
		SET_DETAILS: () =>{
            state.details=result
        }
	},
	actions:{
		
		fetchDetails: (context) =>{
			//Axios.get('path')
			todoApis.getUserDetails((result) =>{
				context.commit('SET_DETAILS',result.data)
			})
		}
	}
}