package pl.grx.archapp.controller;

import pl.grx.archapp.CompetitionSingleton;

public class CompetitionDisplay {
    private CompetitionSingleton competition = CompetitionSingleton.getInstance();

    public String getRangesCount() {
        return String.valueOf(competition.getRangesSize());
    }

    public String getMatsCount() {
        return String.valueOf(competition.getMatsSize());
    }
}
