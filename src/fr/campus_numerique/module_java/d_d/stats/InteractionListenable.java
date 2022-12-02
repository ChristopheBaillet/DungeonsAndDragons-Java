package fr.campus_numerique.module_java.d_d.stats;

public interface InteractionListenable {
    void addInteractionListener(InteractionListener interactionListener);
    void removeInteractionListener(InteractionListener interactionListener);
}
