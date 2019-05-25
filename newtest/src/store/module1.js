import todoApis from '../apis/todoApis.js'

export default {
	state:{
		details: {},
		todos: null,
		todos2: null
	},
	getters:{
		getUserDetails: state=>state.details,
		CreateUser: state=>state.todos,
		LoginUser: state=>state.todos2
	},
	mutations:{
		SET_DETAILS: (state,result) =>{
            state.details=result
		},
		CREATE_USER: (state, result) =>{
			state.todos=result
		},
		LOGIN_USER: (state,result) =>{
			state.todos2=result
		}
	},
	actions:{
		addLoginData: (context,arrayLogin) =>{
			todoApis.LoginUser((result) =>{
				
				context.commit('LOGIN_USER',result.data)
				console.log(result.data)
			},arrayLogin)
		},
		addToDoCreateUser: (context,jsonObject) =>{
			//console.log('46787654')
			todoApis.CreateUser((result) =>{
				//console.log('AFTER API CALL', result)
				if(result.data.ok == false){
					alert(result.data.data)
				}
				else{
					context.commit('CREATE_USER',result.data)
				}
				
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