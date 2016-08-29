package pl.grx.archapp.servlets.score;

import pl.grx.archapp.Score;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ScoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getSession().getServletContext();

        Score score = (Score) servletContext.getAttribute("score");
        score.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getSession().getServletContext();

        Score score = (Score) servletContext.getAttribute("score");
        score.doPost(request, response);
    }
}
