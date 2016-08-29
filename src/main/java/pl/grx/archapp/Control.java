package pl.grx.archapp;

import pl.grx.archapp.displayhelper.ControlDisplayHelper;
import pl.grx.archapp.factories.DisplayHelperFactory;
import pl.grx.archapp.model.RangesControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Control {

    private final DisplayHelperFactory displayHelperFactory;
    private final RangesControl rangesControl;

    public Control(DisplayHelperFactory displayHelperFactory, RangesControl rangesControl) {
        this.displayHelperFactory = displayHelperFactory;
        this.rangesControl = rangesControl;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/jsp/admin/control.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("command").equals("start")) {
            rangesControl.startSeries();
        } else if (request.getParameter("command").equals("stop")) {
            rangesControl.finishSeries();
        } else if (request.getParameter("command").equals("reset")) {
            rangesControl.resetSeries();
        } else if (request.getParameter("command").equals("seriesNext")) {
            rangesControl.nextSeries();
        } else if (request.getParameter("command").equals("seriesPrevious")) {
            rangesControl.previousSeries();
        } else if (request.getParameter("command").equals("rangeNext")) {
            rangesControl.nextRange();
        } else if (request.getParameter("command").equals("rangePrevious")) {
            rangesControl.previousRange();
        }
        request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/jsp/admin/control.jsp").forward(request, response);
    }

    public ControlDisplayHelper getControlDisplayHelper() {
        return displayHelperFactory.buildControlDisplayHelper();
    }
}
