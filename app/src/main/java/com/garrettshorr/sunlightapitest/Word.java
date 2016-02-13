package com.garrettshorr.sunlightapitest;

/**
 * Created by gshorr on 2/12/16.
 */
public class Word {
    private int count;
    private double percentage;
    private int total;
    private int raw_count;
    private String day;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRaw_count() {
        return raw_count;
    }

    public void setRaw_count(int raw_count) {
        this.raw_count = raw_count;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String toString() {
        return "count: " + count + "\npercentage: " + percentage;
    }
}
