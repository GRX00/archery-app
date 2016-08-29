package pl.grx.archapp.displayhelper;

import pl.grx.archapp.model.RangesControl;

public class ControlDisplayHelper {

    private final RangesControl rangesControl;

    public ControlDisplayHelper(RangesControl rangesControl) {
        this.rangesControl = rangesControl;
    }

    public String getCurrentRangeNumber() {
        return String.valueOf(rangesControl.getCurrentRangeIndex() + 1);
    }

    public String getCurrentSeriesNumber() {
        return String.valueOf(rangesControl.getCurrentSeriesIndex() + 1);
    }
}
