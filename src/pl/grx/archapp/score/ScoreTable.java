package pl.grx.archapp.score;

import pl.grx.archapp.Range;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreTable {
    private List<Series> series = new ArrayList<>();
    private Series currentSeries;
    private Date date;

    public ScoreTable(Range range) {
        this.date = range.getDate();
    }

    public int getAccumulatedSeriesSum(int tillSeries) {
        int sum = 0;
        for (int i = 0; i < tillSeries-1; i++) {
            sum += series.get(i).getSeriesSum();
        }
        return sum;
    }

    public void setCurrentSeries(int seriesIndex) {
        currentSeries = series.get(seriesIndex);
    }

    public void saveScore(Integer score, int index) {
        currentSeries.put(score, index);
    }

    public Date getDate() {
        return date;
    }

    public Integer getScoreForSeriesForPosition(int series, int position) {
        return getSeries(series).getScore(position);
    }

    public Integer getFirstRowSumForSeries(int series) {
        return getSeries(series).getFirstRowSum();
    }

    public Integer getSecondRowSumForSeries(int series) {
        return getSeries(series).getSecondRowSum();
    }

    public Integer getSumForSeries(int series) {
        return getSeries(series).getSeriesSum();
    }

    private Series getSeries(int series) {
        assert(series > 0 && series <= this.series.size());
        return this.series.get(series - 1);
    }
}
