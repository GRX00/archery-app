package pl.grx.archapp.servlets.score;

import pl.grx.archapp.Competition;
import pl.grx.archapp.model.Mat;
import pl.grx.archapp.model.Participant;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ScoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address;
        Integer matNr = null;

        try {
            matNr = Integer.valueOf(request.getParameter("m"));
        } catch (NumberFormatException ignore) { }

        if (matNr == null) {
            address = request.getContextPath()+"/index";
        } else {
            ServletContext servletContext = request.getSession().getServletContext();
            Competition competition = (Competition) servletContext.getAttribute("competition");

            Mat mat = competition.getMat(matNr-1);
            address = request.getContextPath()+"/WEB-INF/jsp/score/score.jsp";
            request.setAttribute("participantNameA", mat.getParticipant(0));
            request.setAttribute("participantNameB", mat.getParticipant(1));
            request.setAttribute("participantNameC", mat.getParticipant(2));
            request.setAttribute("participantNameD", mat.getParticipant(3));
            request.setAttribute("m", String.valueOf(matNr));
        }

        request.getRequestDispatcher(address).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matQuery = "";
        Enumeration parameters = request.getParameterNames();

        ServletContext servletContext = request.getSession().getServletContext();
        Competition competition = (Competition) servletContext.getAttribute("competition");

        while (parameters.hasMoreElements()) {
            String parameter = parameters.nextElement().toString();
            String parameterValue = request.getParameter(parameter);

            if (parameter.equals("m")) {
                matQuery = "?m="+request.getParameter("m");
                continue;
            }

            String participantName = extractParticipantName(parameter);
            Integer index = extractScoreIndex(parameter);
            Participant participant = competition.getParticipant(participantName);
            assert(participant!=null);
            try {
                Integer score = Integer.parseInt(parameterValue);
                participant.saveScore(score, index);
            } catch (NumberFormatException ignored) {
                participant.saveScore(null, index);
            }
        }

        response.sendRedirect(request.getContextPath()+"/score"+matQuery);
    }

    private Integer extractScoreIndex(String parameter) {
        int percentPos = parameter.indexOf('%')+1;
        int colonPos = parameter.indexOf(':');
        return Integer.parseInt(parameter.substring(percentPos, colonPos)) - 1;
    }

    private String extractParticipantName(String parameter) {
        int colonPos = parameter.indexOf(':')+1;
        return parameter.substring(colonPos);
    }
}
