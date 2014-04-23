var dataUrl = 'sample_data.json';
var dataUpdateMs = 60000; // 1 minute
var lineUpdateMs = 5000; // 10 seconds

var rftData = fetchData(dataUrl);
var barChart, lineChart1, lineChart2;

AmCharts.ready(function () {
  barChart   = new RFTChart('barchart',  'barchart',   'bartitle',
                            rftData.rankingChart);
  lineChart1 = new RFTChart('linechart', 'linechart1', 'linetitle1',
                            rftData.historyCharts, rftData.numRooms - 1);
  lineChart2 = new RFTChart('linechart', 'linechart2', 'linetitle2',
                            rftData.historyCharts, 0);
});

function fetchData (url) {
  var request = new XMLHttpRequest();
  request.open('GET', url, false);
  request.send();

  return JSON.parse(request.responseText);
}

// Update the line charts regularly
window.setInterval(function () {
  lineChart1.update(rftData.historyCharts);
  lineChart2.update(rftData.historyCharts);
}, lineUpdateMs);

// Update data and the bar chart regularly
window.setInterval(function () {
  rftData = fetchData(dataUrl);
  barChart.update(rftData.rankingChart);
}, dataUpdateMs);
