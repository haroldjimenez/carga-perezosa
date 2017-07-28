var app = angular.module('CargaPerezosa');

app.service('Uploadfile', [ '$http', '$q', function($http, $q) {
	
	this.subirArchivo = function(archivo, nombre) {
		var deferred = $q.defer();
		var formData = new FormData();
		formData.append("nombre", nombre);
		formData.append("archivo", archivo);
		$http.post("procesarArchivo", formData, 
				{headers: {	"Content-type": undefined},transformRequest: angular.indentity})
			.success(function(data, status, headers) {
				var response = {
						dato:data,
						cabezera:headers};
				deferred.resolve(response);
			}).error(function(data, status, headers){
				console.log(headers()['error']);

				deferred.reject(headers()['error']);
			})
			return deferred.promise;
		}
} ]);