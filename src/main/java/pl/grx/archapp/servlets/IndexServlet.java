package pl.grx.archapp.servlets;

import pl.grx.archapp.Index;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getSession().getServletContext();

        Index index = (Index) servletContext.getAttribute("index");
        index.doGet(request, response);
    }
}

