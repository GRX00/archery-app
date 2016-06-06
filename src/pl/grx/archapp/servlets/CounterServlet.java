package pl.grx.archapp.servlets;

import pl.grx.archapp.CompetitionSingleton;
import pl.grx.archapp.model.Counter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/jsp/counter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CompetitionSingleton competition = CompetitionSingleton.getInstance();
        Counter counter = competition.getCurrentRangeCounter();
        String responseData = "";

        if (request.getParameter("checkControl") != null) {
            Boolean counting = request.getParameter("counting") != null;
            if (!competition.isSeriesReady()) {
                responseData = "reset";
            } else if (competition.isSeriesStarted() && !competition.isSeriesFinished() && !counting) {
                responseData = "start";
            } else if (competition.isSeriesStarted() && competition.isSeriesFinished() && counting) {
                responseData = "stop";
            }
        } else if (request.getParameter("getTimerValues") != null) {
            StringBuilder stringBuilder = new StringBuilder();
            responseData = stringBuilder.append("{")
                    .append("\"seriesTimeSec\":").append(counter.getSeriesTimeSec()).append(",")
                    .append("\"prepareTimeSec\":").append(counter.getPrepareTimeSec()).append(",")
                    .append("\"yellowTimeSec\":").append(counter.getYellowTimeSec()).append(",")
                    .append("\"redTimeSec\":").append(counter.getRedTimeSec())
                    .append("}")
                    .toString();
        } else if (request.getParameter("finished") != null) {
            competition.finishSeries();
        } else if (request.getParameter("resetDone") != null) {
            competition.seriesReady();
        }

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseData);
    }
}
