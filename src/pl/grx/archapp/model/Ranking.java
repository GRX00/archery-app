package pl.grx.archapp.model;

import java.util.ArrayList;
import java.util.List;

public class Ranking {

    private final List<String> participants;

    public Ranking(List<Participant> participants) {
        this.participants = new ArrayList<>();
    }
}
