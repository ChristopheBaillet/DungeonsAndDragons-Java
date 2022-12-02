package fr.campus_numerique.module_java.d_d;

import fr.campus_numerique.module_java.d_d.entity.character.CharactersFactory;
import fr.campus_numerique.module_java.d_d.entity.character.HeroTypes;
import fr.campus_numerique.module_java.d_d.management.CharacterDBFactory;
import fr.campus_numerique.module_java.d_d.management.DBCharacter;
import fr.campus_numerique.module_java.d_d.management.Game;

public class Main {
    public static void main(String[] args) {
        DBCharacter dbCharacter = new DBCharacter();
//        dbCharacter.save(CharactersFactory.createCharacter(HeroTypes.WARRIOR, "Bobby"));
        dbCharacter.update(CharactersFactory.createCharacter(HeroTypes.WARRIOR, "Nicolas"), 12);
        Game game = new Game();
        game.start();
    }
}