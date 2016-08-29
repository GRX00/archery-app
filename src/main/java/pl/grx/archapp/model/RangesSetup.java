package pl.grx.archapp.model;

import pl.grx.archapp.factories.CompetitionFactory;
import pl.grx.archapp.model.counter.CounterData;

import java.util.ArrayList;
import java.util.List;

public class RangesSetup {

    private final CompetitionFactory competitionFactory;

    private List<Range> ranges = new ArrayList<>();

    public RangesSetup(
            CompetitionFactory competitionFactory) {
        this.competitionFactory = competitionFactory;
    }

    public int getRangesCount() {
        return ranges.size();
    }

    public void setRangesCount(int rangesCount) {
        assert(rangesCount > 0);
        while (this.ranges.size() < rangesCount) {
            this.ranges.add(competitionFactory.buildRange());
        }
        while (this.ranges.size() > rangesCount) {
            this.ranges.remove(this.ranges.size()-1);
        }
    }

    public Range getRange(int index) {
        assert(index >= 0 && index < ranges.size());
        return ranges.get(index);
    }

    public CounterData getRangeCounterData(int index) {
        return getRange(index).getCounterData();
    }

    public int getRangeSeriesCount(int index) {
        return getRange(index).getSeriesCount();
    }
}
