package com.example.rft.rftbeta1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.telerik.widget.chart.engine.databinding.DataPointBinding;
import com.telerik.widget.chart.visualization.cartesianChart.RadCartesianChartView;
import com.telerik.widget.chart.visualization.cartesianChart.axes.CategoricalAxis;
import com.telerik.widget.chart.visualization.cartesianChart.axes.LinearAxis;
import com.telerik.widget.chart.visualization.cartesianChart.series.categorical.BarSeries;
import com.telerik.widget.chart.visualization.cartesianChart.series.categorical.LineSeries;

import java.util.ArrayList;
import java.util.List;


public class MyActivity extends Activity {

    private List<DayCosump> dayCosumpList;
    private List<DayCosump> dayCosumpList1;
    private List<DayCosump> rankCosumpList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        RadCartesianChartView chartView = new RadCartesianChartView(this);
        RadCartesianChartView chartView1 = new RadCartesianChartView(this);
        RadCartesianChartView barChart = new RadCartesianChartView(this);

        ViewGroup chart1 = (ViewGroup)findViewById(R.id.day_1);
        ViewGroup chart2 = (ViewGroup)findViewById(R.id.day_2);
        ViewGroup chart3 = (ViewGroup)findViewById(R.id.rank_graph);
        chart1.addView(chartView);
        chart2.addView(chartView1);
        chart3.addView(barChart);


        initData();
        initData1();
        initData2();



        LineSeries lineSeries = new LineSeries(this);
        lineSeries.setCategoryBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) throws IllegalArgumentException {
                return ((DayCosump) o).getHours();
            }
        });

        lineSeries.setValueBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) throws IllegalArgumentException {
                return ((DayCosump) o).getUsage();
            }
        });

        lineSeries.setData(this.dayCosumpList);
        chartView.getSeries().add(lineSeries);

        CategoricalAxis categoricalAxis = new CategoricalAxis(this);
        chartView.setHorizontalAxis(categoricalAxis);

        LinearAxis linearAxis =new LinearAxis(this);
        chartView.setVerticalAxis(linearAxis);







        LineSeries lineSeries1 = new LineSeries(this);
        lineSeries1.setCategoryBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) throws IllegalArgumentException {
                return ((DayCosump) o).getHours();
            }
        });

        lineSeries1.setValueBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) throws IllegalArgumentException {
                return ((DayCosump) o).getUsage();
            }
        });

        lineSeries1.setData(this.dayCosumpList1);
        chartView1.getSeries().add(lineSeries1);

        CategoricalAxis categoricalAxis1 = new CategoricalAxis(this);
        chartView1.setHorizontalAxis(categoricalAxis1);

        LinearAxis linearAxis1 =new LinearAxis(this);
        chartView1.setVerticalAxis(linearAxis1);





        BarSeries barSeries = new BarSeries(this);
        barSeries.setCategoryBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) throws IllegalArgumentException {
                return ((DayCosump) o).getHours();
            }
        });

        barSeries.setValueBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) throws IllegalArgumentException {
                return ((DayCosump) o).getUsage();
            }
        });

        barSeries.setData(this.rankCosumpList);
        barChart.getSeries().add(barSeries);

        CategoricalAxis categoricalAxis2 = new CategoricalAxis(this);
        barChart.setHorizontalAxis(categoricalAxis2);

        LinearAxis linearAxis2 =new LinearAxis(this);
        barChart.setVerticalAxis(linearAxis2);

        barSeries.setAreBarsRounded(true);
        barSeries.setRoundBarsRadius(10);

        barChart.setPalette();

    }

    private void initData1() {
        dayCosumpList1 = new ArrayList<DayCosump>();
        dayCosumpList1.add(new DayCosump("0",1.1));
        dayCosumpList1.add(new DayCosump("2",1.4));
        dayCosumpList1.add(new DayCosump("4",3.3));
        dayCosumpList1.add(new DayCosump("6",2.7));
        dayCosumpList1.add(new DayCosump("8",0.6));
        dayCosumpList1.add(new DayCosump("10",1.9));
        dayCosumpList1.add(new DayCosump("12",2.1));
        dayCosumpList1.add(new DayCosump("14",2.3));
        dayCosumpList1.add(new DayCosump("16",1.9));
        dayCosumpList1.add(new DayCosump("18",0.7));
        dayCosumpList1.add(new DayCosump("20",3.2));
        dayCosumpList1.add(new DayCosump("22",2.5));
    }

    private void initData2() {
        rankCosumpList = new ArrayList<DayCosump>();
        rankCosumpList.add(new DayCosump("p1",100.1));
        rankCosumpList.add(new DayCosump("p2",123.4));
        rankCosumpList.add(new DayCosump("p3",134.3));
        rankCosumpList.add(new DayCosump("p4",201.7));
        rankCosumpList.add(new DayCosump("p5",209.6));
        rankCosumpList.add(new DayCosump("p6",215.9));
        rankCosumpList.add(new DayCosump("p7",234.1));
        rankCosumpList.add(new DayCosump("p8",244.3));
        rankCosumpList.add(new DayCosump("p9",315.9));
        rankCosumpList.add(new DayCosump("p10",330.7));
        rankCosumpList.add(new DayCosump("p11",345.2));
        rankCosumpList.add(new DayCosump("p12", 392.5));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initData() {
        dayCosumpList = new ArrayList<DayCosump>();
        dayCosumpList.add(new DayCosump("0",2.1));
        dayCosumpList.add(new DayCosump("2",1.1));
        dayCosumpList.add(new DayCosump("4",2.8));
        dayCosumpList.add(new DayCosump("6",1.7));
        dayCosumpList.add(new DayCosump("8",0.1));
        dayCosumpList.add(new DayCosump("10",0.9));
        dayCosumpList.add(new DayCosump("12",3.1));
        dayCosumpList.add(new DayCosump("14",2.6));
        dayCosumpList.add(new DayCosump("16",2.9));
        dayCosumpList.add(new DayCosump("18",1.7));
        dayCosumpList.add(new DayCosump("20",3.2));
        dayCosumpList.add(new DayCosump("22",1.6));

    }



}
