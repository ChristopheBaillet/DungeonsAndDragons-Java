package fr.campus_numerique.module_java.d_d.entity.type;

import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.Potion;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Spell;

public class Magician extends Personnage {

    public Magician(){
        this.name = "Roberto";
        this.HP = 6;
        this.attackPower = 15;
        this.offensiveStuff = new Spell("Fireball","Spell", 5);
        this.defensiveStuff = new Potion("Small Heal", "Potion", 3);
    }

    public Magician(String name) {
        super(name);
        this.HP = 6;
        this.attackPower = 15;
        this.offensiveStuff = new Spell("Fireball","Spell", 5);
        this.defensiveStuff = new Potion("Small Heal", "Potion", 3);
    }

    @Override
    public String toString(){
        return "Magician " + this.name;
    }
}
