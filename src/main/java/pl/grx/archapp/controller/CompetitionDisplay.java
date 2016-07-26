package pl.grx.archapp.controller;

import pl.grx.archapp.CompetitionSingleton;

public class CompetitionDisplay {
    private CompetitionSingleton competition = CompetitionSingleton.getInstance();

    public String getRangesCount() {
        return String.valueOf(competition.getRangesSize());
    }

    public int getRangesCountNr() {
        return competition.getRangesSize();
    }

    public String getMatsCount() {
        return String.valueOf(competition.getMatsSize());
    }

    public int getMatsCountNr() {
        return competition.getMatsSize();
    }

    public void setRangesCount(String rangesCount) {
        competition.setRangesCount(Integer.valueOf(rangesCount));
    }

    public void setMatsCount(String matsCount) {
        competition.setMatsCount(Integer.valueOf(matsCount));
    }

    public String getParticipantName(int matNr, int index) {
        String participantName = competition.getParticipant(matNr - 1, index);
        if (participantName == null) {
            return "";
        } else {
            return participantName;
        }
    }

    public String getParticipantsJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");
        for (String participantName : competition.getParticipantsNames()) {
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
        competition.setParticipant(matNr - 1, positionIndex, name.trim());
    }

    public void setupParticipants() {
        competition.setupParticipants();
    }

    public String[] getParticipantsNames() {
        return competition.getParticipantsNames().toArray(new String[0]);
    }
}
