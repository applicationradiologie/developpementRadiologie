var project = angular.module('monApp');

project.controller('ActeRadiologiqueController', [ 'ActeRadiologique',
    function (ActeRadiologique) {
        this.acte = ActeRadiologique.query();
    }
]);

project.controller('ActeRadiologiqueNewController', [ 'ActeRadiologique',
   function(ActeRadiologique) {
    this.acte = new ActeRadiologique();
    this.update = function() {
       this.acte.$save();
   };
}]);

project.controller('ActeRadiologiqueEditController', [ '$routeParams', 'ActeRadiologique',
function($routeParams, ActeRadiologique) {
    this.acte = ActeRadiologique.get({ipp: $routeParams.ipp}); 
    this.update = function() {
        // appel POST asynchrone au service web sur /crayons/{id} 
        this.acte.$save();
    };
}
]);

project.controller('AppareilController', [ 'Appareil',
    function (Appareil) {
        this.appa = Appareil.query();
    }
]);

project.controller('AppareilNewController', [ 'Appareil',
   function(Appareil) {
    this.appa = new Appareil();
    this.update = function() {
       this.appa.$save();
   };
}]);

project.controller('AppareilEditController', [ '$routeParams', 'Appareil',
function($routeParams, Appareil) {
    this.appa = Appareil.get({appa: $routeParams.appa}); 
    this.update = function() {
        // appel POST asynchrone au service web sur /crayons/{id} 
        this.appa.$save();
    };
}
]);