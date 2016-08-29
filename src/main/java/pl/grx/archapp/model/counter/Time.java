package pl.grx.archapp.model.counter;

public class Time {

    private int seconds;

    public Time(int minutes, int seconds) {
        set(minutes, seconds);
    }

    public void set(int minutes, int seconds) {
        this.seconds = (minutes < 0 ? 0 : minutes) * 60 + (seconds < 0 ? 0 : seconds);
    }

    public int get() {
        return seconds;
    }
}
