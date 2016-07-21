var app = angular.module('avaliador', []);

app.controller('AvaliadorCtrl', function($scope, $http) {
	$scope.requestService = function(requestData, callbackSucess) {
		$http({
			method : 'POST',
			data : JSON.stringify(requestData),
			url : '/avaliador',
			headers : {
				'Content-Type' : 'application/json; charset=UTF-8'
			}
		}).success(function(data, status, header, config) {
			callbackSucess(data);
		}).error(function(data, status, header, config) {
			console.log(data);
		})
	};
	
	$scope.loadValues = function() {
        var requestTeam = {
				senha : senhaPwd.value
		};
        $scope.requestService(requestTeam, function(data) { 
            $scope.resultado = data;
            $('#complexidadeBorda').css('background', data.cor);
        });
    };
    
    $scope.loadValues();
});





// app.controller('AvaliadorCtrl', function($scope, $http) {
// $http({
// method : 'POST',
// data : JSON.stringify({
// senha : senhaPwd.value
// }),
// url : '/avaliador',
// headers : {
// 'Content-Type' : 'application/json; charset=UTF-8'
// }
// }).success(function(data, status, header, config) {
// $scope.resultado = data;
// }).error(function(data, status, header, config) {
// console.log(data);
// })
// });
