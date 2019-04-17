var isNullOrEmpty = function(value){
	return value === null
		|| value === undefined
		|| value === 'null'
		|| value === 'undefined'
		|| value === '';
}

var sortByProperty = function (property) {
    return function (x, y) {
        return ((x[property] === y[property]) ? 0 : ((x[property] > y[property]) ? 1 : -1));
    };
};