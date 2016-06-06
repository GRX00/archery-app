package pl.grx.archapp.model;

public enum ArrowsInSeries {
    THREE(3, "3 strzały"),
    SIX(6, "6 strzał");

    private final int arrowsCount;
    private String description;

    ArrowsInSeries(int arrowsCount, String description) {
        this.arrowsCount = arrowsCount;
        this.description = description;
    }

    public int getValue() {
        return arrowsCount;
    }

    public String getDescription() {
        return description;
    }
};