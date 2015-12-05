

/* global angular */

angular.module('monApp').factory('ActeRadiologique', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/acteradiologique/:id', {id: '@id'},{
            'get': {method: 'GET', isArray: false},
            'save': {method: 'POST'},
            'query': {method: 'GET', isArray: true},
            'remove': {method: 'DELETE'},
            'delete': {method: 'DELETE'}});
    }]);

angular.module('monApp').factory('Appareil', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/appareil/:id', {id: '@id'});
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
        return $resource('/bureau/webresources/generic/nomemclatureCCAM/:id', {id: '@id'},{
            'get': {method: 'GET', isArray: false},
            'save': {method: 'POST'},
            'query': {method: 'GET', isArray: true},
            'remove': {method: 'DELETE'},
            'delete': {method: 'DELETE'}});
    }]);

angular.module('monApp').factory('ImageRadiologique', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/imageradiologique/:id', {id: '@id'},{
            'get': {method: 'GET', isArray: false},
            'save': {method: 'POST'},
            'query': {method: 'GET', isArray: true},
            'remove': {method: 'DELETE'},
            'delete': {method: 'DELETE'}});
    }]);

angular.module('monApp').factory('CCAM', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/CCAM/:id', {id: '@id'},{
            'get': {method: 'GET', isArray: false},
            'save': {method: 'POST'},
            'query': {method: 'GET', isArray: true},
            'remove': {method: 'DELETE'},
            'delete': {method: 'DELETE'}});
    }]);

angular.module('monApp').factory('Admission', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/admission/:id', {id: '@id'},{
            'get': {method: 'GET', isArray: false},
            'save': {method: 'POST'},
            'query': {method: 'GET', isArray: true},
            'remove': {method: 'DELETE'},
            'delete': {method: 'DELETE'}});
    }]);

