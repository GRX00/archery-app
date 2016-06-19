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
        return String.valueOf(currentRangeScoreTable.getScoreForSeriesForPosition(series, position));

    }

    public String getFirstRowSumForSeries(int series) {
        return String.valueOf(currentRangeScoreTable.getFirstRowSumForSeries(series));
    }

    public String getSecondRowSumForSeries(int series) {
        return String.valueOf(currentRangeScoreTable.getSecondRowSumForSeries(series));
    }

    public String getSumForSeries(int series) {
        return String.valueOf(currentRangeScoreTable.getSumForSeries(series));
    }

    public String getAccumulatedSumForSeries(int series) {
        return String.valueOf(currentRangeScoreTable.getAccumulatedSeriesSum(series));
    }

    public int getCurrentSeriesNr() {
        return currentRangeScoreTable.getCurrentSeriesIndex() + 1;
    }

    public int getSeriesCount() {
        return currentRangeScoreTable.getSeriesCount();
    }
}
