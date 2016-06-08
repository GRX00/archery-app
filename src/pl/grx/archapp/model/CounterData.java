package pl.grx.archapp.model;

public class CounterData {

    private int prepareTimeSec;
    private int seriesTimeSec;
    private int yellowTimeSec;
    private int redTimeSec;

    public void setTimer(int minutes, int seconds) {
        prepareTimeSec = 10;
        seriesTimeSec = minutes*60+seconds;
        yellowTimeSec = (int) Math.ceil(seriesTimeSec * 0.3);
        redTimeSec = (int) Math.ceil(seriesTimeSec * 0.1);
    }

    public void setPrepareTime(int minutes, int seconds) {
        prepareTimeSec = minutes*60+seconds;
    }

    public void setYellowTime(int minutes, int seconds) {
        yellowTimeSec = minutes*60+seconds;
    }

    public void setRedTime(int minutes, int seconds) {
        redTimeSec = minutes*60+seconds;
    }

    public int getSeriesTimeSec() {
        return seriesTimeSec;
    }

    public int getPrepareTimeSec() {
        return prepareTimeSec;
    }

    public int getYellowTimeSec() {
        return yellowTimeSec;
    }

    public int getRedTimeSec() {
        return redTimeSec;
    }
}
