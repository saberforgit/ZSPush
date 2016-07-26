

var exec    = require('cordova/exec')
exports._listener = {};
exports.on = function (event, callback, scope) {

    if (typeof callback !== "function")
        return;

    if (!this._listener[event]) {
        this._listener[event] = [];
    }

    var item = [callback, scope || window];

    this._listener[event].push(item);
};
   exports.registPush = function(success,fail){
    	exec(success,fail,"Push","registPush",[]);
    };
    exports.logoutPush = function(success,fail){
        	exec(success,fail,"Push","logoutPush",[]);
        };
exports.fireEvent = function (event) {
    var args     = Array.apply(null, arguments).slice(1),
        listener = this._listener[event];

    if (!listener)
        return;

    for (var i = 0; i < listener.length; i++) {
        var fn    = listener[i][0],
            scope = listener[i][1];

        fn.apply(scope, args);
    }
};

