package fr.campus_numerique.module_java.d_d.entity.character;

import fr.campus_numerique.module_java.d_d.entity.character.type.*;

public class CharactersFactory {
    public static Enemy createEnemy(CharacterTypes type){
        switch (type){
            case DRAGON -> new Dragon();
            case WIZARD -> new Wizard();
            case GOBLIN -> new Goblin();
            case ROBBER -> new Robber();
        }
        return null;
    }

    public static Personage createCharacter(CharacterTypes type, String name){
        switch (type){
            case WARRIOR -> new Warrior(name);
            case MAGICIAN -> new Magician(name);
        }
        return null;
    }
}
