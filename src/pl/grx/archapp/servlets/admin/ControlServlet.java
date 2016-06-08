package pl.grx.archapp.servlets.admin;

import pl.grx.archapp.CompetitionSingleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/jsp/admin/control.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CompetitionSingleton competition = CompetitionSingleton.getInstance();

        if (request.getParameter("command").equals("start")) {
            competition.startSeries();
        } else if (request.getParameter("command").equals("stop")) {
            competition.finishSeries();
        } else if (request.getParameter("command").equals("reset")) {
            competition.resetSeries();
        } else if (request.getParameter("command").equals("seriesNext")) {
            competition.nextSeries();
        } else if (request.getParameter("command").equals("seriesPrevious")) {
            competition.previousSeries();
        } else if (request.getParameter("command").equals("rangeNext")) {
            competition.nextRange();
        } else if (request.getParameter("command").equals("rangePrevious")) {
            competition.previousRange();
        }
        request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/jsp/admin/control.jsp").forward(request, response);
    }
}
