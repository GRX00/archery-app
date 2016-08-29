package pl.grx.archapp.model.score;

import pl.grx.archapp.model.Range;

import java.util.ArrayList;
import java.util.List;

public class ScoreTables {
    private List<ScoreTable> scoreTables = new ArrayList<>();
    private ScoreTable currentRangeScoreTable;

    public void setScoreTables(List<Range> ranges, int currentRangeIndex) {
        removeRedundantScoreTables(ranges, currentRangeIndex);
        addMissingScoreTables(ranges);
        this.currentRangeScoreTable = scoreTables.get(currentRangeIndex);
    }

    public void setCurrentRangeScoreTable(int currentRangeIndex) {
        this.currentRangeScoreTable = scoreTables.get(currentRangeIndex);
        currentRangeScoreTable.setCurrentSeries(0);
    }

    public ScoreTable getCurrentRangeScoreTable() {
        return currentRangeScoreTable;
    }

    public void saveScore(Integer score, int index) {
        currentRangeScoreTable.saveScore(score, index);
    }

    private void removeRedundantScoreTables(List<Range> ranges, int currentRangeIndex) {
        while (this.scoreTables.size() > ranges.size() && this.scoreTables.size() > (currentRangeIndex + 1)) {
            this.scoreTables.remove(this.scoreTables.size() - 1);
        }
    }

    private void addMissingScoreTables(List<Range> ranges) {
        for (int i = this.scoreTables.size(); i < ranges.size(); i++) {
            this.scoreTables.add(new ScoreTable(ranges.get(i)));
        }
    }

    public void setCurrentSeriesScoreRow(int currentSeriesIndex) {
        this.currentRangeScoreTable.setCurrentSeries(currentSeriesIndex);
    }
}
