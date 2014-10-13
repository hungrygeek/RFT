package com.example.rft.rftbeta1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.telerik.android.common.Util;
import com.telerik.android.common.math.RadRect;
import com.telerik.widget.chart.engine.dataPoints.CategoricalDataPoint;
import com.telerik.widget.chart.engine.dataPoints.DataPoint;
import com.telerik.widget.chart.visualization.cartesianChart.series.categorical.BarSeries;
import com.telerik.widget.chart.visualization.cartesianChart.series.pointrenderers.BarPointRenderer;
import com.telerik.widget.palettes.PaletteEntry;

import java.util.HashMap;

/**
 * Created by Shi Shu on 13/10/2014.
 */

public class CustomBarPointRenderer extends BarPointRenderer {
    private HashMap<DataPoint, PaletteEntry> pointColors = new HashMap<DataPoint, PaletteEntry>();

    public CustomBarPointRenderer(BarSeries series) {
        super(series);
    }

    public HashMap<DataPoint, PaletteEntry> pointColors() {
        return this.pointColors;
    }
    @Override
    protected void renderPointCore(Canvas canvas, DataPoint point) {
        BarSeries series = this.getSeries();
        float roundBarsRadius = series.getRoundBarsRadius();
        //roundBarsRadius /= 2.0;
        RadRect layoutSlot = point.getLayoutSlot();
        RectF pointRect = Util.convertToRectF(layoutSlot);
        Paint fillPaint = new Paint();
        CategoricalDataPoint categoricalDataPoint = (CategoricalDataPoint)point;
        if(categoricalDataPoint.getValue() >= 1.5) {
            fillPaint.setColor(Color.RED);
        } else {
            fillPaint.setColor(Color.GREEN);
        }
        Paint strokePaint = series.getStrokePaint();
        float strokeWidth = this.getSeries().getStrokeWidth();
        strokePaint.setStrokeWidth(strokeWidth);
        //strokeWidth /= 3.0f;
        //pointRect.left += strokeWidth;
        //pointRect.right -= strokeWidth;
        //pointRect.top += strokeWidth;
        //pointRect.bottom -= strokeWidth;
        if (series.getAreBarsRounded()) {
            canvas.drawRoundRect(pointRect, roundBarsRadius, roundBarsRadius, fillPaint);
            canvas.drawRoundRect(pointRect, roundBarsRadius, roundBarsRadius, strokePaint);
        } else {
            canvas.drawRect(pointRect, fillPaint);
            canvas.drawRect(pointRect, strokePaint);
        }
    }
}