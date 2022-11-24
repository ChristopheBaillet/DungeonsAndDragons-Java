package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.character.type.Warrior;

abstract public class Weapon extends OffensiveStuff {
    public Weapon(String name, int power) {
        super(name, power);
    }

    @Override
    public String toString() {
        return "Weapon " + getName();
    }

    @Override
    public void interact(Personage character) {
        if (character instanceof Warrior){
            character.setAttackPower(character.getAttackPower() + getPower());
        }
    }

    @Override
    public void delete() {

    }
}
