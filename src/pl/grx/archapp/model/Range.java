package pl.grx.archapp.model;

import java.util.Date;

public class Range {
    private String description;
    private int seriesCount;
    private ArrowsInSeries arrowsInSeries;
    private Date date;
    private CounterData counterData;

    public Range(Date date) {
        this.date = date;
        this.description = "";
        this.seriesCount = 6;
        this.arrowsInSeries = ArrowsInSeries.SIX;
        this.counterData = new CounterData();
        counterData.setTimer(4, 0);
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getSeriesCount() {
        return seriesCount;
    }

    public ArrowsInSeries getArrowsInSeries() {
        return arrowsInSeries;
    }

    public CounterData getCounterData() {
        return counterData;
    }
}
