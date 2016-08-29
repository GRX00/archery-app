package pl.grx.archapp.model;

import pl.grx.archapp.model.counter.CounterData;
import pl.grx.archapp.model.counter.CounterState;

public class RangesControl {

    private final CounterState counterState;
    private final Participants participants;
    private final RangesSetup rangesSetup;

    private int currentSeriesIndex = 0;
    private int currentRangeIndex = 0;

    public RangesControl(
            RangesSetup rangesSetup,
            CounterState counterState,
            Participants participants) {
        this.rangesSetup = rangesSetup;
        this.counterState = counterState;
        this.participants = participants;
    }

    public int getCurrentRangeIndex() {
        return currentRangeIndex;
    }

    public int getCurrentSeriesIndex() {
        return currentSeriesIndex;
    }

    public CounterData getCurrentCounterData() {
        return rangesSetup.getRangeCounterData(currentRangeIndex);
    }

    public void resetSeries() {
        if (counterState.isCounterFinished()) {
            nextSeries();
        }
        counterState.resetCounter();
//        counterState.setCounter(getCurrentCounterData());
    }

    public void nextRange() {
        if (currentRangeIndex < rangesSetup.getRangesCount() - 1) {
            currentRangeIndex++;
            currentSeriesIndex = 0;
        }
        participants.setParticipantsCurrentRangeSeries(currentRangeIndex, currentSeriesIndex);
    }

    public void previousRange() {
        if (currentRangeIndex > 0) {
            currentRangeIndex--;
            currentSeriesIndex = 0;
        }
        participants.setParticipantsCurrentRangeSeries(currentRangeIndex, currentSeriesIndex);
    }

    public void nextSeries() {
        if (currentSeriesIndex < rangesSetup.getRangeSeriesCount(currentRangeIndex) - 1) {
            currentSeriesIndex++;
        } else {
            nextRange();
        }
        participants.setParticipantsCurrentRangeSeries(currentRangeIndex, currentSeriesIndex);
    }

    public void previousSeries() {
        if (currentSeriesIndex > 0) {
            currentSeriesIndex--;
        } else {
            if (currentRangeIndex > 0) {
                currentRangeIndex--;
                currentSeriesIndex = rangesSetup.getRangeSeriesCount(currentRangeIndex) - 1;
            }
        }
        participants.setParticipantsCurrentRangeSeries(currentRangeIndex, currentSeriesIndex);
    }

    public void startSeries() {

    }

    public void finishSeries() {

    }
}
