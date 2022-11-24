package fr.campus_numerique.module_java.d_d.entity.character;

import fr.campus_numerique.module_java.d_d.entity.character.type.*;
import fr.campus_numerique.module_java.d_d.exception.CharacterTypeException;

public class CharactersFactory {
    public static Enemy createEnemy(CharacterTypes type) throws CharacterTypeException {
        return switch (type){
            case DRAGON -> new Dragon();
            case WIZARD -> new Wizard();
            case GOBLIN -> new Goblin();
            case ROBBER -> new Robber();
            case MAGICIAN, WARRIOR -> throw new CharacterTypeException();
        };
    }

    public static Personage createCharacter(CharacterTypes type, String name) throws CharacterTypeException {
        return switch (type){
            case WARRIOR -> new Warrior(name);
            case WIZARD, ROBBER, DRAGON, GOBLIN -> throw new CharacterTypeException();
            case MAGICIAN -> new Magician(name);
        };
    }
}
