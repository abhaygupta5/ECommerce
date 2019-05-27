import todoApis from '../apis/todoApis.js'

export default {
    state: {
        topProducts : [],
        category: [],
        search :[],
        productById :[],
        merchants : [],
        filters : [],
        userDetails :[],
        userCart :[],
        createUser : null,
        loginUser :null,
        logOutUser :null,
        removeItem : [],
        placeOrder :[],
        orderHistory :[]
    },
    getters: {
        getTopProducts : (state) => state.topProducts,
        
        getCategory : (state) =>state.category,

        getSearchResult :(state) =>state.search,

        getProductById :(state) =>state.productById,

        getMerchants : (state) =>state.merchants,

        getFilters : (state) =>state.filters,

        getUsers : (state) =>state.userDetails,

        CreateUser: (state) =>state.createUser,
        
        LoginUser: (state)=>state.loginUser,
        
        logOutUser: (state) => state.logOutUser,
        
        getUserCart : (state) => state.userCart ,

        getRemoveItem :(state) =>state.removeItem,

        getPlaceOrder :(state) =>state.placeOrder,

        getOrderHistory :(state) =>state.orderHistory
    },
    mutations: {
        SET_DATA: (state,result) => {
            state.topProducts = result.data
        },
        SET_CATEGORY:(state,result) => {
            state.category = result.data
        },
        SET_SEARCH_DATA :(state,result) =>{
            state.search = result.data
        },
        SET_PRODUCT_BY_ID :(state,result) =>{
            console.log('product',result)
            state.productById = result.data
        },
        SET_MERCHANTS :(state,result) =>{
            console.log('merchant',result)
            state.merchants = result.data
        },
        SET_FILTERS :(state,result) =>{
            console.log('filters',result)
            state.filters = result.data
        },
        SET_USER_DETAILS: (state,result) =>{
            console.log('in store',result.data)
            state.userDetails=result.data
		},
		CREATE_USER: (state, result) =>{
			state.createUser=result
		},
		LOGIN_USER: (state,result) =>{
			state.loginUser=result
		},
		LOG_OUT_USER: (state, result) => {
			state.logOutUser = result
        },
        SET_USER_CART: (state,result) =>{
            state.userCart = result
        },
        REMOVE_ITEM_FROM_CART:(state,result) =>{
            state.removeItem = result
        },
        PLACE_ORDER :(state,result) =>{
            state.placeOrder = result
        },
        CHECK_HISTORY :(state,result) =>{
            state.orderHistory = result.data
        }
        
},
    actions: {
        fetchTopProducts: (context) => {
            todoApis.getTodos((result) => {
                context.commit('SET_DATA',result)
            })
        },
        searchProducts:(context,text) =>{
            todoApis.getSearch((result) =>{
                context.commit('SET_SEARCH_DATA',result)
            },text)
        },
        createEmployee: (context,obj) => {
            todoApis.createTodos((result) => {
                context.commit('SET_DATA',result)
            },obj)
        },
        fetchCategory:(context,object1) =>{
            console.log(object1)
            todoApis.getCategory((result) => {
              context.commit('SET_CATEGORY',result)
            },object1)
        },
        fetchProductById:(context,id) =>{
            console.log('id :',id);
            todoApis.getProductById((result) =>{
                context.commit('SET_PRODUCT_BY_ID',result)
            },id)
        },
        fetchMerchants:(context,id) =>{
            console.log('id :',id);
            todoApis.getMerchants((result) =>{
                context.commit('SET_MERCHANTS',result)
            },id)
        },
        fetchFilters:(context,object1) =>{
            todoApis.getFilters((result) =>{
                context.commit('SET_FILTERS',result)
            },object1)
        },
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
		fetchUserDetails: (context, userToken) =>{
			//Axios.get('path')
			todoApis.getUserDetails((result) =>{
				console.log(result.data)
				
				context.commit('SET_USER_DETAILS',result.data)
			},userToken)
        },
        addToCart:(context,object1) =>{
            todoApis.addItemToCart((result) =>{
                console.log(result.data)
                context.commit('SET_USER_CART',result.data)
            },object1)
        },
        fetchFromCart:(context,token) =>{
            todoApis.getItemFromCart((result) =>{
                console.log(result.data)
                context.commit('SET_USER_CART',result.data)
            },token)
        },
        removeItemFromCart :(context,object1) =>{
            todoApis.removeItemFromCart((result) =>{
                console.log(result.data)
                context.commit('REMOVE_ITEM_FROM_CART',result.data)
            },object1)
            
        },
        placeOrder :(context,object1) =>{
            todoApis.placeOrder((result) =>{
                console.log(result.data)
                context.commit('PLACE_ORDER',result.data)
            },object1)
        },
        checkOrderHistory:(context,token) =>{
            console.log('inside store')
            todoApis.checkOrderHistory((result)=>{
                console.log(result.data)
                context.commit('CHECK_HISTORY',result.data)
            },token)
        }
	}
 }
