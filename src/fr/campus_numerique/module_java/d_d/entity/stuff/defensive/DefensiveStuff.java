package fr.campus_numerique.module_java.d_d.entity.stuff.defensive;

import fr.campus_numerique.module_java.d_d.entity.stuff.Item;

abstract public class DefensiveStuff extends Item {
    public DefensiveStuff(String name, int power){
        super(name,power);
    }
    @Override
    public String toString() {
        return "DefensiveStuff{" +
                "name='" + getName() + '\'' +
                ", power=" + getPower() +
                '}';
    }
}
