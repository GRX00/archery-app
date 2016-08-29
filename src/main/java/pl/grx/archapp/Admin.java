package pl.grx.archapp;

import pl.grx.archapp.displayhelper.AdminDisplayHelper;
import pl.grx.archapp.displayhelper.CounterDataDisplayHelper;
import pl.grx.archapp.displayhelper.ParticipantsDisplayHelper;
import pl.grx.archapp.displayhelper.RangeDisplayHelper;
import pl.grx.archapp.factories.DisplayHelperFactory;
import pl.grx.archapp.model.Mats;
import pl.grx.archapp.model.Participants;
import pl.grx.archapp.model.Range;
import pl.grx.archapp.model.RangesSetup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Admin {

    private final Index index;
    private final DisplayHelperFactory displayHelperFactory;
    private final RangesSetup rangesSetup;
    private final Participants participants;
    private final Mats mats;

    public Admin(
            DisplayHelperFactory displayHelperFactory,
            Index index,
            RangesSetup rangesSetup,
            Participants participants,
            Mats mats) {
        this.displayHelperFactory = displayHelperFactory;
        this.index = index;
        this.rangesSetup = rangesSetup;
        this.participants = participants;
        this.mats = mats;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        index.setConfigured();

        request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/jsp/admin/administration.jsp")
                .forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (int rangeNr = 1; rangeNr <= rangesSetup.getRangesCount(); rangeNr++) {
            Range currentRange = rangesSetup.getRange(rangeNr - 1);
            RangeDisplayHelper rangeDisplayHelper = displayHelperFactory.buildRangeService(currentRange);
            CounterDataDisplayHelper counterDataDisplayHelper = displayHelperFactory.buildCounterDataService(currentRange.getCounterData());

            String paramName = String.valueOf(rangeNr) + ':';

            rangeDisplayHelper.setDate(request.getParameter(paramName.concat("date")));
            rangeDisplayHelper.setDescription(request.getParameter(paramName.concat("rangeDescription")));
            rangeDisplayHelper.setSeriesCount(request.getParameter(paramName.concat("seriesCount")));
            rangeDisplayHelper.setArrowsInSeries(request.getParameter(paramName.concat("seriesArrows")));
            counterDataDisplayHelper.setSeriesTime(
                    request.getParameter(paramName.concat("seriesTimeMinutes")),
                    request.getParameter(paramName.concat("seriesTimeSeconds")));
            counterDataDisplayHelper.setPrepareTime(
                    request.getParameter(paramName.concat("prepareTimeMinutes")),
                    request.getParameter(paramName.concat("prepareTimeSeconds")));
            counterDataDisplayHelper.setYellowTime(
                    request.getParameter(paramName.concat("yellowTimeMinutes")),
                    request.getParameter(paramName.concat("yellowTimeSeconds")));
            counterDataDisplayHelper.setRedTime(
                    request.getParameter(paramName.concat("redTimeMinutes")),
                    request.getParameter(paramName.concat("redTimeSeconds")));
            counterDataDisplayHelper.setSequence(request.getParameter(paramName.concat("seriesSequence")));
        }

        for (int matNr = 1; matNr <= mats.getMatsCount(); matNr++) {
            ParticipantsDisplayHelper participantsDisplayHelper = displayHelperFactory.buildParticipantsService(participants);
            String paramName = String.valueOf(matNr) + ":name";

            participantsDisplayHelper.setParticipantPosition(matNr, 0,
                    request.getParameter(paramName.concat("A")));
            participantsDisplayHelper.setParticipantPosition(matNr, 1,
                    request.getParameter(paramName.concat("B")));
            participantsDisplayHelper.setParticipantPosition(matNr, 2,
                    request.getParameter(paramName.concat("C")));
            participantsDisplayHelper.setParticipantPosition(matNr, 3,
                    request.getParameter(paramName.concat("D")));
        }

//        competitionService.setupParticipants();

        rangesSetup.setRangesCount(Integer.valueOf(request.getParameter("rangesNr")));

        mats.setMatsCount(Integer.valueOf(request.getParameter("matsNr")));

        request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/jsp/admin/administration.jsp")
                .forward(request, response);
    }

    public AdminDisplayHelper getAdminDisplayHelper() {
        return displayHelperFactory.buildAdminDisplayHelper();
    }
}
