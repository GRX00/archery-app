package pl.grx.archapp.model;

import pl.grx.archapp.factories.CompetitionFactory;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    private final CompetitionFactory competitionFactory;
    private List<Participant> participants = new ArrayList<>();

    public Participants(CompetitionFactory competitionFactory) {
        this.competitionFactory = competitionFactory;
    }

    public Participant getParticipant(int matIndex, int positionIndex) {
        // loop through participants and get one with given indexes

        return participants.get(0);
    }

    public String getParticipantName(int matIndex, int positionIndex) {
        return getParticipant(matIndex, positionIndex).getName();
    }

    public List<String> getParticipantsNames() {
        List<String> participantNames = new ArrayList<>();
        for (Participant participant : participants) {
            participantNames.add(participant.getName());
        }
        return participantNames;
    }

    public Participant getParticipantByName(String name) {
        for (Participant participant : participants) {
            if (participant.nameEquals(name)) {
                return participant;
            }
        }
        return null;
    }

    public void setParticipantsCurrentRangeSeries(int currentRangeIndex, int currentSeriesIndex) {
        for (Participant participant : participants) {
            participant.setCurrentRangeScoreTable(currentRangeIndex);
            participant.setCurrentSeriesScoreRow(currentSeriesIndex);
        }
    }

    public void setParticipant(int matIndex, int positionIndex, String name) {
        if (!name.equals("")) {
            Participant participant = findParticipant(name);
            if (participant == null) {
                participant = createParticipant(name);
            }
            participant.setPosition(matIndex, positionIndex);
        }
    }

    private Participant findParticipant(String name) {
        for (Participant participant : participants) {
            if (participant.getName().equalsIgnoreCase(name)) {
                return participant;
            }
        }
        return null;
    }

    private Participant createParticipant(String name) {
        Participant participant = competitionFactory.buildParticipant(name);
        participants.add(participant);
        return participant;
    }

    //    public void setupParticipants() {
//        for (Participant participant : participants) {
//            participant.setScoreTables(ranges, currentRangeIndex);
//        }
//    }
}
