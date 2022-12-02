package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

import fr.campus_numerique.module_java.d_d.entity.stuff.Item;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsTypes;

abstract public class OffensiveStuff extends Item {
    private int power;

    public OffensiveStuff(String name, ItemsTypes type) {
        super(name, type);
        this.power = type.getPower();
    }


    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
