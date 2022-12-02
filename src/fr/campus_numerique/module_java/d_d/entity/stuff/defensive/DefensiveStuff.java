package fr.campus_numerique.module_java.d_d.entity.stuff.defensive;

import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.stuff.Item;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsTypes;

abstract public class DefensiveStuff extends Item {
    private int power;

    public DefensiveStuff(String name, ItemsTypes type) {
        super(name, type);
        this.power = type.getPower();
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
