import todoApis from '../apis/todoApis.js'

export default {
	state:{
		details: {},
		todos: null
	},
	getters:{
		getUserDetails: state=>state.details,
		CreateUser: state=>state.todos
	},
	mutations:{
		SET_DETAILS: (state,result) =>{
            state.details=result
		},
		CREATE_USER: (state, result) =>{
			state.todos=result
		}
	},
	actions:{

		addToDoCreateUser: (context,jsonObject) =>{
			console.log('46787654')
			todoApis.CreateUser((result) =>{
				console.log('AFTER API CALL', result)
				context.commit('CREATE_USER',result.data)
			},jsonObject)
		},

		fetchDetails: (context) =>{
			//Axios.get('path')
			todoApis.getUserDetails((result) =>{
				context.commit('SET_DETAILS',result.data)
			})
		}
	}
}