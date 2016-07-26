package pl.grx.archapp.model.score;

import pl.grx.archapp.model.Range;

import java.util.Date;

public class ScoreTable {
    private Series[] series;
    private Series currentSeries;
    private Date date;

    public ScoreTable(Range range) {
        this.date = range.getDate();
        series = new Series[range.getSeriesCount()];
        for (int i = 0; i < range.getSeriesCount(); i++) {
            series[i]=new Series(i);
        }
        currentSeries = series[0];
    }

    public int getAccumulatedSeriesSum(int tillSeries) {
        int sum = 0;
        for (int i = 0; i < tillSeries; i++) {
            sum += series[i].getSeriesSum();
        }
        return sum;
    }

    public void setCurrentSeries(int seriesIndex) {
        currentSeries = series[seriesIndex];
    }

    public int getCurrentSeriesIndex() {
        return currentSeries.getSeriesIndex();
    }

    public int getSeriesCount() {
        return this.series.length;
    }

    public void saveScore(Integer score, int index) {
        currentSeries.put(score, index);
    }

    public Date getDate() {
        return date;
    }

    public Integer getScoreForSeriesForPosition(int series, int position) {
        return getSeries(series).getScore(position-1);
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

    private Series getSeries(int seriesNr) {
        assert(seriesNr > 0 && seriesNr <= this.series.length);
        return this.series[seriesNr - 1];
    }

    public Integer getAccumulatedSum() {
        return getAccumulatedSeriesSum(series.length);
    }
}
