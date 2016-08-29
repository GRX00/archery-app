package pl.grx.archapp.displayhelper;

import pl.grx.archapp.model.Participants;

public class ParticipantsDisplayHelper {

    private final Participants participants;

    public ParticipantsDisplayHelper(Participants participants) {
        this.participants = participants;
    }

    public String getParticipantName(int matNr, int index) {
        String participantName = participants.getParticipant(matNr - 1, index).getName();
        if (participantName == null) {
            return "";
        } else {
            return participantName;
        }
    }

    public String getParticipantsJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");
        for (String participantName : participants.getParticipantsNames()) {
            jsonBuilder.append("{")
                    .append("\"name\":").append(participantName)
                    .append("},");
        }
        int lastComaPos = jsonBuilder.lastIndexOf(",");
        if (lastComaPos >= 0) {
            jsonBuilder.deleteCharAt(lastComaPos);
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }

    public void setParticipantPosition(int matNr, int positionIndex, String name) {
        participants.setParticipant(matNr - 1, positionIndex, name.trim());
    }

//    public void setupParticipants() {
//        participants.setupParticipants();
//    }

    public String[] getParticipantsNames() {
        return participants.getParticipantsNames().toArray(new String[0]);
    }
}
