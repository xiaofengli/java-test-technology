var config = {
   context: __dirname,
   entry:'/Users/xiaofeng/tutorial/code/reactjs/reactRouterExample/main.js',

   output: {
      path:__dirname,
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