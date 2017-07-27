var app = angular.module('CargaPerezosa');

app.service('Uploadfile', [ '$http', '$q', function($http, $q) {
	
	this.subirArchivo = function(archivo, nombre) {
		var deferred = $q.defer();
		var formData = new FormData();
		formData.append("nombre", nombre);
		formData.append("archivo", archivo);
		$http.post("http://localhost/carga-perezosa/procesarArchivo", formData, 
				{headers: {	"Content-type": undefined},transformRequest: angular.indentity})
			.success(function(res) {
				deferred.resolve(res);
			}).error(function(msg, code){
				deferred.reject(msg);
			})
			return deferred.promise;
		}
} ]);