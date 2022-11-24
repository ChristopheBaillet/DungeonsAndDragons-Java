package fr.campus_numerique.module_java.d_d.entity.character.type;

import fr.campus_numerique.module_java.d_d.entity.character.CharacterTypes;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsFactory;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsTypes;
import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.DefensiveStuff;
import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.Robe;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Fireball;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.OffensiveStuff;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Spell;

public class Magician extends Personage {

    public Magician() {
        this("Roberto");
    }

    public Magician(String name) {
        super(name, CharacterTypes.MAGICIAN);
        this.offensiveStuff = (OffensiveStuff) ItemsFactory.createItem(ItemsTypes.FIREBALL);
        this.defensiveStuff = (DefensiveStuff) ItemsFactory.createItem(ItemsTypes.ROBE);
    }

    @Override
    public String toString() {
        return "Magician " + this.name;
    }
}
