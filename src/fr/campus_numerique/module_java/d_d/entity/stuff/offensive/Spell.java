package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

import fr.campus_numerique.module_java.d_d.entity.character.Personage;

abstract public class Spell extends OffensiveStuff {
    public Spell(int power) {
        super(power);
    }

    @Override
    public String toString(){
        return "Spell " + getName();
    }

    @Override
    public void interact(Personage character) {
        System.out.println(this);
    }

    @Override
    public void delete() {

    }
}
