package pl.grx.archapp.model;

public enum SeriesSequence {
    A(new int[]{1}, "A"),
    ABAB(new int[]{1, 2}, "AB/AB"),
    ABBA(new int[]{1, 2, 2, 1}, "AB/BA"),
    ABC(new int[]{1, 2, 3}, "ABC");


    private final int[] sequence;
    private String description;

    SeriesSequence(int[] sequence, String description) {
        this.sequence = sequence;
        this.description = description;
    }

    public int[] getValue() {
        return sequence;
    }

    public String getDescription() {
        return description;
    }
}
