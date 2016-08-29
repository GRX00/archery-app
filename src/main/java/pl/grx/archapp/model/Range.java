package pl.grx.archapp.model;

import pl.grx.archapp.model.counter.CounterData;
import pl.grx.archapp.model.score.SeriesSettings;

import java.util.Date;

public class Range {
    private final SeriesSettings seriesSettings;
    private final CounterData counterData;
    private String description;
    private Date date;

    public Range(Date date,
                 String description,
                 SeriesSettings seriesSettings,
                 CounterData counterData) {
        this.date = date;
        this.description = description;
        this.seriesSettings = seriesSettings;
        this.counterData = counterData;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CounterData getCounterData() {
        return this.counterData;
    }

    public int getSeriesCount() {
        return this.seriesSettings.getSeriesCount();
    }

    public int getArrowsInSeries() {
        return this.seriesSettings.getArrowsInSeries();
    }

    public void setSeriesCount(Integer seriesCount) {
        this.seriesSettings.setSeriesCount(seriesCount);
    }

    public void setArrowsInSeries(Integer arrowsInSeries) {
        this.seriesSettings.setArrowsInSeries(arrowsInSeries);
    }
}
