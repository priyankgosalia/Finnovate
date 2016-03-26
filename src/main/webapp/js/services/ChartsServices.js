(function () {
    'use strict';
 
    angular
        .module('magus')
        .factory('ChartsServices', ChartsServices);
 
    ChartsServices.$inject = ['$rootScope'];
    function ChartsServices($rootScope) {
    	console.log("Loading ....");
    	google.charts.load("current", {packages:['corechart','table']});

    	var service = {};
        service.drawChart = drawChart;
        service.drawPie   = drawPie;
        service.drawTransactionChart = drawTransactionChart;
        service.resizePie = resizePie;
        service.resize    = resize;
        service.resizeTransactionChart   = resizeTransactionChart;
        return service;
        

    	var data = "";
    	var view = "";

    //google.charts.setOnLoadCallback(drawChart);
    function drawChart(json) {
    	console.log("DrawChart");
    	var i=0;
    	data = new google.visualization.DataTable();
    	
    	data.addColumn('string', 'Type');
    	data.addColumn('number', 'amount');
    	console.log("Json ..." + json);
		data.addRows(json.entry.length);
		var object;
    	for(object in json.entry){
    		data.setCell(i, 0, json.entry[i].key);
    		data.setCell(i, 1, json.entry[i].value);
    		i = i +1;
    	}
    	
    	view = new google.visualization.DataView(data);
    	view.setColumns([0, 1,
    	                 { calc: "stringify",
    	                   sourceColumn: 1,
    	                   type: "string",
    	                   role: "annotation" }]);
    	resize();
  }


    function drawPie(json) {
    	console.log("DrawPie");
    	var i=0;
    	data = new google.visualization.DataTable();
    	
    	data.addColumn('string', 'Type');
    	data.addColumn('number', 'amount');
    	console.log("Json ..." + json);
		data.addRows(json.entry.length);
		var object;
    	for(object in json.entry){
    		data.setCell(i, 0, json.entry[i].key);
    		data.setCell(i, 1, json.entry[i].value);
    		i = i +1;
    	}

    	resizePie();
  }

	function resizePie() {
		var chart = new google.visualization.PieChart(document.getElementById("columnchart_values"));
    	var	optionsPie = {
    	      		  title: "Expenses for past 10 days.",
    	      		  is3D: true,
    	      		};

		  chart.draw(data, optionsPie);
	}
    
	function resize() {
		var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
    	var options = {
  	    	  title: "Expenses for past 10 days, in (₹)",
  	    	  bar: {groupWidth: "95%"},
  	    	  legend: 'bottom'
  	    	};

		  chart.draw(view, options);
	}

	var tableData = "";

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
		var tableOptions = {
				alternatingRowStyle : true,
				};
		  table.draw(tableData, tableOptions);
	}    
	
	
    }

})();
	