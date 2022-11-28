package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.character.type.Magician;

abstract public class Spell extends OffensiveStuff {
    public Spell(String name,int power) {
        super(name, power);
    }

    @Override
    public String toString() {
        return "Spell " + getName();
    }
    @Override
    public void interact(Hero character) {
        if (character instanceof Magician){
            System.out.println("Vous trouvez " + this + " et vous recevez un boost de " + getPower() + "points de dégats");
            character.setAttackPower(getPower()+ character.getAttackPower());
        }else {
            System.out.println("Par la barbe de mes ancetres, mais c'est un bouquin, pourquoi je devrais le ramasser, les bouquins c'est pour les nerds");
        }
    }

    @Override
    public void delete() {

    }
}
