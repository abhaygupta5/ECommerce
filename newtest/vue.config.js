module.exports = {
    devServer: {
        port: 8081,
        proxy: {
            '/api': {
                target: "http://172.16.20.72:8083",
                changeOfOrigin: true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        }
    }
}