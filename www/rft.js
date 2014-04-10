var chart;

var chartData = [{
  room: "E1",
  kWh: 6.0
}, {
  room: "E2",
  kWh: 5.0
}, {
  room: "E3",
  kWh: 4.0
}, {
  room: "E4",
  kWh: 3.0
}, {
  room: "E5",
  kWh: 2.0
}, {
  room: "E6",
  kWh: 1.0
}];

var myLabel = "[[title]]: [[value]]kWh\n[[percents]]%";
var myBalloon = "[[title]]";

AmCharts.ready(function () {
  // PIE CHART
  chart = new AmCharts.AmPieChart();
  chart.dataProvider = chartData;
  chart.titleField = "room";
  chart.valueField = "kWh";
  chart.outlineColor = "#FFFFFF";
  chart.outlineAlpha = 0.8;
  chart.outlineThickness = 2;
  chart.labelText = myLabel;
  chart.balloonText = myBalloon;
  chart.hideBalloonTime = 50;

  // WRITE - FIXME
  //chart.write("bigchart");
});
