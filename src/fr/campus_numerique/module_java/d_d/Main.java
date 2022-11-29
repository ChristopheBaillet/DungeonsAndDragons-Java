package fr.campus_numerique.module_java.d_d;

import fr.campus_numerique.module_java.d_d.entity.character.CharactersFactory;
import fr.campus_numerique.module_java.d_d.entity.character.HeroTypes;
import fr.campus_numerique.module_java.d_d.management.Game;
import fr.campus_numerique.module_java.d_d.management.Database;

public class Main {
    public static void main(String[] args) {
        Database connectionDB = Database.getInstance();
        connectionDB.getHeroes();
        connectionDB.updateHero(CharactersFactory.createCharacter(HeroTypes.MAGICIAN, "Bobby"));
        Game game = new Game();
    }
}