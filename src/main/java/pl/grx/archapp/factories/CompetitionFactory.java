package pl.grx.archapp.factories;

import pl.grx.archapp.model.Participant;
import pl.grx.archapp.model.Range;
import pl.grx.archapp.model.counter.CounterData;
import pl.grx.archapp.model.counter.Time;
import pl.grx.archapp.model.enums.SeriesSequence;
import pl.grx.archapp.model.score.SeriesSettings;

import java.util.Date;

public class CompetitionFactory {

    public Range buildRange() {
        Time prepareTime = new Time(0, 10);
        Time seriesTime = new Time(4, 0);
        Time yellowTime = new Time(1, 30);
        Time redTime = new Time(0, 30);
        SeriesSequence seriesSequence = SeriesSequence.ABAB;

        CounterData counterData = new CounterData(prepareTime, seriesTime, yellowTime, redTime, seriesSequence);

        SeriesSettings seriesSettings = new SeriesSettings(6, 6);

        return new Range(
                new Date(),
                "30 m",
                seriesSettings,
                counterData
                );
    }

    public Participant buildParticipant(String name) {
        return new Participant(name);
    }
}
