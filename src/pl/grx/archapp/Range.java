package pl.grx.archapp;

public class Range {
    private String description;
    private int Series;
    private ArrowsInSeries arrowsInSeries;

    private enum ArrowsInSeries {
        THREE(3),
        SIX(6);

        private final int arrowsNr;
        ArrowsInSeries(int i) {
            arrowsNr = i;
        }
    };
}
