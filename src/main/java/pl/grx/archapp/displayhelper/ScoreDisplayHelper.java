package pl.grx.archapp.displayhelper;

import pl.grx.archapp.model.score.ScoreTable;

import java.text.Format;
import java.text.SimpleDateFormat;

public class ScoreDisplayHelper {
    private final ScoreTable scoreTable;

    public ScoreDisplayHelper(ScoreTable scoreTable) {
        this.scoreTable = scoreTable;
    }

    public String getDate() {
        Format formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(scoreTable.getDate());
    }

    public int getSeriesCount() {
        return scoreTable.getSeriesCount();
    }

    public String getScoreForSeriesForPosition(int series, int position) {
        Integer result = scoreTable.getScoreForSeriesForPosition(series, position);
        if (result == null) {
            return "";
        } else {
            if (series == getCurrentSeriesNr()) {
                return String.valueOf(result);
            }
            switch (result) {
                case 11: return "X";
                default: return String.valueOf(result);
            }
        }
    }

    public String getFirstRowSumForSeries(int series) {
        Integer result = scoreTable.getFirstRowSumForSeries(series);
        return handleVisibility(result, series);
    }

    public String getSecondRowSumForSeries(int series) {
        Integer result = scoreTable.getSecondRowSumForSeries(series);
        return handleVisibility(result, series);
    }

    public String getSumForSeries(int series) {
        Integer result = scoreTable.getSumForSeries(series);
        return handleVisibility(result, series);
    }

    public String getAccumulatedSumForSeries(int series) {
        Integer result = scoreTable.getAccumulatedSeriesSum(series);
        return handleVisibility(result, series);
    }

    public String getAccumulatedSum() {
        return String.valueOf(scoreTable.getAccumulatedSum());
    }

    public boolean isCurrentSeriesProcessed(int series) {
        return getCurrentSeriesNr() == series;
    }

    private String handleVisibility(Integer result, int series) {
        if (series <= getCurrentSeriesNr()) {
            return String.valueOf(result);
        } else {
            return "";
        }
    }

    private int getCurrentSeriesNr() {
        return scoreTable.getCurrentSeriesIndex() + 1;
    }
}
