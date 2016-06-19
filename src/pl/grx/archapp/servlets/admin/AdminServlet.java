package pl.grx.archapp.servlets.admin;

import pl.grx.archapp.CompetitionSingleton;
import pl.grx.archapp.controller.CompetitionDisplay;
import pl.grx.archapp.controller.CounterDataDisplay;
import pl.grx.archapp.controller.RangeDisplay;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class AdminServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger("AdminServlet");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CompetitionSingleton competition = CompetitionSingleton.getInstance();

        request.getRequestDispatcher(request.getContextPath()+"/WEB-INF/jsp/admin/administration.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CompetitionDisplay competitionDisplay = new CompetitionDisplay();

        for (int rangeNr = 1; rangeNr <= competitionDisplay.getRangesCountNr(); rangeNr++) {
            RangeDisplay rangeDisplay = new RangeDisplay(rangeNr);
            CounterDataDisplay counterDisplay = new CounterDataDisplay(rangeDisplay);
            String paramName = String.valueOf(rangeNr) + ':';

            rangeDisplay.setDate(request.getParameter(paramName.concat("date")));
            rangeDisplay.setDescription(request.getParameter(paramName.concat("rangeDescription")));
            rangeDisplay.setSeriesCount(request.getParameter(paramName.concat("seriesCount")));
            rangeDisplay.setArrowsInSeries(request.getParameter(paramName.concat("seriesArrows")));
            counterDisplay.setSeriesTime(
                    request.getParameter(paramName.concat("seriesTimeMinutes")),
                    request.getParameter(paramName.concat("seriesTimeSeconds")));
            counterDisplay.setPrepareTime(
                    request.getParameter(paramName.concat("prepareTimeMinutes")),
                    request.getParameter(paramName.concat("prepareTimeSeconds")));
            counterDisplay.setYellowTime(
                    request.getParameter(paramName.concat("yellowTimeMinutes")),
                    request.getParameter(paramName.concat("yellowTimeSeconds")));
            counterDisplay.setRedTime(
                    request.getParameter(paramName.concat("redTimeMinutes")),
                    request.getParameter(paramName.concat("redTimeSeconds")));
            counterDisplay.setSequence(request.getParameter(paramName.concat("seriesSequence")));
        }

        for (int matNr = 1; matNr <= competitionDisplay.getMatsCountNr(); matNr++) {
            String paramName = String.valueOf(matNr) + ":name";

            competitionDisplay.setParticipantPosition(matNr, 0,
                    request.getParameter(paramName.concat("A")));
            competitionDisplay.setParticipantPosition(matNr, 1,
                    request.getParameter(paramName.concat("B")));
            competitionDisplay.setParticipantPosition(matNr, 2,
                    request.getParameter(paramName.concat("C")));
            competitionDisplay.setParticipantPosition(matNr, 3,
                    request.getParameter(paramName.concat("D")));
        }

        competitionDisplay.setupParticipants();

        competitionDisplay.setRangesCount(request.getParameter("rangesNr"));

        competitionDisplay.setMatsCount(request.getParameter("matsNr"));

        request.getRequestDispatcher(request.getContextPath()+"/WEB-INF/jsp/admin/administration.jsp")
                .forward(request, response);
    }
}
