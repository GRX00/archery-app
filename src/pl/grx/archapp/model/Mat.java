package pl.grx.archapp.model;

public class Mat {
    private String[] participantsPositions = new String[4];

    public void setParticipant(Participant participant, int position) {
        assert (position > 0 && position < 5);
        participantsPositions[position-1] = participant.getId();
    }

    public String getParticipantIdOnPosition(int position) {
        assert (position > 0 && position < 5);
        return participantsPositions[position-1];
    }
}
