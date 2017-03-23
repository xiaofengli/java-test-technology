import React from 'react';
class App extends React.Component {
   render() {
      return (
         <div>
            <h1>{this.props.headerProp}</h1>
            <h2>{this.props.contentProp}</h2>
         </div>
      );
   }
}

App.defaultProps={
 headerProp:"header",
 contentProp:"content"
}
export default App;
