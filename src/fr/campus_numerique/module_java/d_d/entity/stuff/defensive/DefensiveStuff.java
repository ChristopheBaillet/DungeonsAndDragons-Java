package fr.campus_numerique.module_java.d_d.entity.stuff.defensive;

import fr.campus_numerique.module_java.d_d.entity.stuff.Item;

abstract public class DefensiveStuff extends Item {
    private int power;
    public DefensiveStuff(String name, int power){
        super(name);
        this.power = power;
    }
    @Override
    public String toString() {
        return "DefensiveStuff{" +
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
