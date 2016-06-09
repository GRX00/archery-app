package pl.grx.archapp.model;

import java.util.Date;

public class Range {
    private String description;
    private int seriesCount;
    private int arrowsInSeries;
    private Date date;
    private CounterData counterData;

    public Range(Date date) {
        this.date = date;
        this.description = "30 m";
        this.seriesCount = 6;
        this.arrowsInSeries = 6;
        this.counterData = new CounterData();
        counterData.setTimer(4, 0);
        counterData.setSequence(SeriesSequence.ABAB);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSeriesCount() {
        return seriesCount;
    }

    public int getArrowsInSeries() {
        return arrowsInSeries;
    }

    public void setArrowsInSeries(int arrowsInSeries) {
        this.arrowsInSeries = arrowsInSeries;
    }

    public CounterData getCounterData() {
        return counterData;
    }

    public void setSeriesCount(int seriesCount) {
        this.seriesCount = seriesCount;
    }
}
