package pl.grx.archapp.model;

public class Mat {
    private Participant[] participantOnPosition = new Participant[4];

    public void setParticipant(int positionIndex, Participant participant) {
        assert (positionIndex >= 0 && positionIndex < 4);
        participantOnPosition[positionIndex] = participant;
    }

    public String getParticipant(int positionIndex) {
        assert (positionIndex >= 0 && positionIndex < 4);
        Participant participant = participantOnPosition[positionIndex];
        if (participant == null) {
            return null;
        } else {
            return participant.getName();
        }
    }
}
