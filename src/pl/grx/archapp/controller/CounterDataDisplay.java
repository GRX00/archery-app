package pl.grx.archapp.controller;

import pl.grx.archapp.model.CounterData;
import pl.grx.archapp.model.SeriesSequence;

public class CounterDataDisplay {
    private final CounterData counterData;

    public CounterDataDisplay(RangeDisplay rangeDisplay) {
        counterData = rangeDisplay.getCounterData();
    }

    public String getSeriesTimeMinutes() {
        return getTimeMinutes(counterData.getSeriesTimeSec());
    }

    public String getSeriesTimeSeconds() {
        return getTimeSeconds(counterData.getSeriesTimeSec());
    }

    public void setSeriesTime(String seriesTimeMinutes, String seriesTimeSeconds) {
        counterData.setTimer(Integer.valueOf(seriesTimeMinutes), Integer.valueOf(seriesTimeSeconds));
    }

    public String getPrepareTimeMinutes() {
        return getTimeMinutes(counterData.getPrepareTimeSec());
    }

    public String getPrepareTimeSeconds() {
        return getTimeSeconds(counterData.getPrepareTimeSec());
    }

    public void setPrepareTime(String seriesTimeMinutes, String seriesTimeSeconds) {
        counterData.setPrepareTime(Integer.valueOf(seriesTimeMinutes), Integer.valueOf(seriesTimeSeconds));
    }

    public String getYellowTimeMinutes() {
        return getTimeMinutes(counterData.getYellowTimeSec());
    }

    public String getYellowTimeSeconds() {
        return getTimeSeconds(counterData.getYellowTimeSec());
    }

    public void setYellowTime(String seriesTimeMinutes, String seriesTimeSeconds) {
        counterData.setYellowTime(Integer.valueOf(seriesTimeMinutes), Integer.valueOf(seriesTimeSeconds));
    }

    public String getRedTimeMinutes() {
        return getTimeMinutes(counterData.getRedTimeSec());
    }

    public String getRedTimeSeconds() {
        return getTimeSeconds(counterData.getRedTimeSec());
    }

    public void setRedTime(String seriesTimeMinutes, String seriesTimeSeconds) {
        counterData.setRedTime(Integer.valueOf(seriesTimeMinutes), Integer.valueOf(seriesTimeSeconds));
    }

    private String getTimeMinutes(int timeSeconds) {
        return String.valueOf(timeSeconds / 60);
    }

    private String getTimeSeconds(int timeSeconds) {
        int seconds = timeSeconds % 60;

        if (seconds <= 9) {
            return "0" + String.valueOf(seconds);
        } else {
            return String.valueOf(seconds);
        }
    }

    public void setSequence(String sequence) {
        counterData.setSequence(SeriesSequence.valueOf(sequence));
    }

    public String isSelectedSeriesSequence(SeriesSequence seriesSequence) {
        if (counterData.getSeriesSequence() == seriesSequence) {
            return "selected";
        } else {
            return "";
        }
    }
}
