(function () {
    'use strict';
 
    angular
        .module('magus')
        .controller('LoginController', LoginController);
 
    LoginController.$inject = ['$location', 'AuthenticationService'];
    function LoginController($location, AuthenticationService) {
        var vm = this;
        vm.login = login;
 
        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();
 
        function login() {
            vm.dataLoading = true;
            vm.loginFailure = false;
            console.log("Authenticating with: User="+vm.username+", Password="+vm.password);
            AuthenticationService.Login(vm.username, vm.password, function (response) {
                if (response.result) {
                    AuthenticationService.SetCredentials(vm.username, vm.password);
                    AuthenticationService.SetUsername(vm.username);
                    AuthenticationService.SetUserFirstName(response.userFirstName);
                    AuthenticationService.SetUserId(response.userId);
                    AuthenticationService.SetAdmin(response.admin);
                    vm.loginFailure = false;
                    $location.path('/');
                } else {
                    vm.dataLoading = false;
                    vm.loginFailure = true;
                    vm.failureMessage = response.message;
                }
            });
        };
    }
 
})();