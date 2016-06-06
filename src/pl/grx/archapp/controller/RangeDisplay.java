package pl.grx.archapp.controller;

import pl.grx.archapp.CompetitionSingleton;
import pl.grx.archapp.model.ArrowsInSeries;
import pl.grx.archapp.model.Counter;
import pl.grx.archapp.model.Range;

import java.text.Format;
import java.text.SimpleDateFormat;

public class RangeDisplay {

    private final Range range;
    private final Counter counter;

    public RangeDisplay(int rangeNr) {
        CompetitionSingleton competition = CompetitionSingleton.getInstance();
        range = competition.getRange(rangeNr - 1);
        counter = range.getCounter();
    }

    public String getDate() {
        Format formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(range.getDate());
    }

    public String getDescription() {
        return range.getDescription();
    }

    public String getSeriesCount() {
        return String.valueOf(range.getSeriesCount());
    }

    public String isSelectedArrowsInSeries(ArrowsInSeries arrowsInSeries) {
        if (range.getArrowsInSeries() == arrowsInSeries) {
            return "selected";
        } else {
            return "";
        }
    }
}
