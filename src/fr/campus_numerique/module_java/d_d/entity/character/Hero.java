package fr.campus_numerique.module_java.d_d.entity.character;

import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.DefensiveStuff;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.OffensiveStuff;

abstract public class Hero extends Personage{

    protected OffensiveStuff offensiveStuff;
    protected DefensiveStuff defensiveStuff;
    protected HeroTypes type;
    public Hero(String name, HeroTypes type) {
        super(name);
        this.type = type;
        this.maxHP = type.getHP();
        this.HP = maxHP;
        this.attackPower = type.getAttackPower();
    }

    public void levelUp() {
        this.maxHP += 5;
        this.attackPower += 3;
        this.HP = maxHP;
    }

    abstract public void reset();

    public String getInfos() {
        return "Personnage { " +
                "name = " + name + "\n" +
                "HP = " + HP + "\n" +
                "attackPower = " + attackPower + "\n" +
                offensiveStuff + "\n" +
                defensiveStuff + "\n" +
                '}';
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

    public void setDefensiveStuff(DefensiveStuff defensiveStuff) {
        this.defensiveStuff = defensiveStuff;
    }
}
