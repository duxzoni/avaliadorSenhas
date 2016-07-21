angular.module('hello', []).controller('home', 
function($scope, $http) {
	$http({
        method: 'POST',
        data: JSON.stringify({senha:"12345678"}),
        url: '/avaliador',
        headers: { 'Content-Type': 'application/json; charset=UTF-8'}
    }).success(function(data, status, header, config) {
    	$scope.greeting = data;           
    }).error(function(data, status, header, config){
        console.log(data);
    })
});

//var requestService = function( requestData ) {
//    $http({
//        method: 'POST',
//        data: JSON.stringify({senha:"12345678"}),
//        url: '/avaliador',
//        headers: { 'Content-Type': 'application/json; charset=UTF-8'}
//    }).success(function(data, status, header, config) {
//    	$scope.greeting = data;           
//    }).error(function(data, status, header, config){
//        console.log(data);
//    });
//};