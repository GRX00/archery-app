package pl.grx.archapp;

import java.util.Date;

public class Range {
    private String description;
    private int Series;
    private ArrowsInSeries arrowsInSeries;
    private Date date;

    public Range(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    private enum ArrowsInSeries {
        THREE(3),
        SIX(6);

        private final int arrowsNr;
        ArrowsInSeries(int i) {
            arrowsNr = i;
        }
    };
}
