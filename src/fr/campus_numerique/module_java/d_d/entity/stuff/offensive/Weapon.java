package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.character.type.Warrior;

abstract public class Weapon extends OffensiveStuff {
    public Weapon(String name, int power) {
        super(name, power);
    }

    @Override
    public String toString() {
        return "Weapon " + getName();
    }

    @Override
    public void interact(Hero character) {
        if (character instanceof Warrior){
            System.out.println("Vous trouvez " + this + " et vous recevez un boost de " + getPower() + "points de dégats");
            character.setAttackPower(character.getAttackPower() + getPower());
        }else {
            System.out.println("Vous ne ramasser pas l'arme, vous êtes un Mage après tout, les armes c'est pour les gueux.");
        }
    }

    @Override
    public void delete() {

    }
}
