package pl.grx.archapp.controller;

import pl.grx.archapp.Competition;
import pl.grx.archapp.model.CounterData;
import pl.grx.archapp.model.Range;
import pl.grx.archapp.model.SeriesArrows;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RangeDisplay {

    private final Range range;

    public RangeDisplay(HttpServletRequest request, int rangeNr) {
        ServletContext servletContext = request.getSession().getServletContext();
        Competition competition = (Competition) servletContext.getAttribute("competition");
        range = competition.getRange(rangeNr - 1);
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
