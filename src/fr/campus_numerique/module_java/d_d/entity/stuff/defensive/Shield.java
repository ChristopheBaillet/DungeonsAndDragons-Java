package fr.campus_numerique.module_java.d_d.entity.stuff.defensive;

import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsTypes;

public class Shield extends DefensiveStuff {
    public Shield(String name) {
        super(name, ItemsTypes.SHIELD);
    }

    @Override
    public void delete() {

    }
}
