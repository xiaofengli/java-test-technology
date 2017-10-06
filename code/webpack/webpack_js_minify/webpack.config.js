const path = require('path');
const HtmlWebpackPlugin  = require('html-webpack-plugin');
//const cleanWebpackPlugin = require('clean-webpack-plugin');
const UglifyJSPlugin = require('uglifyjs-webpack-plugin');

module.exports = {
  entry: {
    app: './src/index.js'
  },
  output: {
	    filename: '[name].bundle.js',
	    path: path.resolve(__dirname, 'dist'),
      publicPath: '/'
	  },
  plugins: [
     // new CleanWebpackPlugin(['dist']),
      new HtmlWebpackPlugin({
        title: 'Output Management'
      }),
      //new UglifyJSPlugin()
    ],
    devtool: 'inline-source-map',
    devServer: {
      contentBase: './dist'
    }
};
