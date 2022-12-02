package fr.campus_numerique.module_java.d_d.stats;

import java.util.ArrayList;
import java.util.List;

public class InteractionsStats implements InteractionListener{

    private List<InteractionEvent> events = new ArrayList<>();


    @Override
    public void onInteractionDone(InteractionEvent event) {
        events.add(event);
    }

    @Override
    public String toString() {
        return "InteractionsStats{" +
                "events=" + events +
                '}';
    }
}
