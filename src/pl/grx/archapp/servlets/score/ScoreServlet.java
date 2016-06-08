package pl.grx.archapp.servlets.score;

import pl.grx.archapp.CompetitionSingleton;
import pl.grx.archapp.model.Mat;
import pl.grx.archapp.model.Participant;

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
            CompetitionSingleton competition = CompetitionSingleton.getInstance();
            Mat mat = competition.getMat(matNr-1);
            address = request.getContextPath()+"/WEB-INF/jsp/score/score.jsp";
            request.setAttribute("participantId1", mat.getParticipantIdOnPosition(1));
            request.setAttribute("participantId2", mat.getParticipantIdOnPosition(2));
            request.setAttribute("participantId3", mat.getParticipantIdOnPosition(3));
            request.setAttribute("participantId4", mat.getParticipantIdOnPosition(4));
            request.setAttribute("m", String.valueOf(matNr));
        }

        request.getRequestDispatcher(address).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = 0;
        String matQuery = "";
        Enumeration parameters = request.getParameterNames();

        CompetitionSingleton competition = CompetitionSingleton.getInstance();

        while (parameters.hasMoreElements()) {
            String parameter = parameters.nextElement().toString();
            String parameterValue = request.getParameter(parameter);

            if (parameter.equals("m")) {
                matQuery = "?m="+request.getParameter("m");
                continue;
            }

            String participantId = extractParticipantId(parameter);
            Participant participant = competition.getParticipant(participantId);
            assert(participant!=null);
            try {
                Integer score = Integer.parseInt(parameterValue);
                participant.saveScore(score, index);
            } catch (NumberFormatException ignored) {
                participant.saveScore(null, index);
            }

            index++;
        }

        response.sendRedirect(request.getContextPath()+"/score"+matQuery);
    }

    private String extractParticipantId(String parameter) {
        return parameter.substring(parameter.indexOf(':'));
    }
}
