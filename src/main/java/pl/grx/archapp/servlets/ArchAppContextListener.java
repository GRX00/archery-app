package pl.grx.archapp.servlets;

import pl.grx.archapp.Competition;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ArchAppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("competition", new Competition());
        servletContext.setAttribute("configured", false);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
