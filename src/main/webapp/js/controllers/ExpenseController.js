(function () {
    'use strict';
 
    angular
        .module('magus')
        .controller('ExpenseController', ExpenseController);
 
    ExpenseController.$inject = ['$rootScope', '$location', 'AuthenticationService', 'RetailService', '$timeout'];
    function ExpenseController($rootScope, $location, AuthenticationService, RetailService, $timeout) {
        var vm = this;
        vm.AuthenticationService = AuthenticationService;
        vm.userFirstName = AuthenticationService.GetUserFirstName();
        vm.username = AuthenticationService.GetUsername();
        vm.RetailService = RetailService;
        vm.expenseTracks = expenseTracks;
        vm.dataLoading = false;
        vm.onresize = resize;
        $(window).resize(resize);
        function expenseTracks(day) {
        	vm.dataLoading = true;
        	console.log("Spent in last " + day + " days");
        	$timeout(function(){
        		vm.RetailService.spentOnPercentages(day, function(response) {
            		//console.log(response.data);
            		if (response.data.map) {
            			console.log("Response ... " + response.data.map);
            			//$('#greeting2').html(response.data.total);
            			//$('#greeting3').html(response.data.transactionTypes);
                    	drawChart(response.data.map);
            		} else {
            			$('#greeting').html('Oops! ' + response.data.message);
            		}
            	});
        	},200);
        	
        	vm.dataLoading = false;
        };

    }

})();