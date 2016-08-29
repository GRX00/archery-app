package pl.grx.archapp;

import pl.grx.archapp.model.counter.CounterData;
import pl.grx.archapp.model.counter.CounterState;
import pl.grx.archapp.model.RangesControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Counter {

    private final CounterState counterState;
    private final RangesControl rangesControl;

    public Counter(RangesControl rangesControl, CounterState counterState) {
        this.rangesControl = rangesControl;
        this.counterState = counterState;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/jsp/counter.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CounterData counterData = rangesControl.getCurrentCounterData();
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
                    .append("\"seriesTimeSec\":").append(counterData.getSeriesTime()).append(",")
                    .append("\"prepareTimeSec\":").append(counterData.getPrepareTime()).append(",")
                    .append("\"yellowTimeSec\":").append(counterData.getYellowTime()).append(",")
                    .append("\"redTimeSec\":").append(counterData.getRedTime()).append(",")
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
