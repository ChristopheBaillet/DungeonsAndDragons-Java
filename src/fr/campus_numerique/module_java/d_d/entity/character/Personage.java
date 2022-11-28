package fr.campus_numerique.module_java.d_d.entity.character;

abstract public class Personage {
    protected String name;
    protected int HP, attackPower, maxHP;
    public Personage(String name) {
        this.name = name;
    }

    public int getHP() {
        return this.HP;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getName() {
        return name;
    }

    public void setHP(int HP) {
        this.HP = Math.min(HP, maxHP);
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
}