package pl.grx.archapp.servlets;

import pl.grx.archapp.Counter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getSession().getServletContext();

        Counter counter = (Counter) servletContext.getAttribute("counter");
        counter.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getSession().getServletContext();

        Counter counter = (Counter) servletContext.getAttribute("counter");
        counter.doPost(request, response);
    }
}
