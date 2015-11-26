

angular.module('monApp').factory('ActeRadiologique', ['$resource', function ($resource) {

        //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
        return $resource('/bureau/webresources/generic/acteradiologique/:acteRadiologiquePACS', {acteRadiologiquePACS: '@acteRadiologiquePACS'});

    }]);

angular.module('monApp').factory('Appareil', ['$resource', function ($resource) {

        //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
        return $resource('/bureau/webresources/generic/appareil/:appa', {appa: '@appareilId'});

    }]);

angular.module('monApp').factory('Crayons', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/crayons/:id', {id: '@id'});
    }]);

angular.module('monApp').factory('NomemclatureCCAM', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/nomemclatureCCAM/:no', {no: '@nomenclatureCCAMId'});
    }]);

angular.module('monApp').factory('ImageRadiologique', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/imageradiologique/:im', {im: '@imageRadiologiqueId'});
    }]);

angular.module('monApp').factory('CCAM', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/CCAM/:no', {no: '@idCCAM'});
    }]);

angular.module('monApp').factory('Admission', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/admission/:ad', {ad: '@admissionIEP'});
    }]);

