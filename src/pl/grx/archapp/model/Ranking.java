package pl.grx.archapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Ranking {

    private final List<String> participants;

    public Ranking(Set<String> participants) {
        this.participants = new ArrayList<>();
        this.participants.addAll(participants);
    }
}
