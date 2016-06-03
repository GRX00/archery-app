package pl.grx.archapp.servlets;

import pl.grx.archapp.CompetitionSingleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {
    private CompetitionSingleton competitionSingleton;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (CompetitionSingleton.isFirstRun()) {
            request.getRequestDispatcher("/admin").forward(request, response);
        } else {
            competitionSingleton = CompetitionSingleton.getInstance();

            request.setAttribute("competition", competitionSingleton);
            request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
        }
    }
}

