var jsonRequest = new XMLHttpRequest();
jsonRequest.open('GET', 'sample_data.json', false);
jsonRequest.send();

var chartData = JSON.parse(jsonRequest.responseText);
// FIXME
console.log(chartData);

var barChart;
var lineChart1, lineChart2;

AmCharts.ready(function () {
  barChart = new AmCharts.AmSerialChart();
  initBarChart(barChart, chartData.rankingChart);
  lineChart1 = new AmCharts.AmSerialChart();
  initLineChart(lineChart1, chartData.historyCharts[0].historyChart);
  lineChart2 = new AmCharts.AmSerialChart();
  initLineChart(lineChart2, chartData.historyCharts[1].historyChart);

  // WRITE
  barChart.write("barchart");
  lineChart1.write("linechart1");
  setLineChartTitle(1, 0);
  lineChart2.write("linechart2");
  setLineChartTitle(2, 1);
});

function initBarChart(chartObj, dataObj) {
  chartObj.dataProvider = dataObj;
  chartObj.categoryField = "name";
  chartObj.rotate = true; // false: column chart
  chartObj.depth3D = 20;  // 3D parameter
  chartObj.angle = 30;    // 3D parameter

  // AXES
  // Category
  var categoryAxis = chartObj.categoryAxis;
  categoryAxis.gridPosition = "start";
  categoryAxis.axisColor = "#DADADA";
  categoryAxis.fillAlpha = 1;
  categoryAxis.gridAlpha = 0;
  categoryAxis.fillColor = "#FAFAFA";

  // Value
  var valueAxis = new AmCharts.ValueAxis();
  valueAxis.axisColor = "#DADADA";
  valueAxis.title = "Electricity consumption, kWh";
  valueAxis.gridAlpha = 0.1;
  chartObj.addValueAxis(valueAxis);

  // GRAPH
  var graph = new AmCharts.AmGraph();
  graph.title = "kWh";
  graph.valueField = "kwh";
  graph.type = "column";
  graph.balloonText = "[[category]]:[[value]]";
  graph.lineAlpha = 0;
  graph.fillColors = "#bf1c25";
  graph.fillAlphas = 1;
  chartObj.addGraph(graph);

  chartObj.creditsPosition = "bottom-right";
}

function initLineChart(chartObj, dataObj) {
  chartObj.pathToImages = "amcharts/images/";
  chartObj.dataProvider = dataObj;
  chartObj.categoryField = "time";
  chartObj.balloon.bulletSize = 5;

  // AXES
  // Category
  var categoryAxis = chartObj.categoryAxis;
  categoryAxis.parseDates = true;
  categoryAxis.minPeriod = "hh"; // updated every 30 min
  categoryAxis.dashLength = 1;
  categoryAxis.minorGridEnabled = true;
  categoryAxis.twoLineMode = true;
  categoryAxis.axisColor = "#DADADA";

  // Value
  var valueAxis = new AmCharts.ValueAxis();
  valueAxis.axisAlpha = 0;
  valueAxis.dashLength = 1;
  valueAxis.title = "Average power, kW";
  chartObj.addValueAxis(valueAxis);

  // GRAPH
  var graph = new AmCharts.AmGraph();
  graph.title = "kW";
  graph.valueField = "kw";
  graph.bullet = "round";
  graph.bulletBorderColor = "#FFFFFF";
  graph.bulletBorderThickness = 2;
  graph.bulletBorderAlpha = 1;
  graph.lineThickness = 2;
  graph.lineColor = "#5fb503";
  graph.negativeLineColor = "#efcc26";
  graph.hideBulletsCount = 50;
  chartObj.addGraph(graph);

  chartObj.creditsPosition = "top-right";
}

function setLineChartTitle(chartId, roomId) {
  elementId = "linetitle" + chartId.toString();

  roomNum = chartData.historyCharts[roomId].room;
  studentName = chartData.historyCharts[roomId].name;
  titleStr = roomNum + ": " + studentName;

  document.getElementById(elementId).innerHTML = titleStr;
}
