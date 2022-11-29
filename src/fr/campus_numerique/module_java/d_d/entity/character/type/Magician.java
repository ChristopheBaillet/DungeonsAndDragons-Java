package fr.campus_numerique.module_java.d_d.entity.character.type;

import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.character.HeroTypes;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsFactory;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsTypes;
import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.DefensiveStuff;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.OffensiveStuff;

public class Magician extends Hero {
    public Magician(String name) {
        super(name, HeroTypes.MAGICIAN);
        this.offensiveStuff = (OffensiveStuff) ItemsFactory.createItem(ItemsTypes.FIREBALL);
        this.defensiveStuff = (DefensiveStuff) ItemsFactory.createItem(ItemsTypes.ROBE);
    }
    @Override
    public String toString() {
        return "Magician " + this.name;
    }

    @Override
    public void reset() {
        this.HP = 6;
        this.attackPower = 15;
    }
}
