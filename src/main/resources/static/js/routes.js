var routerApp = angular.module('CargaPerezosa');

routerApp.config(function($stateProvider, $urlRouterProvider) {

//    $urlRouterProvider.otherwise('/about');

    $stateProvider

        // HOME STATES AND NESTED VIEWS ========================================
        .state('home', {
            url: '/home',
            templateUrl: 'template/cargar-archivo.html',
            controller: 'cargaArchivosCtrl'
        })

        // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
        .state('about', {
        	 url: '/home'
            // we'll get to this in a bit       
        });

});