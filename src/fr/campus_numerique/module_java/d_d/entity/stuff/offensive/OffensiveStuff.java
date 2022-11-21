package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

import fr.campus_numerique.module_java.d_d.entity.stuff.Item;

abstract public class OffensiveStuff extends Item {
    public OffensiveStuff(int power){
       super(power);
    }
    @Override
    public String toString() {
        return "OffensiveStuff{" +
                "name='" + getName() + '\'' +
                ", power=" + getPower() +
                '}';
    }
}
