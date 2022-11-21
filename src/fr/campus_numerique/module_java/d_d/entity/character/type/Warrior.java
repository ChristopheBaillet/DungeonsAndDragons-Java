package fr.campus_numerique.module_java.d_d.entity.character.type;

import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.stuff.defensive.Shield;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Sword;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Weapon;

public class Warrior extends Personage {
    public Warrior(){
        this.name = "Bobby";
        this.HP = 10;
        this.attackPower = 10;
        this.offensiveStuff = new Sword(  5);
        this.defensiveStuff = new Shield("Aubéclat",  3);
    }
    public Warrior(String name) {
        super(name);
        this.HP = 10;
        this.attackPower = 10;
        this.offensiveStuff = new Sword( 5);
        this.defensiveStuff = new Shield("Aubéclat",  3);
    }
    @Override
    public String toString(){
        return "Warrior " + this.name;
    }

}
