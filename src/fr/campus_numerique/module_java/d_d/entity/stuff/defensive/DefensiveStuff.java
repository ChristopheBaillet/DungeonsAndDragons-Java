package fr.campus_numerique.module_java.d_d.entity.stuff.defensive;

import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.stuff.Item;

abstract public class DefensiveStuff extends Item {
    private int power;

    public DefensiveStuff(String name, int power) {
        super(name);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void interact(Hero character) {
        System.out.println(this);
    }

}
