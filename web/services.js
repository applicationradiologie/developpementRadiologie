

/* global angular */

angular.module('monApp').factory('ActeRadiologique', ['$resource', function ($resource) {

        //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
        return $resource('/bureau/webresources/generic/acteradiologique/:acteRadiologiquePACS', {acteRadiologiquePACS: '@acteRadiologiquePACS'});

    }]);

angular.module('monApp').factory('Appareil', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/appareil/:id', {id: '@id'},{
            'get': {method: 'GET', isArray: false},
            'save': {method: 'POST'},
            'query': {method: 'GET', isArray: true},
            'remove': {method: 'DELETE'},
            'delete': {method: 'DELETE'}});
    }]);

angular.module('monApp').factory('Crayons', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/crayons/:id', {id: '@id'},{
            'get': {method: 'GET', isArray: false},
            'save': {method: 'POST'},
            'query': {method: 'GET', isArray: true},
            'remove': {method: 'DELETE'},
            'delete': {method: 'DELETE'}});
    }]);

angular.module('monApp').factory('NomemclatureCCAM', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/nomemclatureCCAM/:no', {no: '@nomenclatureCCAMId'},{
            'get': {method: 'GET', isArray: false},
            'save': {method: 'POST'},
            'query': {method: 'GET', isArray: true},
            'remove': {method: 'DELETE'},
            'delete': {method: 'DELETE'}});
    }]);

angular.module('monApp').factory('ImageRadiologique', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/imageradiologique/:im', {im: '@imageRadiologiqueId'},{
            'get': {method: 'GET', isArray: false},
            'save': {method: 'POST'},
            'query': {method: 'GET', isArray: true},
            'remove': {method: 'DELETE'},
            'delete': {method: 'DELETE'}});
    }]);

angular.module('monApp').factory('CCAM', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/CCAM/:no', {no: '@idCCAM'},{
            'get': {method: 'GET', isArray: false},
            'save': {method: 'POST'},
            'query': {method: 'GET', isArray: true},
            'remove': {method: 'DELETE'},
            'delete': {method: 'DELETE'}});
    }]);

angular.module('monApp').factory('Admission', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/admission/:iep', {iep: '@admissionIEP'},{
            'get': {method: 'GET', isArray: false},
            'save': {method: 'POST'},
            'query': {method: 'GET', isArray: true},
            'remove': {method: 'DELETE'},
            'delete': {method: 'DELETE'}});
    }]);

