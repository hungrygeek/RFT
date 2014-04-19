function RFTChart (type, divId, titleId, chartData, dataId) {
  this.type = type;
  this.divId = divId;
  this.titleId = titleId;
  this.data = chartData;
  this.chart = new AmCharts.AmSerialChart();

  if (type === 'barchart') {
    this.initBarChart();
    this.update();

  } else if (type === 'linechart') {
    if (dataId !== undefined) {
      this.dataId = dataId;
    } else {
      this.dataId = 0;
    }
    this.initLineChart();
    this.update();

  } else {
    alert("Error! Unrecognised chart type.");
  }
}

RFTChart.prototype.type = '';
RFTChart.prototype.divId = '';
RFTChart.prototype.titleId = '';
RFTChart.prototype.data = {};
RFTChart.prototype.chart = new AmCharts.AmSerialChart();

RFTChart.prototype.initBarChart = function () {
  // Chart properties
  var chart = this.chart;
  chart.dataProvider = this.data;
  chart.categoryField = "name";
  chart.rotate = true; // true: bar chart; false: column chart.
  chart.depth3D = 20;  // 3D parameter
  chart.angle = 30;    // 3D parameter

  // Category axis
  var categoryAxis = chart.categoryAxis;
  categoryAxis.gridPosition = "start";
  categoryAxis.axisColor = "#DADADA";
  categoryAxis.fillAlpha = 1;
  categoryAxis.gridAlpha = 0;
  categoryAxis.fillColor = "#FAFAFA";

  // Value axis
  var valueAxis = new AmCharts.ValueAxis();
  valueAxis.axisColor = "#DADADA";
  valueAxis.title = "Electricity consumption, kWh";
  valueAxis.gridAlpha = 0.1;
  chart.addValueAxis(valueAxis);

  // Graph
  var graph = new AmCharts.AmGraph();
  graph.title = "kWh";
  graph.valueField = "kwh";
  graph.type = "column";
  graph.balloonText = "[[category]]:[[value]]";
  graph.lineAlpha = 0;
  graph.fillColors = "#bf1c25";
  graph.fillAlphas = 1;
  chart.addGraph(graph);

  chart.creditsPosition = "top-right";
};

RFTChart.prototype.initLineChart = function () {
  // Chart properties
  var chart = this.chart;
  chart.pathToImages = "amcharts/images/";
  chart.dataProvider = this.data[this.dataId].historyChart;
  chart.categoryField = "time";
  chart.balloon.bulletSize = 5;

  // Category axis
  var categoryAxis = chart.categoryAxis;
  categoryAxis.parseDates = true;
  categoryAxis.minPeriod = "hh"; // updated every 30 min
  categoryAxis.dashLength = 1;
  categoryAxis.minorGridEnabled = true;
  categoryAxis.twoLineMode = true;
  categoryAxis.axisColor = "#DADADA";

  // Value axis
  var valueAxis = new AmCharts.ValueAxis();
  valueAxis.axisAlpha = 0;
  valueAxis.dashLength = 1;
  valueAxis.title = "Average power, kW";
  chart.addValueAxis(valueAxis);

  // Graph
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
  chart.addGraph(graph);

  chart.creditsPosition = "top-right";
};

RFTChart.prototype.update = function (chartData) {
  if (chartData !== undefined) {
    this.data = chartData;
  }

  if (this.type === 'linechart') {
    if (++this.dataId >= this.data.length) {
      this.dataId = 0;
    }

    var currentData = this.data[this.dataId];
    this.title = currentData.room + ": " + currentData.name;
    this.setTitle();
  }

  this.chart.write(this.divId);
};

RFTChart.prototype.setTitle = function () {
  document.getElementById(this.titleId).innerHTML = this.title;
};
