package pl.grx.archapp.model.score;

public class SeriesSettings {
    private int seriesCount;
    private int arrowsInSeries;

    public SeriesSettings(int seriesCount, int arrowsInSeries) {
        this.seriesCount = seriesCount;
        this.arrowsInSeries = arrowsInSeries;
    }

    public int getSeriesCount() {
        return seriesCount;
    }

    public int getArrowsInSeries() {
        return arrowsInSeries;
    }

    public void setSeriesCount(Integer seriesCount) {
        this.seriesCount = seriesCount;
    }

    public void setArrowsInSeries(Integer arrowsInSeries) {
        this.arrowsInSeries = arrowsInSeries;
    }
}
