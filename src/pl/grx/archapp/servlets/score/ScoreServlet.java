package pl.grx.archapp.servlets.score;

import pl.grx.archapp.CompetitionSingleton;
import pl.grx.archapp.Mat;
import pl.grx.archapp.Participant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

public class ScoreServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger("ScoreServlet");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        logger.info("doGet triggered");
        String address;
        Integer matNr = null;

        try {
            matNr = Integer.valueOf(request.getParameter("m"));
        } catch (NumberFormatException ignore) { }

        if (matNr == null) {
            address = request.getContextPath()+"/index";
        } else {
            CompetitionSingleton competition = CompetitionSingleton.getInstance();
            Mat mat = competition.getMat(matNr);
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
//        logger.info("doPost triggered");

        int index = 1;
        String matQuery = "";
        Enumeration parameters = request.getParameterNames();

        String participantId = request.getParameter("participantId");
        CompetitionSingleton competition = CompetitionSingleton.getInstance();
        Participant participant = competition.getParticipant(participantId);

        while (parameters.hasMoreElements()) {
            String parameter = parameters.nextElement().toString();
            String parameterValue = request.getParameter(parameter);
//            logger.info("element: " + parameter + " value: " + parameterValue);

            if (parameter.equals("m")) {
                matQuery = "?m="+request.getParameter("m");
                continue;
            }

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
}
