package fr.campus_numerique.module_java.d_d.character.type;

import fr.campus_numerique.module_java.d_d.character.Personnage;
import fr.campus_numerique.module_java.d_d.character.stuff.defensive.Potion;
import fr.campus_numerique.module_java.d_d.character.stuff.offensive.Spell;

public class Magician extends Personnage {

    public Magician(){
        this.HP = 6;
        this.attackPower = 15;
        this.offensiveStuff = new Spell("Fireball","Spell", 5);
        this.defensiveStuff = new Potion("Small Heal", "Potion", 3);
    }

    public Magician(String genre, String name) {
        super(name, genre);
        this.HP = 6;
        this.attackPower = 15;
        this.offensiveStuff = new Spell("Fireball","Spell", 5);
        this.defensiveStuff = new Potion("Small Heal", "Potion", 3);
    }
    public String showNameGenreClass(Personnage character){
        return "Here is you character :\n"+
                "name : "+ this.name+ " |genre : " + this.genre + " |class : Magician";
    }
}
