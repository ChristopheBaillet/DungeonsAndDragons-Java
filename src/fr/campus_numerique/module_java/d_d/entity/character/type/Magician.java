package fr.campus_numerique.module_java.d_d.entity.character.type;

import fr.campus_numerique.module_java.d_d.entity.character.CharacterTypes;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.Robe;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Fireball;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Spell;

public class Magician extends Personage {

    public Magician(){
        this("Roberto");
    }

    public Magician(String name) {
        super(name, CharacterTypes.MAGICIAN);
        this.offensiveStuff = new Fireball( 5);
        this.defensiveStuff = new Robe("Small Heal", 3);
    }

    @Override
    public String toString(){
        return "Magician " + this.name;
    }
}
