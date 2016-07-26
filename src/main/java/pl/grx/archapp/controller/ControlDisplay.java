package pl.grx.archapp.controller;

import pl.grx.archapp.CompetitionSingleton;

public class ControlDisplay {
    CompetitionSingleton competition = CompetitionSingleton.getInstance();

    public String getCurrentRange() {
        return String.valueOf(competition.getCurrentRangeIndex() + 1);
    }

    public String getCurrentSeries() {
        return String.valueOf(competition.getCurrentSeriesIndex() + 1);
    }
}
