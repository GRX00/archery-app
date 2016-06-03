package pl.grx.archapp;

import java.util.ArrayList;
import java.util.List;

public class CompetitionSingleton {
    private List<Range> ranges = new ArrayList<>();
    private List<Participant> participants = new ArrayList<>();

    private int rangesNr = 2;
    private int mats = 5;
    private int participantsPerMat = 4;

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
        ranking = new Ranking(participants);
        counter = new Counter();
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

    public int getMats() {
        return mats;
    }
}
