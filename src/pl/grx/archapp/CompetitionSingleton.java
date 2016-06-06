package pl.grx.archapp;

import pl.grx.archapp.model.Counter;
import pl.grx.archapp.model.Ranking;
import pl.grx.archapp.model.Mat;
import pl.grx.archapp.model.Participant;
import pl.grx.archapp.model.Range;

import java.util.*;

public class CompetitionSingleton {
    private List<Range> ranges = new ArrayList<>();
    private List<Mat> mats = new ArrayList<>();
    private Map<String, Participant> participants = new HashMap<>();

    private int currentRangeIndex = 0;
    private int currentSeriesIndex = 0;

    private boolean currentSeriesStarted = false;
    private boolean currentSeriesFinished = false;
    private boolean currentSeriesReady = false;

    private Ranking ranking;

    private Counter counter;
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
        counter = new Counter();

        setMatsCount(5);
        setRangesCount(2);
    }

    public Counter getCounter() {
        return counter;
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

    public Counter getCurrentRangeCounter() {
        return ranges.get(currentRangeIndex).getCounter();
    }

    public void startSeries() {
        if (currentSeriesFinished) {
            if (currentSeriesIndex == getRange(currentRangeIndex).getSeriesCount()) {
                currentRangeIndex++;
                currentSeriesIndex = 0;
                //TODO: think and fix current Range overflow and open tracks
            } else {
                currentSeriesIndex++;
            }
            currentSeriesFinished = false;
        }
        currentSeriesStarted = true;
    }

    public void finishSeries() {
        currentSeriesFinished = true;
    }

    public void resetSeries() {
        currentSeriesStarted = false;
        currentSeriesFinished = false;
        currentSeriesReady = false;
    }

    public void setCurrentSeriesIndex(int currentSeriesIndex) {
        this.currentSeriesIndex = currentSeriesIndex;
    }

    public void setCurrentRangeIndex(Integer currentRangeIndex) {
        this.currentRangeIndex = currentRangeIndex;
    }

    public void seriesReady() {
        this.currentSeriesReady = true;
    }

    public boolean isSeriesStarted() {
        return currentSeriesStarted;
    }

    public boolean isSeriesFinished() {
        return currentSeriesFinished;
    }

    public boolean isSeriesReady() {
        return currentSeriesReady;
    }
}
