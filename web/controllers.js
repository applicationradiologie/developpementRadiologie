//var project = angular.module('monApp');

angular.module('monApp').controller('ActeRadiologiqueController', ['ActeRadiologique',
    function (ActeRadiologique) {
        this.acte = ActeRadiologique.query();
    }
]);

angular.module('monApp').controller('ActeRadiologiqueNewController', ['ActeRadiologique',
    function (ActeRadiologique) {
        this.acte = new ActeRadiologique();
        this.update = function () {
            this.acte.$save();
        };
    }]);

angular.module('monApp').controller('ActeRadiologiqueEditController', ['$routeParams', 'ActeRadiologique',
    function ($routeParams, ActeRadiologique) {
        this.acte = ActeRadiologique.get({ipp: $routeParams.ipp});
        this.update = function () {
            // appel POST asynchrone au service web sur /crayons/{id} 
            this.acte.$save();
        };
    }
]);

angular.module('monApp').controller('AppareilController', ['Appareil',
    function (Appareil) {
        console.log("ca passe");
        this.appareil = Appareil.query();
    }
]);

angular.module('monApp').controller('AppareilNewController', ['Appareil',
    function (Appareil) {
        this.appa = new Appareil();
        this.update = function () {
            this.appa.$save();
        };
    }]);

angular.module('monApp').controller('AppareilEditController', ['$routeParams', 'Appareil',
    function ($routeParams, Appareil) {
        this.appa = Appareil.get({appa: $routeParams.appa});
        this.update = function () {
            // appel POST asynchrone au service web sur /crayons/{id} 
            this.appa.$save();
        };
    }
]);

angular.module('monApp').controller('CrayonsController', ['Crayons',
    function (Crayons) {
        this.crayons = Crayons.query();
        this.delete = function (cr) {
            // appel DELETE asynchrone au service web sur /crayons/{id}
            //cr.$delete();
            Crayons.delete(cr);
            // remet à jour le tableau des crayons en suprimant l'élément effacé
            this.crayons.splice(this.crayons.indexOf(cr), 1);
        };
    }
]);

angular.module('monApp').controller('CrayonNewController', ['Crayons',
    function (Crayons) {
        this.cr = new Crayons();
        this.update = function () {
            // appel POST asynchrone au service web sur /crayons
            this.cr.$save();
        };
    }]);

angular.module('monApp').controller('CrayonEditController', ['$routeParams', 'Crayons', '$location',
    function ($routeParams, Crayons, $location) {
        this.cr = Crayons.get({id: $routeParams.id});
        this.cr.$save();
        $location.path("/");
    }]);