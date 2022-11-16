package fr.campus_numerique.module_java.d_d.character.type;

import fr.campus_numerique.module_java.d_d.character.Personnage;
import fr.campus_numerique.module_java.d_d.character.stuff.defensive.Potion;
import fr.campus_numerique.module_java.d_d.character.stuff.offensive.Spell;

public class Magician extends Personnage {

    public Magician(String genre, String name) {
        super(name, genre);
        this.classe = "fr.campus_numerique.module_java.d_d.character.type.Magician";
        this.HP = 6;
        this.attackPower = 15;
        this.offensiveStuff = new Spell("Fireball","fr.campus_numerique.module_java.d_d.character.stuff.offensive.Spell", 5);
        this.defensiveStuff = new Potion("Small Heal", "fr.campus_numerique.module_java.d_d.character.stuff.defensive.Potion", 3);
    }
}
