(function () {
    'use strict';
 
    angular
        .module('magus')
        .controller('LogoutController', LogoutController);
 
    LogoutController.$inject = ['$rootScope', '$location', 'AuthenticationService'];
    function LogoutController($rootScope, $location, AuthenticationService) {
        var vm = this;
        vm.$location = $location;
        vm.logout = logout;
        vm.cancelLogout = cancelLogout;
        vm.AuthenticationService = AuthenticationService;
        return vm;
        
        function logout() {
            vm.dataLoading = true;
            vm.AuthenticationService.ClearCredentials();
            vm.dataLoading = false;
            vm.$location.path('#/');
        };
        
        function cancelLogout() {
            vm.dataLoading = true;
            vm.$location.path('#/');
            vm.dataLoading = false;
        };
    }
 
})();