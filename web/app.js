/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('monApp', ['ngRoute', 'ngResource']);

angular.module('monApp').config(['$routeProvider', function routeConfig($routeProvider) {
        $routeProvider
                .when('/', {
                    controller: "AppareilController as ctrl",
                    templateUrl: 'accueil.html'
                })
                .when('/listeCrayon', {
                    controller: "CrayonsController as ctrl",
                    templateUrl: 'listeCrayon.html'
                })
                .when('/crayonedit/:id', {
                    controller: "CrayonEditController as ctrl",
                    templateUrl: 'editCrayon.html'
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
                    templateUrl: 'rechercheracte.html'
                })
                .when('/cr', {
                    controller: "CrayonsController as ctrl",
                    templateUrl: 'listeCrayon.html'
                })
                .when('/listeNomenc', {
                    controller: "CCAMController as ctrl",
                    templateUrl: 'listeNomemclatureCCAM.html'
                })
                .when('/newNomenc', {
                    controller: "CCAMNewController as ctrl",
                    templateUrl: 'newNomemclatureCCAM.html'
                })
                .when('/images', {
                    controller: "ImagesController as ctrl",
                    templateUrl: 'listeimages.html'
                })
                .when('/newImage', {
                    controller: "ImageNewController as ctrl",
                    templateUrl: 'newimage.html'
                })
                .when('/rechercheradmission', {
                    controller: "AdmissionController as ctrl",
                    templateUrl: 'listeAdmission.html'
                })
                .when('/newAdmission', {
                    controller: "AdmissionNewController as ctrl",
                    templateUrl: 'newAdmission.html'
                })
                .when('/appareilEdition/:appa', {
                    controller: "AppareilEditController as ctrl",
                    templateUrl: 'editAppareil.html'
                })
                .when('/nomencEdition/:no', {
                    controller: "CCAMEditController as ctrl",
                    templateUrl: 'editCCAM.html'
                })
                .when('/admissionEdition/:iep', {
                    controller: "AdmissionEditController as ctrl",
                    templateUrl: 'editAdmission.html'
                })
                .when('/imageEdition/:im', {
                    controller: "ImageEditController as ctrl",
                    templateUrl: 'editImage.html'
                })
                .when('/acteEdition/:ac', {
                    controller: "ActeRadiologiqueEditController as ctrl",
                    templateUrl: 'editActe.html'
                })
                .when('/ajoutImageActe/:ac', {
                    controller: "AjoutImageActeController as ctrl",
                    templateUrl: 'ajoutImageActe.html'
                })
                .when('/admissionActe/:iep', {
                    controller: "admissionActeController as ctrl",
                    templateUrl: 'admissionActe.html'
                })
                .otherwise({redirectTo: '/'});
    }]);
