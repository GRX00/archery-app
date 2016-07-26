package pl.grx.archapp.controller;

import pl.grx.archapp.Competition;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class ControlDisplay {
    private final Competition competition;

    public ControlDisplay(HttpServletRequest request) {
        ServletContext servletContext = request.getSession().getServletContext();
        this.competition = (Competition) servletContext.getAttribute("competition");
    }

    public String getCurrentRange() {
        return String.valueOf(competition.getCurrentRangeIndex() + 1);
    }

    public String getCurrentSeries() {
        return String.valueOf(competition.getCurrentSeriesIndex() + 1);
    }
}
