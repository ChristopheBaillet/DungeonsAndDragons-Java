package fr.campus_numerique.module_java.d_d.entity.character.type;

import fr.campus_numerique.module_java.d_d.entity.character.CharacterTypes;
import fr.campus_numerique.module_java.d_d.entity.character.Enemy;

public class Dragon extends Enemy {
    public Dragon() {
        super(CharacterTypes.DRAGON);
    }

    @Override
    public String toString(){
        return "Dragon";
    }
}