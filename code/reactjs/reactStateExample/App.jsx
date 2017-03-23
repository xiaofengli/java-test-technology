import React from 'react';
import $ from 'jquery';
class App extends React.Component {
   constructor(props) {
      super(props);
      this.state = {
            "header": "this is header",
             content: "this is content"
  }
   }

   render() {
      var output = "";
      $.each(this.state, function(value) {
              output= output+ value + ' ';
      });
      return (
         <div>
            <h1></h1>
            <h1>{output}</h1>
         </div>
      );
   }
}
export default App;
