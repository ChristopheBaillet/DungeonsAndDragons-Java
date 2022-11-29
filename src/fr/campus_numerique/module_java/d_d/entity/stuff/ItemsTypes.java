package fr.campus_numerique.module_java.d_d.entity.stuff;

public enum ItemsTypes {
    SWORD("epee de debutant"),
    SHIELD("bouclier de debutant"),
    POTION("petite potion"),
    FIREBALL("petite boule de feu"),
    CLUB("petite massue"),
    LIGHTNING_BOLT("petit eclair"),
    BIG_POTION("potion superieure"),
    ROBE("robe de novice");

    private final String name;
    ItemsTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
