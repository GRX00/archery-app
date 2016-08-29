package pl.grx.archapp.model;

import pl.grx.archapp.model.score.ScoreTable;
import pl.grx.archapp.model.score.ScoreTables;
import pl.grx.archapp.model.utils.Uid;

import java.util.List;

public class Participant {
    private String uid;
    private String name;
    private int matIndex;
    private int positionIndex;

    private ScoreTables scoreTables;

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

    public void setPosition(int matIndex, int positionIndex) {
        this.matIndex = matIndex;
        this.positionIndex = positionIndex;
    }



    public void setScoreTables(List<Range> ranges, int currentRangeIndex) {
        scoreTables.setScoreTables(ranges, currentRangeIndex);
    }

    public void setCurrentRangeScoreTable(int currentRangeIndex) {
        scoreTables.setCurrentRangeScoreTable(currentRangeIndex);
    }

    public ScoreTable getCurrentRangeScoreTable() {
        return scoreTables.getCurrentRangeScoreTable();
    }

    public void saveScore(Integer score, int index) {
        scoreTables.saveScore(score, index);
    }

    public void setCurrentSeriesScoreRow(int currentSeriesIndex) {
        scoreTables.setCurrentSeriesScoreRow(currentSeriesIndex);
    }
}
