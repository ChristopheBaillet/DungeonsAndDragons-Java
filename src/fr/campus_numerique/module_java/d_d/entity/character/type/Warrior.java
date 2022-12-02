package fr.campus_numerique.module_java.d_d.entity.character.type;

import fr.campus_numerique.module_java.d_d.entity.character.EnemyTypes;
import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.character.HeroTypes;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsFactory;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsTypes;
import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.DefensiveStuff;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.OffensiveStuff;

public class Warrior extends Hero {
    public Warrior() {
        this("Bobby");
    }

    public Warrior(String name) {
        super(name, HeroTypes.WARRIOR);
        this.offensiveStuff = (OffensiveStuff) ItemsFactory.createItem(ItemsTypes.SWORD);
        this.defensiveStuff = (DefensiveStuff) ItemsFactory.createItem(ItemsTypes.SHIELD);
    }

    public Warrior(String name, int hp, int attackPower, OffensiveStuff offensiveStuff, DefensiveStuff defensiveStuff) {
        super(name, hp, attackPower, offensiveStuff,defensiveStuff, HeroTypes.WARRIOR);
    }

    @Override
    public String toString() {
        return "Warrior " + this.name;
    }

    @Override
    public void reset() {
        this.HP = 10;
        this.attackPower = 10;
    }
}
