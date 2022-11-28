package fr.campus_numerique.module_java.d_d.entity.character.type;

import fr.campus_numerique.module_java.d_d.entity.character.EnemyTypes;
import fr.campus_numerique.module_java.d_d.entity.character.Enemy;

public class Dragon extends Enemy {
    public Dragon() {
        super(EnemyTypes.DRAGON);
    }

    @Override
    public String toString() {
        return "Dragon";
    }
}
