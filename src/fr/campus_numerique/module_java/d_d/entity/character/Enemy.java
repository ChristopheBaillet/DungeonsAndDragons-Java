package fr.campus_numerique.module_java.d_d.entity.character;

import fr.campus_numerique.module_java.d_d.entity.board.Case;

abstract public class Enemy extends Personage implements Case {
    private int attackPower;

    public Enemy(CharacterTypes type) {
        super(type);
    }

    @Override
    public void interact(Personage character) {

    }

    @Override
    public void delete() {

    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
