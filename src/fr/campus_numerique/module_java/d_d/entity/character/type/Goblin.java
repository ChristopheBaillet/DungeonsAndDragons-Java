package fr.campus_numerique.module_java.d_d.entity.character.type;

import fr.campus_numerique.module_java.d_d.entity.character.Enemy;

public class Goblin extends Enemy {
    public Goblin(int attackPower) {
        super(attackPower);
    }

    @Override
    public String toString(){
        return "Goblin";
    }
}
