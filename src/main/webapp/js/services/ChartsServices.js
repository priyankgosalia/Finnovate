(function () {
    'use strict';
 
    angular
        .module('magus')
        .factory('ChartsServices', ChartsServices);
 
    ChartsServices.$inject = ['$rootScope'];
    function ChartsServices($rootScope) {
    	console.log("Loading ....");
    	google.charts.load("current", {packages:['corechart','table']});

    	$rootScope.data = "";
    	$rootScope.view = "";

    	$rootScope.options = {
    	  title: "Expenses for past 10 days, in Rs.",
    	  bar: {groupWidth: "95%"},
    	  legend: 'bottom'
    	};

    	$rootScope.optionsPie = {
      		  title: "Expenses for past 10 days, in Rs.",
      		  is3D: true,
      		};
    	
    	var service = {};
        service.drawChart = drawChart;
        service.drawPie   = drawPie;
        service.drawTransactionChart = drawTransactionChart;
        service.resizePie = resizePie;
        service.resize    = resize;
        service.resizeTransactionChart   = resizeTransactionChart;
        return service;
        


    //google.charts.setOnLoadCallback(drawChart);
    function drawChart(json) {
    	console.log("DrawChart");
    	var i=0;
    	$rootScope.data = new google.visualization.DataTable();
    	
    	$rootScope.data.addColumn('string', 'Type');
    	$rootScope.data.addColumn('number', 'amount');
    	console.log("Json ..." + json);
		$rootScope.data.addRows(json.entry.length);
		var object;
    	for(object in json.entry){
    		$rootScope.data.setCell(i, 0, json.entry[i].key);
    		$rootScope.data.setCell(i, 1, json.entry[i].value);
    		i = i +1;
    	}
    	
    	$rootScope.view = new google.visualization.DataView($rootScope.data);
    	$rootScope.view.setColumns([0, 1,
    	                 { calc: "stringify",
    	                   sourceColumn: 1,
    	                   type: "string",
    	                   role: "annotation" }]);
    	resize();
  }


    function drawPie(json) {
    	console.log("DrawPie");
    	var i=0;
    	$rootScope.data = new google.visualization.DataTable();
    	
    	$rootScope.data.addColumn('string', 'Type');
    	$rootScope.data.addColumn('number', 'amount');
    	console.log("Json ..." + json);
		$rootScope.data.addRows(json.entry.length);
		var object;
    	for(object in json.entry){
    		$rootScope.data.setCell(i, 0, json.entry[i].key);
    		$rootScope.data.setCell(i, 1, json.entry[i].value);
    		i = i +1;
    	}

    	resizePie();
  }

	function resizePie() {
		var chart = new google.visualization.PieChart(document.getElementById("columnchart_values"));
		  chart.draw($rootScope.data, $rootScope.optionsPie);
	}
    
	function resize() {
		var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
		  chart.draw($rootScope.view, $rootScope.options);
	}

	var tableData = "";
	var tableOptions = {
			  title: "Expenses for past 10 days, in Rs.",
			  legend: 'bottom'
			};

    function drawTransactionChart(json) {
    	console.log("drawTransactionChart");
    	var i=0;
    	tableData = new google.visualization.DataTable();
    	
    	tableData.addColumn('string', 'Date');
    	tableData.addColumn('number', 'amount');
    	console.log("Json ..." + json[0].transactiondate);
    	tableData.addRows(json.length);
		var object;
    	for(object in json){
    		tableData.setCell(i, 0, json[i].transactiondate);
    		tableData.setCell(i, 1, json[i].amount);
    		i = i +1;
    	}
    	
    	resizeTransactionChart();
  }
    
	function resizeTransactionChart() {
		var table = new google.visualization.Table(document.getElementById("columnchart_transaction"));
		  table.draw(tableData, tableOptions);
	}    
	
	
    }

})();
	