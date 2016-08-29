package pl.grx.archapp.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum SeriesArrows {
    THREE(3, "3 strzały"),
    SIX(6, "6 strzał");

    private final int arrowsCount;
    private String description;

    SeriesArrows(int arrowsCount, String description) {
        this.arrowsCount = arrowsCount;
        this.description = description;
    }

    public int getValue() {
        return arrowsCount;
    }

    public String getDescription() {
        return description;
    }

    private static final Map<Integer,SeriesArrows> map;
    static {
        map = new HashMap<Integer,SeriesArrows>();
        for (SeriesArrows v : SeriesArrows.values()) {
            map.put(v.getValue(), v);
        }
    }
    public static SeriesArrows findByKey(int arrowsCount) {
        return map.get(arrowsCount);
    }
};