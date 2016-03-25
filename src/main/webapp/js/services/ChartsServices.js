console.log("Loading ....");
google.charts.load("current", {packages:['corechart','table']});

var data = "";
var view = "";

var options = {
  title: "Expenses for past 10 days, in Rs.",
  bar: {groupWidth: "95%"},
  legend: 'bottom'
};

    //google.charts.setOnLoadCallback(drawChart);
    function drawChart(json) {
    	console.log("DrawChart");
    	var i=0;
    	data = new google.visualization.DataTable();
    	
    	data.addColumn('string', 'Type');
    	data.addColumn('number', 'amount');
    	console.log("Json ..." + json);
		data.addRows(json.entry.length);
    	for(object in json.entry){
    		data.setCell(i, 0, json.entry[i].key);
    		data.setCell(i, 1, json.entry[i].value);
    		i = i +1;
    	}
    	
    	//var data = google.visualization.arrayToDataTable(arr);
      /*{"map":{"entry":[{"key":"DTH","value":1285.0},{"key":"CARINS","value":2200.0},{"key":"RES","value":12200.0},{"key":"PMR","value":2000.0},{"key":"MOVIE","value":285.0},{"key":"FUEL","value":5000.0},{"key":"Electricity","value":328.23},{"key":"ATM","value":1000.0}]},"total":24298.23,"transactionTypes":["DTH","CARINS","RES","PMR","MOVIE","FUEL","Electricity","ATM"]}*/

    	view = new google.visualization.DataView(data);
    	view.setColumns([0, 1,
    	                 { calc: "stringify",
    	                   sourceColumn: 1,
    	                   type: "string",
    	                   role: "annotation" }]);
    	resize();
  }

    var optionsPie = {
    		  title: "Expenses for past 10 days, in Rs.",
    		  is3D: true,
    		};

    function drawPie(json) {
    	console.log("DrawPie");
    	var i=0;
    	data = new google.visualization.DataTable();
    	
    	data.addColumn('string', 'Type');
    	data.addColumn('number', 'amount');
    	console.log("Json ..." + json);
		data.addRows(json.entry.length);
    	for(object in json.entry){
    		data.setCell(i, 0, json.entry[i].key);
    		data.setCell(i, 1, json.entry[i].value);
    		i = i +1;
    	}
    	
    	//var data = google.visualization.arrayToDataTable(arr);
      /*{"map":{"entry":[{"key":"DTH","value":1285.0},{"key":"CARINS","value":2200.0},{"key":"RES","value":12200.0},{"key":"PMR","value":2000.0},{"key":"MOVIE","value":285.0},{"key":"FUEL","value":5000.0},{"key":"Electricity","value":328.23},{"key":"ATM","value":1000.0}]},"total":24298.23,"transactionTypes":["DTH","CARINS","RES","PMR","MOVIE","FUEL","Electricity","ATM"]}*/

    	resizePie();
  }

	function resizePie() {
		var chart = new google.visualization.PieChart(document.getElementById("columnchart_values"));
		  chart.draw(data, optionsPie);
	}
    
	function resize() {
		var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
		  chart.draw(view, options);
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
    	for(object in json){
    		tableData.setCell(i, 0, json[i].transactiondate);
    		tableData.setCell(i, 1, json[i].amount);
    		i = i +1;
    	}
    	
    	resizeTransactionChart();
  }
    
	function resizeTransactionChart() {
		var table = new google.visualization.Table(document.getElementById("columnchart_values"));
		  table.draw(tableData, tableOptions);
	}    