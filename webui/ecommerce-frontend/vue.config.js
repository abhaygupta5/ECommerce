module.exports = {
    devServer:{
        proxy: {
            '/api': {
                target: "http://172.16.20.64:8080",
                changeOrigin:true,
                pathRewrite: {
                    '^/api': ''
                }
            },
            '/search': {
                target: "http://172.16.20.64:8085",
                changeOrigin:true,
                pathRewrite:{
                    '^/search': ''
                }
            },
            '/merchant' :{
                target : "http://172.16.20.64:8081",
                changeOrigin : true,
                pathRewrite:{
                    '^/merchant':''
                }
            },
            '/user': {
                target: "http://172.16.20.72:8083",
                changeOfOrigin: true,
                pathRewrite: {
                    '^/user': ''
                }
            },
            '/ordercart': {
                target: "http://172.16.20.72:8082",
                changeOfOrigin: true,
                pathRewrite: {
                    '^/ordercart': ''
                }
            }
        }
    }
}