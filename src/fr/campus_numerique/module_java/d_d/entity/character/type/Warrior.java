package fr.campus_numerique.module_java.d_d.entity.character.type;

import fr.campus_numerique.module_java.d_d.entity.character.CharacterTypes;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsFactory;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsTypes;
import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.DefensiveStuff;
import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.Shield;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.OffensiveStuff;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Sword;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Weapon;
import fr.campus_numerique.module_java.d_d.exception.ItemException;

public class Warrior extends Personage {
    public Warrior(){
        this("Bobby");
    }
    public Warrior(String name) {
        super(name, CharacterTypes.WARRIOR);
        this.offensiveStuff = (OffensiveStuff) ItemsFactory.createItem(ItemsTypes.SWORD);
        this.defensiveStuff = (DefensiveStuff) ItemsFactory.createItem(ItemsTypes.SHIELD);
    }
    @Override
    public String toString(){
        return "Warrior " + this.name;
    }
}
