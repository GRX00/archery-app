package pl.grx.archapp.servlets.score;

import pl.grx.archapp.score.ScoreTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

public class ScoreServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger("ScoreServlet");
    private static ScoreTable scoreTable = new ScoreTable();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        logger.info("doGet triggered");
        String address;

        if (request.getParameter("m") == null) {
            address = "/index";
        } else {
            address = "/WEB-INF/jsp/score/score.jsp";
            request.setAttribute("scoreTable", scoreTable);
        }

        request.getRequestDispatcher(address).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        logger.info("doPost triggered");

        int index = 1;
        Enumeration parameters = request.getParameterNames();

        while (parameters.hasMoreElements()) {
            String parameter = parameters.nextElement().toString();
            String parameterValue = request.getParameter(parameter);
//            logger.info("element: " + parameter + " value: " + parameterValue);

            try {
                Integer score = Integer.parseInt(parameterValue);
                scoreTable.getCurrentSeries().put(score, index);
            } catch (NumberFormatException ignored) {
                scoreTable.getCurrentSeries().put(null, index);
            }

            index++;
        }

        response.sendRedirect(request.getContextPath()+"/scoreTable?m=1");
    }
}
