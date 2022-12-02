package fr.campus_numerique.module_java.d_d.entity.stuff;

public enum ItemsTypes {
    SWORD("sword",1),
    SHIELD("shield",1),
    SMALL_POTION("small_potion",1),
    FIREBALL("fireball",1),
    CLUB("club",1),
    LIGHTNING_BOLT("lightning_bolt",1),
    BIG_POTION("big_potion",3),
    ROBE("robe",1);

    private final String name;

    private final int power;



    ItemsTypes(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return this.name;
    }

    public int getPower() {
        return power;
    }
}
