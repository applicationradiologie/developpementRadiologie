

angular.module('monApp').factory('ActeRadiologique', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/bureau/webresources/generic/acteradiologique/:iep', { iep : '@iep'} );
    
}]);

angular.module('monApp').factory('Appareil', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/bureau/webresources/generic/appareil/:appa', { appa : '@appareilId'} );
    
}]);
