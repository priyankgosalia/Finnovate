(function () {
    'use strict';
 
    angular
        .module('magus')
        .controller('ExpenseController', ExpenseController);
 
    ExpenseController.$inject = ['$rootScope', '$location', 'AuthenticationService', 'RetailService'];
    function ExpenseController($rootScope, $location, AuthenticationService, RetailService) {
        var vm = this;
        vm.AuthenticationService = AuthenticationService;
        vm.userFirstName = AuthenticationService.GetUserFirstName();
        vm.username = AuthenticationService.GetUsername();
        vm.RetailService = RetailService;
        vm.expenseTracks = expenseTracks;
        vm.dataLoading = true;

        function expenseTracks(day) {
        	var map = "";
        	vm.dataLoading = true;
        	console.log("Spent in last " + day + " days");
        	vm.RetailService.spentOnPercentages(day, function(response) {
        		console.log(response.data);
        		if (response.data.map) {
        			map = response.data.map;
        			//$('#greeting2').html(response.data.total);
        			//$('#greeting3').html(response.data.transactionTypes);
                	drawChart(map);
        		} else {
        			$('#greeting').html('Oops! ' + response.data.message);
        		}
        	});
        	vm.dataLoading = false;
        };

    }

})();