package fr.campus_numerique.module_java.d_d.entity.character;

public enum HeroTypes {
    MAGICIAN(15, 6, "Magician"),
    WARRIOR(10, 10, "Warrior");

    private final int attackPower;
    private final int HP;
    private final String name;
    HeroTypes(int attackPower, int HP, String name) {
        this.attackPower = attackPower;
        this.HP = HP;
        this.name = name;
    }

    public int getHP() {
        return this.HP;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public String getName() {
        return this.name;
    }
}
