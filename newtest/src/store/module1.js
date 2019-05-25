import todoApis from '../apis/todoApis.js'

export default {
	state:{
		details: {},
		todos: null,
		todos2: null,
		todos3: null
	},
	getters:{
		getUserDetails: state=>state.details,
		CreateUser: state=>state.todos,
		LoginUser: state=>state.todos2,
		logOutUser: state => state.todos3
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
		},
		LOG_OUT_USER: (state, result) => {
			state.todos3 = result
		}
	},
	actions:{
		addLoginData: (context,arrayLogin) =>{
			todoApis.LoginUser((result) =>{
				
			    if(result.data.ok==true){
					context.commit('LOGIN_USER',result.data)
					localStorage.setItem("token",result.data.data)
				}
				else{
					alert(result.data.data);
				}
				//console.log(result.data.data)
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
		addUserOut: (context, userToken) =>{
			todoApis.logOutUser( (result) => {
				context.commit('LOG_OUT_USER',result.data)
			}
		,userToken)
		},
		fetchDetails: (context, userToken) =>{
			//Axios.get('path')
			todoApis.getUserDetails((result) =>{
				console.log(result.data)
				
				context.commit('SET_DETAILS',result.data)
			},userToken)
		}
	}
}