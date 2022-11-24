package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.character.type.Magician;

abstract public class Spell extends OffensiveStuff {
    public Spell(String name,int power) {
        super(name, power);
    }

    @Override
    public String toString() {
        return "Spell " + getName();
    }
    @Override
    public void interact(Personage character) {
        if (character instanceof Magician){
            character.setAttackPower(getPower()+ character.getAttackPower());
        }
    }

    @Override
    public void delete() {

    }
}
