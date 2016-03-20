(function () {
    'use strict';
 
    angular
        .module('magus')
        .controller('VirtualRMController', VirtualRMController);
 
    VirtualRMController.$inject = ['$rootScope', '$location', 'AuthenticationService'];
    function VirtualRMController($rootScope, $location, AuthenticationService) {
        var vm = this;
        vm.$location = $location;
        vm.$rootScope = $rootScope;
        vm.AuthenticationService = AuthenticationService;
        vm.goBack = goBack;
        vm.userFirstName = AuthenticationService.GetUserFirstName();
        vm.username = AuthenticationService.GetUsername();
        vm.dataLoading = false;
        return vm;
        
        function goBack() {
        	vm.$location.path("/home");
        };
        
    }
 
})();