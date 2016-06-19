package pl.grx.archapp.controller;

import pl.grx.archapp.CompetitionSingleton;
import pl.grx.archapp.model.Participant;
import pl.grx.archapp.model.score.ScoreTable;

import java.text.Format;
import java.text.SimpleDateFormat;

public class ParticipantScoreDisplay {
    private CompetitionSingleton competition = CompetitionSingleton.getInstance();
    private final Participant participant;
    private final ScoreTable currentRangeScoreTable;

    public ParticipantScoreDisplay(String participantName) {
        participant = competition.getParticipant(participantName);
        currentRangeScoreTable = participant.getCurrentRangeScoreTable();
    }

    public String getDate() {
        Format formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(currentRangeScoreTable.getDate());
    }

    public String getScoreForSeriesForPosition(int series, int position) {
        Integer result = currentRangeScoreTable.getScoreForSeriesForPosition(series, position);
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
        Integer result = currentRangeScoreTable.getFirstRowSumForSeries(series);
        return handleVisibility(result, series);
    }

    public String getSecondRowSumForSeries(int series) {
        Integer result = currentRangeScoreTable.getSecondRowSumForSeries(series);
        return handleVisibility(result, series);
    }

    public String getSumForSeries(int series) {
        Integer result = currentRangeScoreTable.getSumForSeries(series);
        return handleVisibility(result, series);
    }

    public String getAccumulatedSumForSeries(int series) {
        Integer result = currentRangeScoreTable.getAccumulatedSeriesSum(series);
        return handleVisibility(result, series);
    }

    public int getCurrentSeriesNr() {
        return currentRangeScoreTable.getCurrentSeriesIndex() + 1;
    }

    public int getSeriesCount() {
        return currentRangeScoreTable.getSeriesCount();
    }

    private String handleVisibility(Integer result, int series) {
        if (series <= getCurrentSeriesNr()) {
            return String.valueOf(result);
        } else {
            return "";
        }
    }

    public String getAccumulatedSum() {
        return String.valueOf(currentRangeScoreTable.getAccumulatedSum());
    }
}
