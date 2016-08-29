package pl.grx.archapp.model.counter;

public class CounterState {
    private Boolean counterStarted = true;
    private Boolean counterFinished = true;

    private int counter;

    public void setCounter(CounterData rangeCounterData) {
        counter = rangeCounterData.getPrepareTime() + rangeCounterData.getSeriesTime();
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean isCounterStarted() {
        return counterStarted;
    }

    public boolean isCounterFinished() {
        return counterFinished;
    }

    public void resetCounter() {
        counterStarted = false;
        counterFinished = false;
    }

    public void startCounter() {
        counterStarted = true;
    }

    public void finishCounter() {
        counterFinished = true;
    }

    public int getCounter() {
        return counter;
    }
}
