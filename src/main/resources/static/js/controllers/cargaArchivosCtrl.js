angular
  .module('CargaPerezosa')
  .controller('cargaArchivosCtrl', ['$scope','Uploadfile',function($scope,Uploadfile) {
	  
    $scope.user = {
      document: ''
     
    }
    
 // upload on file select or drop
    $scope.upload = function (file) {
        console.log($scope.file);
        Uploadfile.subirArchivo($scope.file,$scope.user.document).then(
        		function(data, status, headers){
        			var contentType = headers["content-type"] || "application/octet-stream";
        		    var urlCreator = window.URL || window.webkitURL || window.mozURL || window.msURL;
        		    if (urlCreator) {
        		        var blob = new Blob([data], { type: contentType });
        		        var url = urlCreator.createObjectURL(blob);
        		        var a = document.createElement("a");
        		        document.body.appendChild(a);
        		        a.style = "display: none";
        		        a.href = url;
        		        a.download = "archivoRespuesta.txt"; //you may assign this value from header as well 
        		        a.click();
        		        window.URL.revokeObjectURL(url);
        		    }
        		},function(){
        			
        		});
    };
  }]);