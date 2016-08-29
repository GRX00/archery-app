package pl.grx.archapp.model.counter;

import pl.grx.archapp.model.enums.SeriesSequence;

public class CounterData {

    private final Time prepareTime;
    private final Time seriesTime;
    private final Time yellowTime;
    private final Time redTime;
    private SeriesSequence sequence;

    public CounterData(Time prepareTime, Time seriesTime, Time yellowTime, Time redTime, SeriesSequence sequence) {
        this.prepareTime = prepareTime;
        this.seriesTime = seriesTime;
        this.yellowTime = yellowTime;
        this.redTime = redTime;
        this.sequence = sequence;
    }

    public int getPrepareTime() {
        return prepareTime.get();
    }

    public void setPrepareTime(int minutes, int seconds) {
        prepareTime.set(minutes, seconds);
    }

    public int getSeriesTime() {
        return seriesTime.get();
    }

    public void setSeriesTime(int minutes, int seconds) {seriesTime.set(minutes, seconds);};

    public int getYellowTime() {
        return yellowTime.get();
    }

    public void setYellowTime(int minutes, int seconds) {
        yellowTime.set(minutes, seconds);
    }

    public int getRedTime() {
        return redTime.get();
    }

    public void setRedTime(int minutes, int seconds) {
        redTime.set(minutes, seconds);
    }

    public void setSequence(SeriesSequence sequence) {
        this.sequence = sequence;
    }

    public SeriesSequence getSeriesSequence() {
        return sequence;
    }
}
