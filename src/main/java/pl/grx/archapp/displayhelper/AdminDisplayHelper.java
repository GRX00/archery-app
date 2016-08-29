package pl.grx.archapp.displayhelper;

import pl.grx.archapp.model.Mats;
import pl.grx.archapp.model.RangesSetup;

public class AdminDisplayHelper {

    private final Mats mats;
    private final RangesSetup rangesSetup;

    public AdminDisplayHelper(Mats mats,
                              RangesSetup rangesSetup) {
        this.mats = mats;
        this.rangesSetup = rangesSetup;
    }

    public String getRangesCount() {
        return String.valueOf(rangesSetup.getRangesCount());
    }

    public int getRangesCountNr() {
        return rangesSetup.getRangesCount();
    }

    public String getMatsCount() {
        return String.valueOf(mats.getMatsCount());
    }

    public int getMatsCountNr() {
        return mats.getMatsCount();
    }

    public void setRangesCount(String rangesCount) {
        rangesSetup.setRangesCount(Integer.valueOf(rangesCount));
    }

    public void setMatsCount(String matsCount) {
        mats.setMatsCount(Integer.valueOf(matsCount));
    }
}
