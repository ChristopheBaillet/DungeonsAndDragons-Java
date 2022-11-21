package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

import fr.campus_numerique.module_java.d_d.entity.character.Personage;

abstract public class Weapon extends OffensiveStuff {
    public Weapon(int power) {
        super(power);
    }

    @Override
    public String toString(){
        return "Weapon " + getName();
    }

    @Override
    public void interact(Personage character) {
        System.out.println("Ceci est un "+this);
    }

    @Override
    public void delete() {

    }
}
