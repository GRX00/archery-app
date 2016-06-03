package pl.grx.archapp.score;

import pl.grx.archapp.CompetitionSingleton;
import pl.grx.archapp.Participant;

import java.text.Format;
import java.text.SimpleDateFormat;

public class ParticipantScoreDisplay {
    private CompetitionSingleton competition = CompetitionSingleton.getInstance();
    private final Participant participant;
    private final ScoreTable currentRangeScoreTable;

    public ParticipantScoreDisplay(String participantId) {
        participant = competition.getParticipant(participantId);
        currentRangeScoreTable = participant.getCurrentRangeScoreTable();
    }

    public String getDate() {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(currentRangeScoreTable.getDate());
    }

    public String getName() {
        return participant.getName();
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
}
