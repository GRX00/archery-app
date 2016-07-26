package pl.grx.archapp.servlets;

import pl.grx.archapp.CompetitionSingleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class IndexServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger("ScoreServlet");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        logger.info("doGet triggered");
        if (CompetitionSingleton.isFirstRun()) {
            request.getRequestDispatcher(request.getContextPath()+"/admin").forward(request, response);
        } else {
            CompetitionSingleton competition = CompetitionSingleton.getInstance();

            request.setAttribute("matsNr", competition.getMatsSize());
            request.getRequestDispatcher(request.getContextPath()+"/WEB-INF/jsp/index.jsp").forward(request, response);
        }
    }
}

