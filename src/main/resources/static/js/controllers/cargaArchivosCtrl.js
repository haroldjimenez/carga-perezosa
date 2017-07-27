angular
  .module('CargaPerezosa')
  .controller('cargaArchivosCtrl', ['$scope','Uploadfile',function($scope,Uploadfile) {
	  
    $scope.user = {
      document: ''
     
    }
    
 // upload on file select or drop
    $scope.upload = function (file) {
        console.log($scope.file);
        Uploadfile.subirArchivo($scope.file,$scope.user.document);
    };
  }]);