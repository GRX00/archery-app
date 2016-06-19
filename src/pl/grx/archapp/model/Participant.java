package pl.grx.archapp.model;

import pl.grx.archapp.model.score.ScoreTable;
import pl.grx.archapp.utils.Uid;

import java.util.ArrayList;
import java.util.List;

public class Participant {
    private String uid;
    private String name;
    private List<ScoreTable> scoreTables = new ArrayList<>();

    private ScoreTable currentRangeScoreTable;
    private int currentRangeIndex;

    public Participant(String name) {
        uid = Uid.getNext();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean nameEquals(String name) {
        return this.name.equalsIgnoreCase(name);
    }

    public void setScoreTables(List<Range> ranges, int currentRangeIndex) {
        this.currentRangeIndex = currentRangeIndex;
        removeRedundantScoreTables(ranges);
        addMissingScoreTables(ranges);
        this.currentRangeScoreTable = scoreTables.get(currentRangeIndex);
    }

    public void setCurrentRangeScoreTable(int currentRangeIndex) {
        this.currentRangeIndex = currentRangeIndex;
        this.currentRangeScoreTable = scoreTables.get(currentRangeIndex);
    }

    public ScoreTable getCurrentRangeScoreTable() {
        return currentRangeScoreTable;
    }

    public void saveScore(Integer score, int index) {
        currentRangeScoreTable.saveScore(score, index);
    }

    private void removeRedundantScoreTables(List<Range> ranges) {
        while (this.scoreTables.size() > ranges.size() && this.scoreTables.size() > (currentRangeIndex + 1)) {
            this.scoreTables.remove(this.scoreTables.size() - 1);
        }
    }

    private void addMissingScoreTables(List<Range> ranges) {
        for (int i = this.scoreTables.size(); i < ranges.size(); i++) {
            this.scoreTables.add(new ScoreTable(ranges.get(i)));
        }
    }
}
