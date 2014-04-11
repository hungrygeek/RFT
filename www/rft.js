var barChart;

var barChartData = [
  {
    "year": 2005,
    "income": 23.5
  },
  {
    "year": 2006,
    "income": 26.2
  },
  {
    "year": 2007,
    "income": 30.1
  },
  {
    "year": 2008,
    "income": 29.5
  },
  {
    "year": 2009,
    "income": 24.6
  },
  {
    "year": 2005,
    "income": 23.5
  },
  {
    "year": 2006,
    "income": 26.2
  },
  {
    "year": 2007,
    "income": 30.1
  },
  {
    "year": 2008,
    "income": 29.5
  },
  {
    "year": 2009,
    "income": 24.6
  },
  {
    "year": 2005,
    "income": 23.5
  },
  {
    "year": 2006,
    "income": 26.2
  },
  {
    "year": 2007,
    "income": 30.1
  },
  {
    "year": 2008,
    "income": 29.5
  },
  {
    "year": 2009,
    "income": 24.6
  },
  {
    "year": 2005,
    "income": 23.5
  },
  {
    "year": 2006,
    "income": 26.2
  },
  {
    "year": 2007,
    "income": 30.1
  },
  {
    "year": 2008,
    "income": 29.5
  },
  {
    "year": 2009,
    "income": 24.6
  }
];


AmCharts.ready(function () {
  // SERIAL CHART
  barChart = new AmCharts.AmSerialChart();
  barChart.dataProvider = barChartData;
  barChart.categoryField = "year";
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
  valueAxis.title = "Income in millions, USD";
  valueAxis.gridAlpha = 0.1;
  barChart.addValueAxis(valueAxis);

  // GRAPH
  var graph = new AmCharts.AmGraph();
  graph.title = "Income";
  graph.valueField = "income";
  graph.type = "column";
  graph.balloonText = "Income in [[category]]:[[value]]";
  graph.lineAlpha = 0;
  graph.fillColors = "#bf1c25";
  graph.fillAlphas = 1;
  barChart.addGraph(graph);

  barChart.creditsPosition = "top-left";

  // WRITE
  barChart.write("barchart");
});
