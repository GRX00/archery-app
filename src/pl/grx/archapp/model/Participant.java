package pl.grx.archapp.model;

import pl.grx.archapp.utils.Uid;
import pl.grx.archapp.model.score.ScoreTable;

import java.util.ArrayList;
import java.util.List;

public class Participant {
    private String uid;
    private String name;
    private List<ScoreTable> scoreTables = new ArrayList<>();

    private ScoreTable currentRangeScoreTable;

    public Participant(String name) {
        uid = Uid.getNext();
        this.name = name;
    }

    public String getId() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public void setNewScoreTables(List<Range> ranges) {
        scoreTables.clear();
        addMissingScoreTables(ranges);
    }

    public void setScoreTables(List<Range> ranges) {
        while (this.scoreTables.size() > ranges.size()) {
            this.scoreTables.remove(this.scoreTables.size()-1);
        }
        addMissingScoreTables(ranges);
    }

    public void setCurrentRangeScoreTable(int currentRangeNr) {
        this.currentRangeScoreTable = scoreTables.get(currentRangeNr);
    }

    public ScoreTable getCurrentRangeScoreTable() {
        return currentRangeScoreTable;
    }

    public void saveScore(Integer score, int index) {
        currentRangeScoreTable.saveScore(score, index);
    }

    private void addMissingScoreTables(List<Range> ranges) {
        for (int i = this.scoreTables.size(); i <= ranges.size(); i++) {
            this.scoreTables.add(new ScoreTable(ranges.get(i-1)));
        }
    }
}
