var jsonRequest = new XMLHttpRequest();
jsonRequest.open('GET', 'sample_data.json', false);
jsonRequest.send();

var rftData = JSON.parse(jsonRequest.responseText);
// FIXME
console.log(rftData);

var barChart, lineChart1, lineChart2;

AmCharts.ready(function () {
  barChart   = new RFTChart('barchart',  'barchart',   'bartitle',
                            rftData.rankingChart);
  lineChart1 = new RFTChart('linechart', 'linechart1', 'linetitle1',
                            rftData.historyCharts, 0);
  lineChart2 = new RFTChart('linechart', 'linechart2', 'linetitle2',
                            rftData.historyCharts, 1);
});
