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
    .when('/listeappareil', {
        controller: "AppareilController as ctrl",
        templateUrl: 'listeAppareil.html'    
    })
    .when('/rechercheracte', {
        controller: "ActeRadiologiqueController as ctrl",
        templateUrl: 'rechercheActe.html'    
    })
     .when('/cr', {
        controller: "CrayonsController as ctrl",
        templateUrl: 'listeCrayon.html'    
    })
     .when('/listeNomenc', {
        controller: "NomemclatureCCAMController as ctrl",
        templateUrl: 'listeNomemclatureCCAM.html'    
    })
     .when('/newNomenc', {
        controller: "NomemclatureCCAMNewController as ctrl",
        templateUrl: 'newNomemclatureCCAM.html'    
    })
    .otherwise({ redirectTo: '/'});
}]);
