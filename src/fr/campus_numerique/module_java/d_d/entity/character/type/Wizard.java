package fr.campus_numerique.module_java.d_d.entity.character.type;

import fr.campus_numerique.module_java.d_d.entity.character.Enemy;

public class Wizard extends Enemy {
    public Wizard(int attackPower) {
        super(attackPower);
    }

    @Override
    public String toString(){
        return "Wizard";
    }
}
