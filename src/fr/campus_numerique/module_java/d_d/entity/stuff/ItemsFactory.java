package fr.campus_numerique.module_java.d_d.entity.stuff;

import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.Robe;
import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.Shield;
import fr.campus_numerique.module_java.d_d.entity.stuff.items.BigPotion;
import fr.campus_numerique.module_java.d_d.entity.stuff.items.Potion;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Club;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Fireball;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.LightningBolt;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Sword;
import fr.campus_numerique.module_java.d_d.exception.ItemException;

public class ItemsFactory {
    public static Item createItem(ItemsTypes type) {
        return createCustomItem(type, type.getName());
    }

    public static Item createCustomItem(ItemsTypes type, String name) {
        return switch (type) {
            case CLUB -> new Club(name, 34);
            case ROBE -> new Robe(name, 1);
            case SWORD -> new Sword(name, 1);
            case POTION -> new Potion(name, 1);
            case SHIELD -> new Shield(name, 1);
            case FIREBALL -> new Fireball(name, 1);
            case BIG_POTION -> new BigPotion(name, 1);
            case LIGHTNING_BOLT -> new LightningBolt(name, 1);
        };
    }
}
