package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

public class Weapon extends OffensiveStuff {
    public Weapon(String name, int power) {
        super(name, power);
    }

    @Override
    public String toString(){
        return "Weapon " + getName();
    }

    @Override
    public void interact() {

    }

    @Override
    public void delete() {

    }
}
