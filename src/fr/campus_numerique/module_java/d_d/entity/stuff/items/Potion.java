package fr.campus_numerique.module_java.d_d.entity.stuff.items;

import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.stuff.Item;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsTypes;

abstract public class Potion extends Item {
    private int power;

    public Potion(String name, ItemsTypes type) {
        super(name, type);
        this.power = type.getPower();
    }

    @Override
    public void interact(Hero character) {
        character.setHP(character.getHP() + power);
    }

    @Override
    public void delete() {

    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
