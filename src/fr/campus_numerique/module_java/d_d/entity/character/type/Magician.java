package fr.campus_numerique.module_java.d_d.entity.character.type;

import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.Robe;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Fireball;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Spell;

public class Magician extends Personage {

    public Magician(){
        this.name = "Roberto";
        this.HP = 6;
        this.attackPower = 15;
        this.offensiveStuff = new Fireball( 5);
        this.defensiveStuff = new Robe("Small Heal", 3);
    }

    public Magician(String name) {
        super(name);
        this.HP = 6;
        this.attackPower = 15;
        this.offensiveStuff = new Fireball( 5);
        this.defensiveStuff = new Robe("Small Heal", 3);
    }

    @Override
    public String toString(){
        return "Magician " + this.name;
    }
}
