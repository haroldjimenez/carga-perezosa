angular
  .module('CargaPerezosa')
  .controller('cargaArchivosCtrl', ['$scope','Uploadfile','Ejecuciones','$mdDialog',function($scope,Uploadfile,Ejecuciones,$mdDialog) {
	  
    $scope.init = function(){
    	$scope.file = null;
    	$scope.user = {
    		 document: null
    	}
    }
    $scope.todos = [
                  1,2,3,4,5,6,7,8,9,98,17,15,14,324,234,32,44
                    ]; 
    
 // upload on file select or drop
    $scope.upload = function () {
    	if(!$scope.file){
    		$mdDialog.show(
				      $mdDialog.alert()
				        .title('Error')
				        .textContent('Seleccione un archivo')
				        .ok('Aceptar!')
				        // You can specify either sting with query selector
				        .openFrom('#left')
				        // or an element
				        .closeTo(angular.element(angular.element(document.body)))
				    );
    		return;
    	}
        console.log($scope.file);
        Uploadfile.subirArchivo($scope.file,$scope.user.document).then(
        		function(response){
        			var contentType = response.cabezera["Content-Type"] || "application/octet-stream";
        		    var urlCreator = window.URL || window.webkitURL || window.mozURL || window.msURL;
        		    if (urlCreator) {
        		        var blob = new Blob([response.dato], { type: contentType });
        		        var url = urlCreator.createObjectURL(blob);
        		        var a = document.createElement("a");
        		        document.body.appendChild(a);
        		        a.style = "display: none";
        		        a.href = url;
        		        a.download = "archivo-respuesta.txt"; //you may assign this value from header as well 
        		        a.click();
        		        window.URL.revokeObjectURL(url);
        		    }
        		    $scope.consultaEjecuciones();
        		},function(error){
        			mostrarMensaje(error);
        			$scope.consultaEjecuciones();
        		});
        $scope.init();
    };
    
    $scope.consultaEjecuciones =  function() {
    	Ejecuciones.consultar().then(function (data) {
			$scope.ejecuciones = data;
		},function (error) {
			mostrarMensaje(error);
		});
	}
    
    function mostrarMensaje(response){
    	 $mdDialog.show(
			      $mdDialog.alert()
			        .title('Error')
			        .textContent(response)
			        .ok('Aceptar!')
			        .openFrom('#left')
			        .closeTo(angular.element(angular.element(document.body)))
			    );
    }
    
    $scope.consultaEjecuciones();
  }]);