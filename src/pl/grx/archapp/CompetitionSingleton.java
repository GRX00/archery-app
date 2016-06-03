package pl.grx.archapp;

import java.util.*;

public class CompetitionSingleton {
    private List<Range> ranges = new ArrayList<>();
    private List<Mat> mats = new ArrayList<>();
    private Map<String, Participant> participants = new HashMap<>();

    private int currentRange = 1;
    private int currentSeries = 1;

    private Ranking ranking;
    private Counter counter;

    private static CompetitionSingleton instance = null;
    public static CompetitionSingleton getInstance() {
        if(instance == null) {
            instance = new CompetitionSingleton();
        }
        return instance;
    }

    private CompetitionSingleton() {
        ranking = new Ranking(participants.keySet());
        counter = new Counter();

        setMatsNr(5);
        setRangesNr(2);
    }

    public static boolean isFirstRun() {
        return instance == null;
    }

    public Counter getCounter() {
        return counter;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setMatsNr(int matsNr) {
        assert(matsNr > 0);
        while (this.mats.size() < matsNr) {
            this.mats.add(new Mat());
        }
        while (this.mats.size() > matsNr) {
            this.mats.remove(this.mats.size()-1);
        }
    }

    public int getMatsSize() {
        return mats.size();
    }

    public Mat getMat(int matNr) {
        return mats.get(matNr-1);
    }

    public void setRangesNr(int rangesNr) {
        assert(rangesNr > 0);
        while (this.ranges.size() < rangesNr) {
            this.ranges.add(new Range(new Date()));
        }
        while (this.ranges.size() > rangesNr) {
            this.ranges.remove(this.ranges.size()-1);
        }
    }

    public Range getRange(int index) {
        assert(index > 0 && index <= mats.size());
        return ranges.get(index + 1);
    }

    public Participant getParticipant(String participantId) {
        return participants.get(participantId);
    }
}
