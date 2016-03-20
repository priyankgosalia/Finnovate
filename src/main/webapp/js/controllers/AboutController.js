(function () {
    'use strict';
 
    angular
        .module('magus')
        .controller('AboutController', AboutController);
 
    AboutController.$inject = ['$rootScope', '$location', 'AuthenticationService'];
    function AboutController($rootScope, $location, AuthenticationService) {
        var vm = this;
        vm.$location = $location;
        vm.goHome = goHome;
        vm.AuthenticationService = AuthenticationService;
        return vm;
        
        function goHome() {
            vm.dataLoading = true;
            vm.dataLoading = false;
            vm.$location.path('#/');
        };
    }
 
})();