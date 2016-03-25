console.log("Loading ....");
google.charts.load("current", {packages:['corechart']});

var data = "";
var view = "";

var options = {
  title: "Expenses for past 10 days, in Rs.",
  /*width: 600,
  height: 400,*/
  bar: {groupWidth: "95%"},
  legend: { position: "none" },
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

	function resize() {
		var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
		  chart.draw(view, options);
	}
