package fr.campus_numerique.module_java.d_d.entity.board;

import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;

public interface Case {
    void interact(Hero character);

    void delete();
    String display();
    boolean canInteract();
}
