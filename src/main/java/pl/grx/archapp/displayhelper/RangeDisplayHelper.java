package pl.grx.archapp.displayhelper;

import pl.grx.archapp.model.counter.CounterData;
import pl.grx.archapp.model.Range;
import pl.grx.archapp.model.enums.SeriesArrows;

import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RangeDisplayHelper {

    private final Range range;

    public RangeDisplayHelper(Range range) {
        this.range = range;
    }

    public CounterData getCounterData() {
        return range.getCounterData();
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

    public String isSelectedSeriesArrows(SeriesArrows seriesArrows) {
        if (range.getArrowsInSeries() == seriesArrows.getValue()) {
            return "selected";
        } else {
            return "";
        }
    }

    public void setDate(String date) throws IOException {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            range.setDate(format.parse(date));
        } catch (ParseException ex) {
            throw new IOException(ex);
        }
    }

    public void setDescription(String description) {
        range.setDescription(description);
    }

    public void setSeriesCount(String seriesCount) {
        range.setSeriesCount(Integer.valueOf(seriesCount));
    }

    public void setArrowsInSeries(String arrowsInSeries) {
        range.setArrowsInSeries(Integer.valueOf(arrowsInSeries));
    }
}
