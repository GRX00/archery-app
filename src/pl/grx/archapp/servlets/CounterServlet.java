package pl.grx.archapp.servlets;

import pl.grx.archapp.CompetitionSingleton;
import pl.grx.archapp.controller.CounterState;
import pl.grx.archapp.model.CounterData;

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
        CounterData counterData = competition.getCurrentRangeCounterData();
        CounterState counterState = competition.getCounterState();
        String responseData = "ready";

        if (request.getParameter("checkControl") != null) {
            int counter = Integer.valueOf(request.getParameter("counter"));
            if (counterState.isCounterStarted()) {
                counterState.setCounter(counter);
                if (counterState.isCounterFinished()) {
                    responseData = "stop";
                } else {
                    responseData = "start";
                }
            }
        } else if (request.getParameter("getTimerValues") != null) {
            StringBuilder stringBuilder = new StringBuilder();
            responseData = stringBuilder.append("{")
                    .append("\"seriesTimeSec\":").append(counterData.getSeriesTimeSec()).append(",")
                    .append("\"prepareTimeSec\":").append(counterData.getPrepareTimeSec()).append(",")
                    .append("\"yellowTimeSec\":").append(counterData.getYellowTimeSec()).append(",")
                    .append("\"redTimeSec\":").append(counterData.getRedTimeSec()).append(",")
                    .append("\"currentCounter\":").append(counterState.getCounter())
                    .append("}")
                    .toString();
        } else if (request.getParameter("finished") != null) {
            counterState.finishCounter();
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseData);
    }
}
