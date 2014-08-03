package com.example.rft.rftbeta1;

/**
 * Created by shishu on 03/08/2014.
 */
public class DayCosump {
    private String hours;
    private double usage;

    public DayCosump(String hours, double usage){
        this.setHours(hours);
        this.setUsage(usage);
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void setUsage(double usage) {
        this.usage = usage;
    }

    public double getUsage() {
        return usage;
    }

    public String getHours() {
        return hours;
    }
}
