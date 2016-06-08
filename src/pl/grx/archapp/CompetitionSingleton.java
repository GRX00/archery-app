package pl.grx.archapp;

import pl.grx.archapp.controller.CounterState;
import pl.grx.archapp.model.*;

import java.util.*;

public class CompetitionSingleton {
    private List<Range> ranges = new ArrayList<>();
    private List<Mat> mats = new ArrayList<>();
    private Map<String, Participant> participants = new HashMap<>();

    private int currentRangeIndex = 0;
    private int currentSeriesIndex = 0;

    private boolean currentSeriesStarted = false;
    private boolean currentSeriesFinished = false;

    private Ranking ranking;

    private CounterState counterState;

    private static CompetitionSingleton instance = null;
    public static boolean isFirstRun() {
        return instance == null;
    }
    public static CompetitionSingleton getInstance() {
        if(instance == null) {
            instance = new CompetitionSingleton();
        }
        return instance;
    }

    private CompetitionSingleton() {
        ranking = new Ranking(participants.keySet());
        counterState = new CounterState();

        setMatsCount(5);
        setRangesCount(2);
    }

    public CounterState getCounterState() {
        return counterState;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public int getMatsSize() {
        return mats.size();
    }

    public Mat getMat(int index) {
        assert(index >= 0 && index < mats.size());
        return mats.get(index);
    }

    public void setMatsCount(int matsCount) {
        assert(matsCount > 0);
        while (this.mats.size() < matsCount) {
            this.mats.add(new Mat());
        }
        while (this.mats.size() > matsCount) {
            this.mats.remove(this.mats.size()-1);
        }
    }

    public int getRangesSize() {
        return ranges.size();
    }

    public void setRangesCount(int rangesCount) {
        assert(rangesCount > 0);
        while (this.ranges.size() < rangesCount) {
            this.ranges.add(new Range(new Date()));
        }
        while (this.ranges.size() > rangesCount) {
            this.ranges.remove(this.ranges.size()-1);
        }
    }

    public Range getRange(int index) {
        assert(index >= 0 && index < ranges.size());
        return ranges.get(index);
    }

    public Participant getParticipant(String participantId) {
        return participants.get(participantId);
    }

    public CounterData getCurrentRangeCounterData() {
        return ranges.get(currentRangeIndex).getCounterData();
    }

    public void startSeries() {
        counterState.startCounter();
    }

    public void finishSeries() {
        counterState.finishCounter();
    }

    public void resetSeries() {
        if (counterState.isCounterFinished()) {
            nextSeries();
        }
        counterState.resetCounter();
        counterState.setCounter(getCurrentRangeCounterData());
    }

    public int getCurrentRangeIndex() {
        return currentRangeIndex;
    }

    public int getCurrentSeriesIndex() {
        return currentSeriesIndex;
    }

    public void nextSeries() {
        if (currentSeriesIndex < getRange(currentRangeIndex).getSeriesCount() - 1) {
            currentSeriesIndex++;
        } else {
            nextRange();
        }
    }

    public void previousSeries() {
        if (currentSeriesIndex > 0) {
            currentSeriesIndex--;
        } else {
            if (currentRangeIndex > 0) {
                currentRangeIndex--;
                currentSeriesIndex = getRange(currentRangeIndex).getSeriesCount() - 1;
            }
        }
    }

    public void nextRange() {
        if (currentRangeIndex < ranges.size() - 1) {
            currentRangeIndex++;
            currentSeriesIndex = 0;
        }
    }

    public void previousRange() {
        if (currentRangeIndex > 0) {
            currentRangeIndex--;
            currentSeriesIndex = 0;
        }

    }
}
