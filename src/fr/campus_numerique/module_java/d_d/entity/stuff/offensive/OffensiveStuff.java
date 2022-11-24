package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.character.type.Warrior;
import fr.campus_numerique.module_java.d_d.entity.stuff.Item;

abstract public class OffensiveStuff extends Item {
    private int power;

    public OffensiveStuff(String name, int power) {
        super(name);
        this.power = power;
    }

    @Override
    public String toString() {
        return "OffensiveStuff{" +
                "name='" + getName() + '\'' +
                ", power=" + getPower() +
                '}';
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
