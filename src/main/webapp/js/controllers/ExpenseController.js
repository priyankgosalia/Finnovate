(function () {
    'use strict';
 
    angular
        .module('magus')
        .controller('ExpenseController', ExpenseController);
 
    ExpenseController.$inject = ['$rootScope', '$location', 'RetailService', '$timeout', 'ChartsServices'];
    function ExpenseController($rootScope, $location, RetailService, $timeout, ChartsServices) {
        var vm = this;
        vm.RetailService = RetailService;
        vm.ChartsServices = ChartsServices;
        vm.expenseTracks = expenseTracks;
        vm.transactionDetails = transactionDetails;
        vm.dataLoading = true;
        vm.checkAndResize = checkAndResize;
        vm.pieOrColumn = pieOrColumn;
        $(window).resize(vm.checkAndResize);
        return vm;

        function expenseTracks(day) {
        	$rootScope.graph = "ColumnChart";
        	$rootScope.pieOrColumn = "COLUMN";
        	console.log("Spent in last " + day + " days");
        	$timeout(function(){
        		vm.dataLoading = true;
        		vm.RetailService.spentOnPercentages(day, function(response) {
            		if (response.data.map) {
            			$rootScope.tranTypes = response.data;
                    	vm.ChartsServices.drawChart(response.data.map);
                    	vm.dataLoading = false;
                    	console.debug("Transtype " + response.data.transactionTypes);
            		} else {
            			$('#greeting').html('Oops! ' + response.data.message);
            		}
            	});
        		
        	},500);
        	
        };

        function pieOrColumn(day, type) {
        	$rootScope.graph = "ColumnChart";
        	console.log("Spent in last " + day + " days -- "+type);
        	$timeout(function(){
        		vm.dataLoading = true;
        		vm.RetailService.spentOnPercentages(day, function(response) {
            		if (response.data.map) {
            			$rootScope.tranTypes = response.data;
            			if(type == "COLUMN"){
            				console.log("drawing Bar chart");
            				vm.ChartsServices.drawChart(response.data.map);
            			}else if (type=="PIE"){
            				console.log("drawing Pie chart");
            				vm.ChartsServices.drawPie(response.data.map);
            			}
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
        		
        		return;
        	}
        	$rootScope.graph = "Table";
        	console.log("Spent on " +type+ " in last " + day + " days");
        	$timeout(function(){
        		vm.dataLoading = true;
        		vm.RetailService.transactionDetails(day,type, function(response) {
            		if (response.data.source) {
            			vm.ChartsServices.drawTransactionChart(response.data.source);
                    	vm.dataLoading = false;
            		} else {
            			$('#greeting').html('Oops! ' + response.data.message);
            		}
            	});
        		
        	},500);
        	
        };
	    function checkAndResize() {
			if ($rootScope.graph == "ColumnChart") {
	        	if($rootScope.pieOrColumn == "COLUMN"){
	        		vm.ChartsServices.resize();
	        	}else{
	        		vm.ChartsServices.resizePie();
	        	}
			} else {
				vm.ChartsServices.resizeTransactionChart();
			}
		};

    }

})();