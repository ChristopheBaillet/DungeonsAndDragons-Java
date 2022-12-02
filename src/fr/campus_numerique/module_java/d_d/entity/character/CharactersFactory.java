package fr.campus_numerique.module_java.d_d.entity.character;

import fr.campus_numerique.module_java.d_d.entity.character.type.*;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsFactory;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsTypes;
import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.DefensiveStuff;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.OffensiveStuff;
import fr.campus_numerique.module_java.d_d.exception.ItemException;

import java.sql.SQLException;

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

    public static Hero createCharacterFromDB(String name, int hp, int attackPower, String offensiveStuff, String defensiveStuff, HeroTypes type) throws ItemException {
        OffensiveStuff offStuff = (OffensiveStuff) switch (offensiveStuff){
            case "club" -> ItemsFactory.createItem(ItemsTypes.CLUB);
            case "sword" -> ItemsFactory.createItem(ItemsTypes.SWORD);
            case "fireball" -> ItemsFactory.createItem(ItemsTypes.FIREBALL);
            case "lightning_bolt" -> ItemsFactory.createItem(ItemsTypes.LIGHTNING_BOLT);
            default -> throw new ItemException();
        };
        DefensiveStuff defStuff = (DefensiveStuff) switch (defensiveStuff){
            case "shield" -> ItemsFactory.createItem(ItemsTypes.SHIELD);
            case "robe" -> ItemsFactory.createItem(ItemsTypes.ROBE);
            default -> throw new ItemException();
        };
        return switch (type){
            case WARRIOR -> new Warrior(name,hp,attackPower,offStuff, defStuff);
            case MAGICIAN -> new Magician(name,hp,attackPower,offStuff,defStuff);
        };
    }
}
