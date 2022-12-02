package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.character.type.Magician;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsTypes;

abstract public class Spell extends OffensiveStuff {
    public Spell(String name, ItemsTypes type) {
        super(name, type);
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
