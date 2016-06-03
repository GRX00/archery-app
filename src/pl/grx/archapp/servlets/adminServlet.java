package pl.grx.archapp.servlets;

import pl.grx.archapp.CompetitionSingleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet {
    private CompetitionSingleton competitionSingleton;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        competitionSingleton = CompetitionSingleton.getInstance();

        request.getRequestDispatcher("/WEB-INF/jsp/administration/administration.jsp").forward(request, response);
    }
}
