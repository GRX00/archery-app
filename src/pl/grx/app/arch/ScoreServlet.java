package pl.grx.app.arch;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class ScoreServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger("ScoreServlet");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doGet triggered");

        request.getRequestDispatcher("/WEB-INF/jsp/score.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost triggered");

        request.getRequestDispatcher("/WEB-INF/jsp/score.jsp").forward(request, response);
    }
}
