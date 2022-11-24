package fr.campus_numerique.module_java.d_d.entity.character;

import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.utilitary.Color;

abstract public class Enemy extends Personage implements Case {
    public Enemy(CharacterTypes type) {
        super(type);
    }

    @Override
    public void interact(Personage character) {
        character.setHP(character.getHP() - getAttackPower());
    }

    @Override
    public void delete() {
    }

    @Override
    public String display() {
        return Color.RED.toString() + this + Color.RESET;
    }
}
