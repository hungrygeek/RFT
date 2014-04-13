var barChart;

var request = new XMLHttpRequest();
request.open('GET', 'sample_data.json', false);
request.send();

var chartData = JSON.parse(request.responseText);
console.log(chartData);
var barChartData = chartData.rankingChart;

AmCharts.ready(function () {
  // SERIAL CHART
  barChart = new AmCharts.AmSerialChart();
  barChart.dataProvider = barChartData;
  barChart.categoryField = "name";
  // this single line makes the chart a bar chart,
  // try to set it to false - your bars will turn to columns
  barChart.rotate = true;
  // the following two lines makes chart 3D
  barChart.depth3D = 20;
  barChart.angle = 30;

  // AXES
  // Category
  var categoryAxis = barChart.categoryAxis;
  categoryAxis.gridPosition = "start";
  categoryAxis.axisColor = "#DADADA";
  categoryAxis.fillAlpha = 1;
  categoryAxis.gridAlpha = 0;
  categoryAxis.fillColor = "#FAFAFA";

  // value
  var valueAxis = new AmCharts.ValueAxis();
  valueAxis.axisColor = "#DADADA";
  valueAxis.title = "Electricity consumption, kWh";
  valueAxis.gridAlpha = 0.1;
  barChart.addValueAxis(valueAxis);

  // GRAPH
  var graph = new AmCharts.AmGraph();
  graph.title = "kWh";
  graph.valueField = "kwh";
  graph.type = "column";
  graph.balloonText = "[[category]]:[[value]]";
  graph.lineAlpha = 0;
  graph.fillColors = "#bf1c25";
  graph.fillAlphas = 1;
  barChart.addGraph(graph);

  barChart.creditsPosition = "bottom-right";

  // WRITE
  barChart.write("barchart");
});
