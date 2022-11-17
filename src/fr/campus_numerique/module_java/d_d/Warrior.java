package fr.campus_numerique.module_java.d_d;

public class Warrior extends Personnage {
    public Warrior(){
        this.name = "Bobby";
        this.HP = 10;
        this.attackPower = 10;
        this.offensiveStuff = new Weapon("Finelame", "Weapon", 5);
        this.defensiveStuff = new Shield("Aubéclat", "Shield", 3);
    }
    public Warrior(String name) {
        super(name);
        this.HP = 10;
        this.attackPower = 10;
        this.offensiveStuff = new Weapon("Finelame", "Weapon", 5);
        this.defensiveStuff = new Shield("Aubéclat", "Shield", 3);
    }
    @Override
    public String toString(){
        return "Warrior " + this.name;
    }

}
