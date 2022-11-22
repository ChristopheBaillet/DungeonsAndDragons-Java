package fr.campus_numerique.module_java.d_d.entity.character.type;

import fr.campus_numerique.module_java.d_d.entity.character.CharacterTypes;
import fr.campus_numerique.module_java.d_d.entity.character.Enemy;

public class Robber extends Enemy {
    public Robber() {
        super(CharacterTypes.ROBBER);
    }

    @Override
    public String toString(){
        return "Robber";
    }
}
