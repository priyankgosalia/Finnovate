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
        vm.logout = logout;
        vm.userFirstName = AuthenticationService.GetUserFirstName();
        vm.username = AuthenticationService.GetUsername();
        vm.dataLoading = false;
        return vm;
        
        function logout() {
			AuthenticationService.ClearCredentials();
			$location.path('/#/login');
		};
    }
 
})();