package fr.campus_numerique.module_java.d_d.entity.character;

import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.utilitary.Color;

abstract public class Enemy extends Personage implements Case {
    protected EnemyTypes type;
    public Enemy(EnemyTypes type) {
        super(type.getName());
        this.type = type;
        this.maxHP = type.getHP();
        this.HP = maxHP;
        this.attackPower = type.getAttackPower();
    }

    @Override
    public void interact(Hero character) {
        int attack = character.getAttackPower() + character.getOffensiveStuff().getPower();
        System.out.println("Vous avez infligé " + Color.GREEN + attack + Color.RESET + " points de dégats avec votre " + character.getOffensiveStuff() + ".");
        this.setHP(this.HP - attack);
        if (this.HP <= 0) {
            System.out.println(this + " est mort.");
        } else {
            System.out.println(this + " réplique et vous inflige " + Color.RED + this.getAttackPower() + Color.RESET + " points de dégats");
            character.setHP(character.getHP() - getAttackPower());
        }
    }

    private void fight(Personage character) {

    }

    public boolean fightIsFinished(Personage character){
        return this.HP <= 0 || character.getHP() <= 0;
    }

    @Override
    public boolean canInteract() {
        return this.HP > 0;
    }

    @Override
    public void delete() {
    }

    @Override
    public String display() {
        if (this.HP <= 0) {
            return this + " dead body";
        } else {
            return Color.RED.toString() + this + Color.RESET;
        }

    }
}
