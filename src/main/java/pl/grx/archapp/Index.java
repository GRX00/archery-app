package pl.grx.archapp;

import pl.grx.archapp.model.Mats;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Index {

    private final Mats mats;

    private boolean configured = false;

    public Index(Mats mats) {
        this.mats = mats;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!configured) {
            setConfigured();
            request.getRequestDispatcher(request.getContextPath() + "/admin").forward(request, response);
        } else {
            request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/jsp/index.jsp").forward(request, response);
        }
    }

    public void setConfigured() {
        configured = true;
    }

    public int getMatsCount() {
        return mats.getMatsCount();
    }
}
