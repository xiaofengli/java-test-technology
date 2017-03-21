var config = {
   entry: '/Users/xiaofeng/reactjs/reactApp/main.js',
	
   output: {
      path:'/Users/xiaofeng/reactjs/reactApp',
      filename: 'index.js',
   },
	
   devServer: {
      inline: true,
      port: 8081
   },
	
   module: {
      loaders: [
         {
            test: /\.jsx?$/,
            exclude: /node_modules/,
            loader: 'babel-loader',
				
            query: {
               presets: ['es2015', 'react']
            }
         }
      ]
   }
}

module.exports = config;
