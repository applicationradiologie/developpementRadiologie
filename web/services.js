

angular.module('monApp').factory('ActeRadiologique', ['$resource', function ($resource) {

        //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
        return $resource('/bureau/webresources/generic/acteradiologique/:acteRadiologiquePACS', {acteRadiologiquePACS: '@acteRadiologiquePACS'});

    }]);

angular.module('monApp').factory('Appareil', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/bureau/webresources/generic/appareils/:appa', { appa : '@appareilId'} );
    
}]);

angular.module('monApp').factory('Crayons', ['$resource', function ($resource) {
        return $resource('/bureau/webresources/generic/crayons/:id', {id: '@id'});
    }]);

