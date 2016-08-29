package pl.grx.archapp.displayhelper;

import pl.grx.archapp.model.counter.CounterData;
import pl.grx.archapp.model.enums.SeriesSequence;

public class CounterDataDisplayHelper {
    private final CounterData counterData;

    public CounterDataDisplayHelper(CounterData counterData) {
        this.counterData = counterData;
    }

    public String getSeriesTimeMinutes() {
        return getTimeMinutes(counterData.getSeriesTime());
    }

    public String getSeriesTimeSeconds() {
        return getTimeSeconds(counterData.getSeriesTime());
    }

    public void setSeriesTime(String seriesTimeMinutes, String seriesTimeSeconds) {
        counterData.setSeriesTime(Integer.valueOf(seriesTimeMinutes), Integer.valueOf(seriesTimeSeconds));
    }

    public String getPrepareTimeMinutes() {
        return getTimeMinutes(counterData.getPrepareTime());
    }

    public String getPrepareTimeSeconds() {
        return getTimeSeconds(counterData.getPrepareTime());
    }

    public void setPrepareTime(String seriesTimeMinutes, String seriesTimeSeconds) {
        counterData.setPrepareTime(Integer.valueOf(seriesTimeMinutes), Integer.valueOf(seriesTimeSeconds));
    }

    public String getYellowTimeMinutes() {
        return getTimeMinutes(counterData.getYellowTime());
    }

    public String getYellowTimeSeconds() {
        return getTimeSeconds(counterData.getYellowTime());
    }

    public void setYellowTime(String seriesTimeMinutes, String seriesTimeSeconds) {
        counterData.setYellowTime(Integer.valueOf(seriesTimeMinutes), Integer.valueOf(seriesTimeSeconds));
    }

    public String getRedTimeMinutes() {
        return getTimeMinutes(counterData.getRedTime());
    }

    public String getRedTimeSeconds() {
        return getTimeSeconds(counterData.getRedTime());
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
