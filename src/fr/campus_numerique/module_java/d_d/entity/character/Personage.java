package fr.campus_numerique.module_java.d_d.entity.character;

import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.DefensiveStuff;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.OffensiveStuff;

abstract public class Personage {
    protected String name;

    private CharacterTypes type;
    protected int HP, attackPower,position, maxHP;
    protected OffensiveStuff offensiveStuff;
    protected DefensiveStuff defensiveStuff;
    public Personage(CharacterTypes type) {
        this(type.getName(), type);
    }

    public Personage(String name, CharacterTypes type) {
        this.name = name;
        this.maxHP = type.getHP();
        this.HP = maxHP;
        this.attackPower = type.getAttackPower();
    }
    public String getInfos() {
        return "Personnage { " +
                "name = " + name + "\n" +
                "HP = " + HP + "\n"+
                "attackPower = " + attackPower +"\n"+
                offensiveStuff +"\n"+
                defensiveStuff +"\n"+
                '}';
    }

    public void levelUp(){
        this.maxHP += 5;
        this.attackPower += 3;
        this.HP += 5;
    }

    public int getHP() {
        return HP;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getName() {
        return name;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffensiveStuff getOffensiveStuff() {
        return offensiveStuff;
    }

    public void setOffensiveStuff(OffensiveStuff offensiveStuff) {
        this.offensiveStuff = offensiveStuff;
    }

    public DefensiveStuff getDefensiveStuff() {
        return defensiveStuff;
    }

    public void setDefensiveStuff(DefensiveStuff defensiveStuff) { this.defensiveStuff = defensiveStuff; }
    public int getPosition() { return position; }

    public void setPosition(int position) { this.position = position; }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }


}