function asyncOperation(counter) {
    setTimeout(function() {
        console.log('counter value is ' + counter);
    }, 1000);
}

function otherClosureExample() {
    var i = 0;

    for (i = 0; i < 3 ;i++) {
        asyncOperation(i);
    }
}

otherClosureExample();
