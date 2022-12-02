package fr.campus_numerique.module_java.d_d.entity.stuff.defensive;

import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsTypes;

public class Robe extends DefensiveStuff {
    public Robe(String name) {
        super(name, ItemsTypes.ROBE);
    }



    @Override
    public void delete() {

    }
}
