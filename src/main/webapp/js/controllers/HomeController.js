(function () {
    'use strict';
 
    angular
        .module('magus')
        .controller('HomeController', HomeController);
 
    HomeController.$inject = ['$rootScope', '$location', 'AuthenticationService'];
    function HomeController($rootScope, $location, AuthenticationService) {
        var vm = this;
        vm.$location = $location;
        vm.$rootScope = $rootScope;
        vm.AuthenticationService = AuthenticationService;
        vm.virtualRM = virtualRM;
        vm.expenses = expenses;
        vm.userFirstName = AuthenticationService.GetUserFirstName();
        vm.username = AuthenticationService.GetUsername();
        vm.dataLoading = false;
        return vm;
        
        function virtualRM() {
        	vm.$location.path("/virtualrm");
        };
        
        function expenses() {
        	vm.$location.path("/expenses");
        };
        
    }
 
})();