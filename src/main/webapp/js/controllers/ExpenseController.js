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
        vm.transactionDetails = transactionDetails;
        vm.dataLoading = true;
        vm.checkAndResize = checkAndResize;
        //vm.onresize = ($rootScope.graph == "ColumnChart" ) ? resize : resizeTransactionChart;
        $(window).resize(vm.checkAndResize);
        return vm;

        function expenseTracks(day) {
        	$rootScope.graph = "ColumnChart";
        	console.log("Spent in last " + day + " days");
        	$timeout(function(){
        		vm.dataLoading = true;
        		vm.RetailService.spentOnPercentages(day, function(response) {
            		if (response.data.map) {
            			$rootScope.tranTypes = response.data;
                    	drawChart(response.data.map);
                    	vm.dataLoading = false;
                    	console.debug("Transtype " + response.data.transactionTypes);
            		} else {
            			$('#greeting').html('Oops! ' + response.data.message);
            		}
            	});
        		
        	},500);
        	
        };

        function transactionDetails(day, type) {
        	if(type==null){
        		expenseTracks(day);
        		
        		return;
        	}
        	$rootScope.graph = "Table";
        	console.log("Spent on " +type+ " in last " + day + " days");
        	$timeout(function(){
        		vm.dataLoading = true;
        		vm.RetailService.transactionDetails(day,type, function(response) {
            		if (response.data.source) {
            			drawTransactionChart(response.data.source);
                    	vm.dataLoading = false;
            		} else {
            			$('#greeting').html('Oops! ' + response.data.message);
            		}
            	});
        		
        	},500);
        	
        };
	    function checkAndResize() {
			if ($rootScope.graph == "ColumnChart") {
				resize()
			} else {
				resizeTransactionChart();
			}
		};

    }

})();