package fr.campus_numerique.module_java.d_d.character.type;

import fr.campus_numerique.module_java.d_d.character.Personnage;
import fr.campus_numerique.module_java.d_d.character.stuff.defensive.Shield;
import fr.campus_numerique.module_java.d_d.character.stuff.offensive.Weapon;

public class Warrior extends Personnage {
    public Warrior(String name, String genre) {
        super(name, genre);
        this.classe = "fr.campus_numerique.module_java.d_d.character.type.Warrior";
        this.HP = 10;
        this.attackPower = 10;
        this.offensiveStuff = new Weapon("Finelame", "fr.campus_numerique.module_java.d_d.character.stuff.offensive.Weapon", 5);
        this.defensiveStuff = new Shield("Aubéclat", "fr.campus_numerique.module_java.d_d.character.stuff.defensive.Shield", 3);
    }
}
