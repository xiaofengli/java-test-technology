import React from 'react';

class App extends React.Component {
   render() {
         var myStyle = {
          fontSize: 100,
          color: '#FF0000'
       };

      //ternary
      var i = 1;

      return (
         <div>
            {/*hello*/}
            <h1 style={myStyle}> Header</h1>
            <h2>Content</h2>
            {/*hello*/}
            <p data-myattribute = "somevalue">Hello World!!! This is the content</p>
              {1+1}
            <h1>{i == 1?'True!':'False'}</h1>
          </div>
      );
   }
}

export default App;
