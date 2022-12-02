package fr.campus_numerique.module_java.d_d.entity.stuff;

import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.Robe;
import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.Shield;
import fr.campus_numerique.module_java.d_d.entity.stuff.items.BigPotion;
import fr.campus_numerique.module_java.d_d.entity.stuff.items.SmallPotion;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Club;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Fireball;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.LightningBolt;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Sword;

public class ItemsFactory {
    public static Item createItem(ItemsTypes type) {
        return createCustomItem(type, type.getName());
    }

    public static Item createCustomItem(ItemsTypes type, String name) {
        return switch (type) {
            case CLUB -> new Club(name);
            case ROBE -> new Robe(name);
            case SWORD -> new Sword(name);
            case SMALL_POTION -> new SmallPotion(name);
            case SHIELD -> new Shield(name);
            case FIREBALL -> new Fireball(name);
            case BIG_POTION -> new BigPotion(name);
            case LIGHTNING_BOLT -> new LightningBolt(name);
        };
    }
}
