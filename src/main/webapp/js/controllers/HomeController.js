(function () {
    'use strict';
 
    angular
        .module('magus')
        .controller('HomeController', HomeController);
 
    HomeController.$inject = ['$rootScope', '$location', 'AuthenticationService'];
    function HomeController($rootScope, $location, AuthenticationService) {
        var vm = this;
        vm.labels = ["Remaining Salary", "Expenses"];
        vm.data = [35000, 15000];
        vm.colours = ['#0e55df','#d6453b'];
        vm.colours = ['#8aace3', '#ec725e'];
        vm.$location = $location;
        vm.$rootScope = $rootScope;
        vm.AuthenticationService = AuthenticationService;
        vm.virtualRM = virtualRM;
        vm.salaryInfo = salaryInfo;
        vm.expenses = expenses;
        vm.userFirstName = AuthenticationService.GetUserFirstName();
        vm.username = AuthenticationService.GetUsername();
        vm.dataLoading = false;
        return vm;
        
        function salaryInfo() {
        	$rootScope.Ui.turnOn('salaryInfoModal');
        }
        
        function virtualRM() {
        	vm.$location.path("/virtualrm");
        };
        
        function expenses() {
        	vm.$location.path("/expenses");
        };
        
    }
 
})();