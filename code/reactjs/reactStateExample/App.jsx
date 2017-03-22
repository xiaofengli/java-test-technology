import React from 'react';
class App extends React.Component {
   constructor(props) {
      super(props);
      this.state = {
         data: [
            "header": "this is header",
            "content": "this is content"
         ]
      }
   }

   render() {
      return (
         <div>
            <h1>{this.data.header}</h1>
         </div>
      );
   }
}



export default App;
