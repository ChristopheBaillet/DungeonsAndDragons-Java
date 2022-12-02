package fr.campus_numerique.module_java.d_d.entity.board;

import fr.campus_numerique.module_java.d_d.entity.character.CharactersFactory;
import fr.campus_numerique.module_java.d_d.entity.character.EnemyTypes;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsFactory;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsTypes;
import fr.campus_numerique.module_java.d_d.entity.stuff.items.Potion;

public class CaseFactory {
    public static Case createCaseForBoard(CaseTypes type){
        return switch (type){
            case FIREBALL -> ItemsFactory.createItem(ItemsTypes.FIREBALL);
            case LIGHTNING_BOLT -> ItemsFactory.createItem(ItemsTypes.LIGHTNING_BOLT);
            case BIG_POTION -> ItemsFactory.createItem(ItemsTypes.BIG_POTION);
            case POTION -> ItemsFactory.createItem(ItemsTypes.SMALL_POTION);
            case CLUB -> ItemsFactory.createItem(ItemsTypes.CLUB);
            case EMPTY -> new EmptyCase();
            case SWORD -> ItemsFactory.createItem(ItemsTypes.SWORD);
            case DRAGON -> CharactersFactory.createEnemy(EnemyTypes.DRAGON);
            case GOBLIN -> CharactersFactory.createEnemy(EnemyTypes.GOBLIN);
            case ROBBER -> CharactersFactory.createEnemy(EnemyTypes.ROBBER);
            case WIZARD -> CharactersFactory.createEnemy(EnemyTypes.WIZARD);
        };
    }
}
