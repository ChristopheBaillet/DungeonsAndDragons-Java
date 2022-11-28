package fr.campus_numerique.module_java.d_d.entity.character;

public enum EnemyTypes {
    WIZARD(4, 4, "Wizard"),
    DRAGON(6, 15, "Dragon"),
    GOBLIN(1, 6, "Goblin"),
    ROBBER(2, 8, "Robber");


    private final int attackPower;
    private final int HP;
    private final String name;
    EnemyTypes(int attackPower, int HP, String name) {
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
