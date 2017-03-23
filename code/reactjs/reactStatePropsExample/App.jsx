import React from 'react';
class App extends React.Component {

    constructor() {
     super();
     
      this.state = {
         header: "this is header",
         content: "this is content"
      }
    }
    
   render() {
      return (
         <div>
            <h1><Header headerProp = {this.state.header}/></h1>
            <h2><Content contentProp = {this.state.content}/></h2>
         </div>
      );
   }
}

class Header extends React.Component {
      render() {
        return( <div> {this.props.headerProp} </div>);
      }
}

class Content extends React.Component {
     render() {
        return(<div>{this.props.contentProp}</div>);
     }
}

export default App;
