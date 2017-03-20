function add(value1) {
  return function doAdd(value2) {
    return value1 + value2;
  };
}

var increment = add(1);
var foo = increment(2);
console.log(foo)
// foo equals 3
