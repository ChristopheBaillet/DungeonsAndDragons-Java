package fr.campus_numerique.module_java.d_d.entity.stuff;

public enum ItemsTypes {
    SWORD("épée de débutant"),
    SHIELD("bouclier de débutant"),
    POTION("petite potion"),
    FIREBALL("petite boule de feu"),
    CLUB("petite massue"),
    LIGHTNING_BOLT("petit éclair"),
    BIG_POTION("potion supérieure"),
    ROBE("robe de novice");

    private final String name;

    ItemsTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
