function myFunction(a, b) {
    return a * b;
}
var myObject = myFunction.call(myObject, 10, 2);     // Will return 20
console.log(myObject);
