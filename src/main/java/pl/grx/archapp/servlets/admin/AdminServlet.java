package pl.grx.archapp.servlets.admin;

import pl.grx.archapp.Admin;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getSession().getServletContext();

        Admin admin = (Admin) servletContext.getAttribute("admin");
        admin.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getSession().getServletContext();

        Admin admin = (Admin) servletContext.getAttribute("admin");
        admin.doPost(request, response);
    }
}
