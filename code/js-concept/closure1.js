function closureExample() {

var i = 0;

for (i = 0; i< 3 ;i++) {
setTimeout(function() {
console.log('counter value is ' + i);
}, 1000);
}

}
// call the example function
closureExample();
