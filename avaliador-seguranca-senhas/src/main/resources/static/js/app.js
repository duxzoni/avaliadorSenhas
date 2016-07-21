
var app = angular.module('app', ['ngRoute','ngResource']);

app.config(function($routeProvider){
    $routeProvider
        .when('/avaliador',{
            templateUrl: '/avaliador.html',
            controller: 'avaliadorController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

//var requestService = function(serviceName, requestData, callbackSucess) {
//    $http({
//        method: 'POST',
//        data: JSON.stringify(requestData),
//        url: '/' + serviceName,
//        headers: { 'Content-Type': 'application/json; charset=UTF-8'}
//    }).success(function(data, status, header, config) {
//        callbackSucess(data);           
//    }).error(function(data, status, header, config){
//        console.log(data);
//    });
//};
