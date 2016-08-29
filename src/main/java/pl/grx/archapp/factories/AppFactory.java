package pl.grx.archapp.factories;

import pl.grx.archapp.*;
import pl.grx.archapp.model.*;
import pl.grx.archapp.model.counter.CounterState;

import javax.servlet.ServletContext;

public class AppFactory {

    public void build(ServletContext servletContext) {

        CompetitionFactory competitionFactory = new CompetitionFactory();

        Participants participants = new Participants(competitionFactory);
        Mats mats = new Mats(participants);

        CounterState counterState = new CounterState();

        RangesSetup rangesSetup = new RangesSetup(competitionFactory);
        RangesControl rangesControl = new RangesControl(rangesSetup, counterState, participants);

        Ranking ranking = new Ranking(participants);

        DisplayHelperFactory displayHelperFactory = new DisplayHelperFactory(mats, rangesSetup, rangesControl);
        Index index = new Index(mats);
        Admin admin = new Admin(displayHelperFactory, index, rangesSetup, participants, mats);
        Control control = new Control(displayHelperFactory, rangesControl);
        Counter counter = new Counter(rangesControl, counterState);
        Score score = new Score(displayHelperFactory, participants);

        servletContext.setAttribute("index", index);
        servletContext.setAttribute("admin", admin);
        servletContext.setAttribute("control", control);
        servletContext.setAttribute("counter", counter);
        servletContext.setAttribute("score", score);
    }
}
