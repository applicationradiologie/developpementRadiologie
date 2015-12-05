/* global angular */

//var project = angular.module('monApp');

angular.module('monApp').controller('ActeRadiologiqueController', ['ActeRadiologique',
    function (ActeRadiologique) {
        this.acte = ActeRadiologique.query();
        this.delete = function (ac) {
            // appel DELETE asynchrone au service web sur /crayons/{id}
            //cr.$delete();
            ActeRadiologique.delete(ac);
            // remet à jour le tableau des crayons en suprimant l'élément effacé
            //this.appareil.splice(this.appareil.indexOf(appa), 1);
        };
    }
]);

angular.module('monApp').controller('ActeRadiologiqueNewController', ['ActeRadiologique', 'CCAM', 'Appareil', 'Admission', '$location',
    function (ActeRadiologique, CCAM, Appareil, Admission, $location) {
        this.act = new ActeRadiologique();
        this.ccam = CCAM.query();
        this.appa = Appareil.query();
        this.admi = Admission.query();
        this.update = function () {
            //
            console.log(this.appa.appareilLibelle);
            //console.log(this.act.ccam.CCAMId);
            this.act.$save();
            $location.path("/rechercheracte");
        };
    }]);

angular.module('monApp').controller('ActeRadiologiqueEditController', ['$routeParams', 'ActeRadiologique','CCAM', 'Appareil', 'Admission', '$location',
    function ($routeParams, ActeRadiologique, CCAM, Appareil, Admission, $location) {
        this.acte = ActeRadiologique.get({id: $routeParams.ac});
        this.oldacte = ActeRadiologique.get({id: $routeParams.ac});
        this.ccam = CCAM.query();
        this.appa = Appareil.query();
        this.admi = Admission.query();
        console.log("routeparam:"+$routeParams.ac);
        this.update = function () {
            // appel POST asynchrone au service web sur /crayons/{id} 
            this.acte.$save();
            $location.path("/");
        };
    }]);

angular.module('monApp').controller('AppareilController', ['Appareil',
    function (Appareil) {
        console.log("ca passe");
        this.appa = Appareil.query();
        this.delete = function (ap) {
            // appel DELETE asynchrone au service web sur /crayons/{id}
            //cr.$delete();
            Appareil.delete(ap);
            // remet à jour le tableau des crayons en suprimant l'élément effacé
            this.appa.splice(this.appa.indexOf(ap), 1);
        };
    }
]);

angular.module('monApp').controller('AppareilNewController', ['Appareil', '$location',
    function (Appareil, $location) {
        this.appa = new Appareil();
        this.update = function () {
            this.appa.$save();
            $location.path("/listeappareil");
        };
    }]);

angular.module('monApp').controller('AppareilEditController', ['$routeParams', 'Appareil', '$location',
    function ($routeParams, Appareil, $location) {
        this.ap = Appareil.get({id: $routeParams.appa});

        console.log("routeparam:"+$routeParams.appa);
        this.update = function () {
            // appel POST asynchrone au service web sur /crayons/{id} 
            this.ap.$save();
            $location.path("/");
        };
    }]);

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
        this.update = function () {
            // appel POST asynchrone au service web sur /crayons/{id} 
            this.cr.$save();
            $location.path("/");
        };
    }
]);

angular.module('monApp').controller('CCAMController', ['CCAM',
    function (CCAM) {
        this.ccam = CCAM.query();
        this.delete = function (no) {
            // appel DELETE asynchrone au service web sur /crayons/{id}
            //cr.$delete();
            CCAM.delete(no);
            // remet à jour le tableau des crayons en suprimant l'élément effacé
            this.ccam.splice(this.ccam.indexOf(no), 1);
        };
    }
]);

angular.module('monApp').controller('CCAMNewController', ['CCAM', '$location',
    function (CCAM, $location) {
        this.ccam = new CCAM();
        this.update = function () {
            this.ccam.$save();
            $location.path("/");
        };
    }]);

angular.module('monApp').controller('CCAMEditController', ['$routeParams', 'CCAM', '$location',
    function ($routeParams, CCAM, $location) {
        this.ccam = CCAM.get({id: $routeParams.no});
        this.update = function () {
            // appel POST asynchrone au service web sur /crayons/{id} 
            this.ccam.$save();
            $location.path("/");
        };
    }]);

angular.module('monApp').controller('ImagesController', ['ImageRadiologique',
    function (ImageRadiologique) {
        this.imageradiologique = ImageRadiologique.query();
        this.delete = function (im) {
            // appel DELETE asynchrone au service web sur /crayons/{id}
            //cr.$delete();
            ImageRadiologique.delete(im);
            // remet à jour le tableau des crayons en suprimant l'élément effacé
            this.imageradiologique.splice(this.imageradiologique.indexOf(im), 1);
        };
    }
]);

angular.module('monApp').controller('ImageNewController', ['ImageRadiologique', '$location',
    function (ImageRadiologique, $location) {
        this.imageradiologique = new ImageRadiologique();
        this.update = function () {
            this.imageradiologique.$save();
            $location.path("/");
        };
    }]);

angular.module('monApp').controller('ImageEditController', ['$routeParams', 'ImageRadiologique', '$location',
    function ($routeParams, ImageRadiologique, $location) {
        this.im = ImageRadiologique.get({id: $routeParams.im});

        console.log("routeparam:"+$routeParams.im);
        this.update = function () {
            // appel POST asynchrone au service web sur /crayons/{id} 
            this.im.$save();
            $location.path("/");
        };
    }]);

angular.module('monApp').controller('AdmissionController', ['Admission',
    function (Admission) {
        this.admission = Admission.query();
        this.delete = function (ad) {
            //cr.$delete();
            Admission.delete(ad);
            // remet à jour le tableau des crayons en suprimant l'élément effacé
            this.admission.splice(this.admission.indexOf(ad), 1);
        };
    }
]);

angular.module('monApp').controller('AdmissionNewController', ['Admission', '$location',
    function (Admission, $location) {
        this.admission = new Admission();
        this.update = function () {
            this.admission.$save();
            $location.path("/");
        };
    }]);

angular.module('monApp').controller('AdmissionEditController', ['$routeParams', 'Admission', '$location',
    function ($routeParams, CCAM, $location) {
        this.admission = CCAM.get({id: $routeParams.iep});
        this.update = function () {
            // appel POST asynchrone au service web sur /crayons/{id} 
            this.admission.$save();
            $location.path("/");
        };
    }]);