package com.example.rft.rftbeta1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.telerik.widget.chart.engine.databinding.DataPointBinding;
import com.telerik.widget.chart.engine.series.combination.ChartSeriesCombineMode;
import com.telerik.widget.chart.visualization.annotations.cartesian.CartesianCustomAnnotation;
import com.telerik.widget.chart.visualization.annotations.cartesian.CartesianGridLineAnnotation;
import com.telerik.widget.chart.visualization.cartesianChart.RadCartesianChartView;
import com.telerik.widget.chart.visualization.cartesianChart.axes.CategoricalAxis;
import com.telerik.widget.chart.visualization.cartesianChart.axes.LinearAxis;
import com.telerik.widget.chart.visualization.cartesianChart.series.categorical.BarSeries;
import com.telerik.widget.chart.visualization.cartesianChart.series.categorical.LineSeries;
import com.telerik.widget.primitives.legend.RadLegendView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class MyActivity extends Activity {

    private List<DayCosump> dayCosumpList;
    private List<DayCosump> dayCosumpList1;
    private List<DayCosump> dayCosumpList2;
    private List<DayCosump> dayCosumpList3;
    private List<DayCosump> dayCosumpList4;
    private List<DayCosump> rankCosumpList;
    private List<DayCosump> rankCosumpList2;
    private String[] namelist = new String[24];
    //private List<String> nameMatching;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);



        RadCartesianChartView chartView = new RadCartesianChartView(this);
        RadCartesianChartView chartView1 = new RadCartesianChartView(this);
        RadCartesianChartView chartView2 = new RadCartesianChartView(this);
        RadCartesianChartView chartView3 = new RadCartesianChartView(this);
        RadCartesianChartView chartView4 = new RadCartesianChartView(this);
        RadCartesianChartView barChart = new RadCartesianChartView(this);
        RadLegendView legendView = new RadLegendView(this);


        ViewGroup chart1 = (ViewGroup)findViewById(R.id.stu_p1_chart);
        ViewGroup chart2 = (ViewGroup)findViewById(R.id.stu_p2_chart);
        ViewGroup chart4 = (ViewGroup)findViewById(R.id.stu_p3_chart);
        ViewGroup chart5 = (ViewGroup)findViewById(R.id.stu_p4_chart);
        ViewGroup chart6 = (ViewGroup)findViewById(R.id.stu_p5_chart);
        ViewGroup chart3 = (ViewGroup)findViewById(R.id.vs_chart);
        chart1.addView(chartView);
        chart2.addView(chartView1);
        //chart3.addView(barChart);
        //chart3.addView(legendView);
        chart4.addView(chartView2);
        chart5.addView(chartView3);
        chart6.addView(chartView4);

        namelist[0] = "L. Stevens";
        namelist[1] = "P. Brown";
        namelist[2] = "J. Hauer-King";
        namelist[3] = "F. Lombardi";
        namelist[4] = "M. Miglio";
        namelist[5] = "B. Whitby";
        namelist[6] = "E. Travis";
        namelist[7] = "J. Fulcher";
        namelist[8] = "K. Morrish";
        namelist[9] = "K. Bhate";
        namelist[10] = "J. McManus";
        namelist[11] = "T. Newton";
        namelist[12] = "E. Clark";
        namelist[13] = "J. Heath";
        namelist[14] = "B. Boyd-Taylor";
        namelist[15] = "A. Sabir";
        namelist[16] = "J. Forge";
        namelist[17] = "S. Tesler";
        namelist[18] = "C. Braithwaite";
        namelist[20] = "D. Goddard";
        namelist[21] = "A. Roberts";
        namelist[22] = "H. Stevens";
        namelist[23] = "J. Hwang";


        initData();
        initData1();
        initData2();
        initData3();
        initData4();
        initDataVs1();
        initDataVs2();




        TextView stu_name1 = (TextView)findViewById(R.id.stu_p1_name);
        stu_name1.setText(namelist[21]);
        TextView stu_name2 = (TextView)findViewById(R.id.stu_p2_name);
        stu_name2.setText(namelist[15]);
        TextView stu_name3 = (TextView)findViewById(R.id.stu_p3_name);
        stu_name3.setText(namelist[16]);
        TextView stu_name4 = (TextView)findViewById(R.id.stu_p4_name);
        stu_name4.setText(namelist[9]);
        TextView stu_name5 = (TextView)findViewById(R.id.stu_p5_name);
        stu_name5.setText(namelist[4]);

        TextView j_name = (TextView)findViewById(R.id.j_name);
        j_name.setText(namelist[5]);
        TextView b_name = (TextView)findViewById(R.id.b_name);
        b_name.setText(namelist[23]);


        BarSeries barSeries = new BarSeries();

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

        barSeries.setData(this.dayCosumpList4);
        CategoricalAxis categoricalAxis = new CategoricalAxis();
        chartView.setHorizontalAxis(categoricalAxis);

        LinearAxis linearAxis =new LinearAxis();
        chartView.setVerticalAxis(linearAxis);
        categoricalAxis.setGapLength((float) 0.1);
        linearAxis.setShowLabels(false);
        chartView.getSeries().add(barSeries);
        barSeries.setDataPointRenderer(new CustomBarPointRenderer(barSeries));




        //lineSeries.setShowLabels(true);



        BarSeries barSeries1 = new BarSeries();
        barSeries1.setCategoryBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) throws IllegalArgumentException {
                return ((DayCosump) o).getHours();
            }
        });

        barSeries1.setValueBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) throws IllegalArgumentException {
                return ((DayCosump) o).getUsage();
            }
        });

        barSeries1.setData(this.dayCosumpList1);
        chartView1.getSeries().add(barSeries1);

        CategoricalAxis categoricalAxis1 = new CategoricalAxis();
        chartView1.setHorizontalAxis(categoricalAxis1);

        LinearAxis linearAxis1 =new LinearAxis();
        linearAxis1.setShowLabels(false);
        chartView1.setVerticalAxis(linearAxis1);

        categoricalAxis1.setGapLength((float) 0.1);
        barSeries1.setDataPointRenderer(new CustomBarPointRenderer(barSeries));
        //lineSeries1.setShowLabels(true);


        BarSeries barSeries3 = new BarSeries();
        barSeries3.setCategoryBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) throws IllegalArgumentException {
                return ((DayCosump) o).getHours();
            }
        });

        barSeries3.setValueBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) throws IllegalArgumentException {
                return ((DayCosump) o).getUsage();
            }
        });

        barSeries3.setData(this.dayCosumpList2);
        chartView2.getSeries().add(barSeries3);

        CategoricalAxis categoricalAxis3 = new CategoricalAxis();
        chartView2.setHorizontalAxis(categoricalAxis3);

        LinearAxis linearAxis3 =new LinearAxis();
        linearAxis3.setShowLabels(false);
        chartView2.setVerticalAxis(linearAxis3);
        categoricalAxis3.setGapLength((float) 0.1);
        barSeries3.setDataPointRenderer(new CustomBarPointRenderer(barSeries));

        //lineSeries3.setShowLabels(true);
        BarSeries barSeries4 = new BarSeries();
        barSeries4.setCategoryBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) throws IllegalArgumentException {
                return ((DayCosump) o).getHours();
            }
        });

        barSeries4.setValueBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) throws IllegalArgumentException {
                return ((DayCosump) o).getUsage();
            }
        });

        barSeries4.setData(this.dayCosumpList3);
        chartView3.getSeries().add(barSeries4);

        CategoricalAxis categoricalAxis4 = new CategoricalAxis();
        chartView3.setHorizontalAxis(categoricalAxis4);

        LinearAxis linearAxis4 =new LinearAxis();
        linearAxis4.setShowLabels(false);
        chartView3.setVerticalAxis(linearAxis4);
        categoricalAxis4.setGapLength((float) 0.1);
        barSeries4.setDataPointRenderer(new CustomBarPointRenderer(barSeries));


        BarSeries barSeries5 = new BarSeries();
        barSeries5.setCategoryBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) throws IllegalArgumentException {
                return ((DayCosump) o).getHours();
            }
        });

        barSeries5.setValueBinding(new DataPointBinding() {
            @Override
            public Object getValue(Object o) throws IllegalArgumentException {
                return ((DayCosump) o).getUsage();
            }
        });

        barSeries5.setData(this.dayCosumpList);
        chartView4.getSeries().add(barSeries5);

        CategoricalAxis categoricalAxis5 = new CategoricalAxis();
        chartView4.setHorizontalAxis(categoricalAxis5);

        LinearAxis linearAxis5 =new LinearAxis();
        linearAxis5.setShowLabels(false);
        chartView4.setVerticalAxis(linearAxis5);
        categoricalAxis5.setGapLength((float) 0.1);
        barSeries5.setDataPointRenderer(new CustomBarPointRenderer(barSeries));








        LineSeries lineSeries = new LineSeries();
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

        lineSeries.setData(this.rankCosumpList);
        barChart.getSeries().add(lineSeries);

        LineSeries lineSeries1 = new LineSeries();
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

        lineSeries1.setData(this.rankCosumpList2);
        barChart.getSeries().add(lineSeries1);
        lineSeries1.setStrokeColor(Color.GREEN);

        lineSeries.setCombineMode(ChartSeriesCombineMode.CLUSTER);
        lineSeries1.setCombineMode(ChartSeriesCombineMode.CLUSTER);

        lineSeries.setLegendTitle(namelist[5]);
        lineSeries1.setLegendTitle(namelist[23]);

        legendView.setLegendProvider(barChart);



        CategoricalAxis categoricalAxis2 = new CategoricalAxis();
        categoricalAxis2.setLabelTextColor(Color.YELLOW);

        barChart.setHorizontalAxis(categoricalAxis2);

        LinearAxis linearAxis2 =new LinearAxis();
        barChart.setVerticalAxis(linearAxis2);

        //chart3.addView(barChart);


        CartesianGridLineAnnotation annotation4 = new CartesianGridLineAnnotation(linearAxis2, 0.38);
        annotation4.setStrokeColor(Color.WHITE);
        annotation4.setStrokeWidth(2);
        barChart.getAnnotations().add(annotation4);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.addView(legendView);
        linearLayout.addView(barChart);
        //linearLayout.setGravity();

        chart3.addView(linearLayout);
        //chart3.addView(barChart);






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
        //InputStream inputStream = getResources().openRawResource(R.raw.rawdata);

        //String raw_data = new Scanner(inputStream,"UTF-8").useDelimiter("\\A").next();
        //String[] data_array = raw_data.split("\n");


        dayCosumpList = new ArrayList<DayCosump>();
        dayCosumpList.add(new DayCosump("M",1.4));
        dayCosumpList.add(new DayCosump("Tu",0.3));
        dayCosumpList.add(new DayCosump("W",2.0));
        dayCosumpList.add(new DayCosump("Th",1.6));
        dayCosumpList.add(new DayCosump("F",1.0));
        dayCosumpList.add(new DayCosump("Sa",1.5));
        dayCosumpList.add(new DayCosump("Su",1.1));
    }

    private void initData1() {
        //InputStream inputStream = getResources().openRawResource(R.raw.rawdata);
        //String raw_data = new Scanner(inputStream,"UTF-8").useDelimiter("\\A").next();
        //String[] data_array = raw_data.split("\n");


        dayCosumpList1 = new ArrayList<DayCosump>();
        dayCosumpList1.add(new DayCosump("M",0.3));
        dayCosumpList1.add(new DayCosump("Tu",0.6));
        dayCosumpList1.add(new DayCosump("W",0.5));
        dayCosumpList1.add(new DayCosump("Th",0.7));
        dayCosumpList1.add(new DayCosump("F",0.6));
        dayCosumpList1.add(new DayCosump("Sa",1.4));
        dayCosumpList1.add(new DayCosump("Su",1.1));
    }

    private void initData2() {
        //InputStream inputStream = getResources().openRawResource(R.raw.rawdata);
        //String raw_data = new Scanner(inputStream,"UTF-8").useDelimiter("\\A").next();
        //String[] data_array = raw_data.split("\n");


        dayCosumpList2 = new ArrayList<DayCosump>();
        dayCosumpList2.add(new DayCosump("M",0.3));
        dayCosumpList2.add(new DayCosump("Tu",1.2));
        dayCosumpList2.add(new DayCosump("W",1.4));
        dayCosumpList2.add(new DayCosump("Th",0.8));
        dayCosumpList2.add(new DayCosump("F",1.6));
        dayCosumpList2.add(new DayCosump("Sa",2));
        dayCosumpList2.add(new DayCosump("Su",0.9));
    }

    private void initData3() {
        //InputStream inputStream = getResources().openRawResource(R.raw.rawdata);
        //String raw_data = new Scanner(inputStream,"UTF-8").useDelimiter("\\A").next();
        //String[] data_array = raw_data.split("\n");


        dayCosumpList3 = new ArrayList<DayCosump>();
        dayCosumpList3.add(new DayCosump("M",1.0));
        dayCosumpList3.add(new DayCosump("Tu",0.4));
        dayCosumpList3.add(new DayCosump("W",0.6));
        dayCosumpList3.add(new DayCosump("Th",1.5));
        dayCosumpList3.add(new DayCosump("F",0.3));
        dayCosumpList3.add(new DayCosump("Sa",0.2));
        dayCosumpList3.add(new DayCosump("Su",1.1));
    }

    private void initData4() {
        //InputStream inputStream = getResources().openRawResource(R.raw.rawdata);
        //String raw_data = new Scanner(inputStream,"UTF-8").useDelimiter("\\A").next();
        //String[] data_array = raw_data.split("\n");


        dayCosumpList4 = new ArrayList<DayCosump>();
        dayCosumpList4.add(new DayCosump("M",1.1));
        dayCosumpList4.add(new DayCosump("Tu",0.2));
        dayCosumpList4.add(new DayCosump("W",1.4));
        dayCosumpList4.add(new DayCosump("Th",0.8));
        dayCosumpList4.add(new DayCosump("F",0.5));
        dayCosumpList4.add(new DayCosump("Sa",1.0));
        dayCosumpList4.add(new DayCosump("Su",2.0));
    }


    private void initDataVs1() {

        //InputStream inputStream = getResources().openRawResource(R.raw.rawdata);
        //String raw_data = new Scanner(inputStream,"UTF-8").useDelimiter("\\A").next();
        //String[] data_array = raw_data.split("\n");
        //Random random_double = new Random();

        rankCosumpList = new ArrayList<DayCosump>();
        rankCosumpList.add(new DayCosump("Mon.0",0.13));
        rankCosumpList.add(new DayCosump("Mon.1",0.24));
        //rankCosumpList.add(new DayCosump("Mon.2",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Mon.3",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Mon.4",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Mon.5",random_double.nextDouble()));

        rankCosumpList.add(new DayCosump("Tue.0",0.19));
        rankCosumpList.add(new DayCosump("Tue.1",0.2));
        //rankCosumpList.add(new DayCosump("Tue.2",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Tue.3",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Tue.4",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Tue.5",random_double.nextDouble()));

        rankCosumpList.add(new DayCosump("Wed.0",0.27));
        rankCosumpList.add(new DayCosump("Wed.1",0.13));
        //rankCosumpList.add(new DayCosump("Wed.2",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Wed.3",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Wed.4",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Wed.5",random_double.nextDouble()));

        rankCosumpList.add(new DayCosump("Thu.0",0.36));
        rankCosumpList.add(new DayCosump("Thu.1",0.33));
        //rankCosumpList.add(new DayCosump("Thu.2",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Thu.3",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Thu.4",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Thu.5",random_double.nextDouble()));

        rankCosumpList.add(new DayCosump("Fri.0",0.13));
        rankCosumpList.add(new DayCosump("Fri.1",0.15));
        //rankCosumpList.add(new DayCosump("Fri.2",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Fri.3",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Fri.4",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Fri.5",random_double.nextDouble()));

        rankCosumpList.add(new DayCosump("Sat.0",0.57));
        rankCosumpList.add(new DayCosump("Sat.1",0.45));
        //rankCosumpList.add(new DayCosump("Sat.2",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Sat.3",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Sat.4",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Sat.5",random_double.nextDouble()));

        rankCosumpList.add(new DayCosump("Sun.0",0.52));
        rankCosumpList.add(new DayCosump("Sun.1",0.42));
        //rankCosumpList.add(new DayCosump("Sun.2",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Sun.3",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Sun.4",random_double.nextDouble()));
        //rankCosumpList.add(new DayCosump("Sun.5",random_double.nextDouble()));

    }


    private void initDataVs2() {

        //InputStream inputStream = getResources().openRawResource(R.raw.rawdata);
        //String raw_data = new Scanner(inputStream,"UTF-8").useDelimiter("\\A").next();
        //String[] data_array = raw_data.split("\n");
        //Random random_double = new Random();

        rankCosumpList2 = new ArrayList<DayCosump>();
        rankCosumpList2.add(new DayCosump("Mon.0",0.5));
        rankCosumpList2.add(new DayCosump("Mon.1",0.47));
        //rankCosumpList2.add(new DayCosump("Mon.2",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Mon.3",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Mon.4",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Mon.5",random_double.nextDouble()));

        rankCosumpList2.add(new DayCosump("Tue.0",0.44));
        rankCosumpList2.add(new DayCosump("Tue.1",0.43));
        //rankCosumpList2.add(new DayCosump("Tue.2",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Tue.3",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Tue.4",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Tue.5",random_double.nextDouble()));

        rankCosumpList2.add(new DayCosump("Wed.0",0.58));
        rankCosumpList2.add(new DayCosump("Wed.1",0.52));
        //rankCosumpList2.add(new DayCosump("Wed.2",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Wed.3",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Wed.4",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Wed.5",random_double.nextDouble()));

        rankCosumpList2.add(new DayCosump("Thu.0",0.52));
        rankCosumpList2.add(new DayCosump("Thu.1",0.56));
        //rankCosumpList2.add(new DayCosump("Thu.2",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Thu.3",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Thu.4",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Thu.5",random_double.nextDouble()));

        rankCosumpList2.add(new DayCosump("Fri.0",0.44));
        rankCosumpList2.add(new DayCosump("Fri.1",0.49));
        //rankCosumpList2.add(new DayCosump("Fri.2",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Fri.3",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Fri.4",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Fri.5",random_double.nextDouble()));

        rankCosumpList2.add(new DayCosump("Sat.0",0.37));
        rankCosumpList2.add(new DayCosump("Sat.1",0.42));
        //rankCosumpList2.add(new DayCosump("Sat.2",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Sat.3",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Sat.4",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Sat.5",random_double.nextDouble()));

        rankCosumpList2.add(new DayCosump("Sun.0",0.53));
        rankCosumpList2.add(new DayCosump("Sun.1",0.48));
        //rankCosumpList2.add(new DayCosump("Sun.2",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Sun.3",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Sun.4",random_double.nextDouble()));
        //rankCosumpList2.add(new DayCosump("Sun.5",random_double.nextDouble()));

    }
}
