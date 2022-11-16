package fr.campus_numerique.module_java.d_d.character.type;

import fr.campus_numerique.module_java.d_d.character.Personnage;
import fr.campus_numerique.module_java.d_d.character.stuff.defensive.Shield;
import fr.campus_numerique.module_java.d_d.character.stuff.offensive.Weapon;

public class Warrior extends Personnage {
    public Warrior(){
        this.HP = 10;
        this.attackPower = 10;
        this.offensiveStuff = new Weapon("Finelame", "Weapon", 5);
        this.defensiveStuff = new Shield("Aubéclat", "Shield", 3);
    }
    public Warrior(String name, String genre) {
        super(name, genre);
        this.HP = 10;
        this.attackPower = 10;
        this.offensiveStuff = new Weapon("Finelame", "Weapon", 5);
        this.defensiveStuff = new Shield("Aubéclat", "Shield", 3);
    }
    public String showNameGenreClass(Personnage character){
        return "Here is you character :\n"+
                "name : "+ this.name+ "| genre : " + this.genre + "| class : Warrior";
    }

}
