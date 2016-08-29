package pl.grx.archapp.servlets.admin;

import pl.grx.archapp.Control;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getSession().getServletContext();

        Control control = (Control) servletContext.getAttribute("admin");
        control.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getSession().getServletContext();

        Control control = (Control) servletContext.getAttribute("admin");
        control.doPost(request, response);
    }
}
