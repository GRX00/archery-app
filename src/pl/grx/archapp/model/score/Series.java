package pl.grx.archapp.model.score;

import java.util.Arrays;
import java.util.Collections;

public class Series {
    private Integer[] series = new Integer[6];
    private Boolean sorted = true;
    private final int seriesIndex;

    public Series(int index) {
        seriesIndex = index;
    }

    public int getSeriesIndex() {
        return seriesIndex;
    }

    public void put(Integer value, int index) {
        series[index] = value;
        sorted = false;
    }

    public Integer getScore(int index) {
        if (!sorted) {
            sort();
        }
        return series[index];
    }

    private void sort() {

        for (int i = 0; i < 6; i++) {
            if (series[i] == null)
                series[i] = -1;
        }

        Arrays.sort(series, Collections.reverseOrder());

        for (int i = 0; i < 6; i++) {
            if (series[i] == -1)
                series[i] = null;
        }

        sorted = true;
    }

    public Integer getFirstRowSum() {
        return getSum(0,3);
    }

    public Integer getSecondRowSum() {
        return getSum(3,6);
    }

    public Integer getSeriesSum() {
        return getSum(0,6);
    }

    private Integer getSum(int indexFrom, int indexTo) {
        int sum = 0;
        for (int i = indexFrom; i < indexTo; i++) {
            if (series[i] != null) {
                switch (series[i]) {
                    case 11: sum+=10;
                        break;
                    default: sum += series[i];
                        break;
                }

            }
        }
        return sum;
    }
}
