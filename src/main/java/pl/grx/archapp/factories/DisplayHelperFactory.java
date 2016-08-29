package pl.grx.archapp.factories;

import pl.grx.archapp.displayhelper.*;
import pl.grx.archapp.model.*;
import pl.grx.archapp.model.counter.CounterData;

public class DisplayHelperFactory {

    private final Mats mats;
    private final RangesSetup rangesSetup;
    private final RangesControl rangesControl;

    public DisplayHelperFactory(Mats mats, RangesSetup rangesSetup, RangesControl rangesControl) {
        this.mats = mats;
        this.rangesSetup = rangesSetup;
        this.rangesControl = rangesControl;
    }

    public RangeDisplayHelper buildRangeService(Range range) {
        return new RangeDisplayHelper(range);
    }

    public CounterDataDisplayHelper buildCounterDataService(CounterData counterData) {
        return new CounterDataDisplayHelper(counterData);
    }

    public ParticipantsDisplayHelper buildParticipantsService(Participants participants) {
        return new ParticipantsDisplayHelper(participants);
    }

    public ControlDisplayHelper buildControlDisplayHelper() {
        return new ControlDisplayHelper(rangesControl);
    }

    public AdminDisplayHelper buildAdminDisplayHelper() {
        return new AdminDisplayHelper(mats, rangesSetup);
    }

    public ScoreDisplayHelper buildScoreDisplayHelper(Participant participant) {
        return new ScoreDisplayHelper(participant.getCurrentRangeScoreTable());
    }
}
