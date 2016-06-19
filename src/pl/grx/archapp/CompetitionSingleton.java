package pl.grx.archapp;

import pl.grx.archapp.controller.CounterState;
import pl.grx.archapp.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompetitionSingleton {
    private List<Range> ranges = new ArrayList<>();
    private List<Mat> mats = new ArrayList<>();
    private List<Participant> participants = new ArrayList<>();

    private int currentRangeIndex = 0;
    private int currentSeriesIndex = 0;

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
        ranking = new Ranking(participants);
        counterState = new CounterState();

        setMatsCount(5);
        setRangesCount(2);
    }

    public CounterState getCounterState() {
        return counterState;
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

    public Participant getParticipant(String name) {
        for (Participant participant : participants) {
            if (participant.nameEquals(name)) {
                return participant;
            }
        }
        return null;
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

    public String getParticipant(int matIndex, int positionIndex) {
        Mat mat = mats.get(matIndex);
        return mat.getParticipant(positionIndex);
    }

    public void setParticipant(int matIndex, int positionIndex, String name) {
        Participant participant = null;

        if (!name.equals("")) {
            participant = findParticipant(name);
            if (participant == null) {
                participant = createParticipant(name);
            }
        }

        Mat mat = getMat(matIndex);
        mat.setParticipant(positionIndex, participant);
    }

    private Participant findParticipant(String name) {
        for (Participant participant : participants) {
            if (participant.getName().equalsIgnoreCase(name)) {
                return participant;
            }
        }
        return null;
    }

    private Participant createParticipant(String name) {
        Participant participant = new Participant(name);
        participants.add(participant);
        return participant;
    }

    public void setupParticipants() {
        for (Participant participant : participants) {
            participant.setScoreTables(ranges, currentRangeIndex);
        }
    }

    public List<String> getParticipantsNames() {
        List<String> participantNames = new ArrayList<>();
        for (Participant participant : participants) {
            participantNames.add(participant.getName());
        }
        return participantNames;
    }
}
