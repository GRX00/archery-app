package pl.grx.archapp;

import pl.grx.archapp.displayhelper.ScoreDisplayHelper;
import pl.grx.archapp.factories.DisplayHelperFactory;
import pl.grx.archapp.model.Participant;
import pl.grx.archapp.model.Participants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Score {
    private final DisplayHelperFactory displayHelperFactory;
    private final Participants participants;

    public Score(DisplayHelperFactory displayHelperFactory, Participants participants) {
        this.displayHelperFactory = displayHelperFactory;
        this.participants = participants;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address;
        Integer matNr = null;

        try {
            matNr = Integer.valueOf(request.getParameter("m"));
        } catch (NumberFormatException ignore) { }

        if (matNr == null) {
            address = request.getContextPath()+"/index";
        } else {
            address = request.getContextPath()+"/WEB-INF/jsp/score/score.jsp";
        }

        request.getRequestDispatcher(address).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matQuery = "";
        Enumeration parameters = request.getParameterNames();

        while (parameters.hasMoreElements()) {
            String parameter = parameters.nextElement().toString();
            String parameterValue = request.getParameter(parameter);

            if (parameter.equals("m")) {
                matQuery = "?m="+request.getParameter("m");
                continue;
            }

            String participantName = extractParticipantName(parameter);
            Integer index = extractScoreIndex(parameter);
            Participant participant = participants.getParticipantByName(participantName);
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

    public Participant getParticipant(int matNumber, int positionIndex) {
        return participants.getParticipant(matNumber - 1, positionIndex);
    }

    public ScoreDisplayHelper getScoreDisplayHelper(Participant participant) {
        return displayHelperFactory.buildScoreDisplayHelper(participant);
    }
}
