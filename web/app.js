/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('monApp', ['ngRoute','ngResource']);

angular.module('monApp').config(['$routeProvider', function routeConfig($routeProvider) {
    $routeProvider
     .when('/', {
        controller: "AppareilController as ctrl",
        templateUrl: 'accueil.html'    
    })
     .when('/newacte', {
        controller: "ActeRadiologiqueNewController as ctrl",
        templateUrl: 'newacte.html'    
    })
     .when('/newappareil', {
        controller: "AppareilNewController as ctrl",
        templateUrl: 'newappareil.html'    
    })
    .otherwise({ redirectTo: '/'});
}]);
