(function () {
    'use strict';
 
    angular
        .module('magus')
        .controller('ExpenseController', ExpenseController);
 
    ExpenseController.$inject = ['$rootScope', '$location', 'RetailService', '$timeout'];
    function ExpenseController($rootScope, $location, RetailService, $timeout) {
        var vm = this;
        vm.RetailService = RetailService;
        vm.expenseTracks = expenseTracks;
        vm.dataLoading = true;
        vm.onresize = resize;
        $(window).resize(resize);
        return vm;

        function expenseTracks(day) {
        	
        	console.log("Spent in last " + day + " days");
        	$timeout(function(){
        		vm.dataLoading = true;
        		vm.RetailService.spentOnPercentages(day, function(response) {
            		//console.log(response.data);
            		if (response.data.map) {
            			console.log("Response ... " + response.data.map);
            			//$('#greeting2').html(response.data.total);
            			//$('#greeting3').html(response.data.transactionTypes);
                    	drawChart(response.data.map);
                    	vm.dataLoading = false;
            		} else {
            			$('#greeting').html('Oops! ' + response.data.message);
            		}
            	});
        		
        	},500);
        	
        	
        };

    }

})();