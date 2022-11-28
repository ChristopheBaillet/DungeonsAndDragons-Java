package fr.campus_numerique.module_java.d_d.entity.character;

import fr.campus_numerique.module_java.d_d.entity.character.type.*;

public class CharactersFactory {
    public static Enemy createEnemy(EnemyTypes type) {
        return switch (type) {
            case DRAGON -> new Dragon();
            case WIZARD -> new Wizard();
            case GOBLIN -> new Goblin();
            case ROBBER -> new Robber();
        };
    }

    public static Hero createCharacter(HeroTypes type, String name){
        return switch (type) {
            case WARRIOR -> new Warrior(name);
            case MAGICIAN -> new Magician(name);
        };
    }
}
