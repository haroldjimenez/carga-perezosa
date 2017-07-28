var app = angular.module('CargaPerezosa');

app.service('Ejecuciones', [ '$http', '$q', function($http, $q) {
	
	this.consultar = function() {
		var deferred = $q.defer();

		$http.get("consultar")
			.success(function(data) {
				deferred.resolve(data);
			}).error(function(data, status, headers){
				deferred.reject(headers()['error']);
			})
			return deferred.promise;
		}
} ]);