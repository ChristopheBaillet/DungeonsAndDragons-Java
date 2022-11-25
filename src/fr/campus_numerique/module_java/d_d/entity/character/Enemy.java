package fr.campus_numerique.module_java.d_d.entity.character;

import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.utilitary.Color;

abstract public class Enemy extends Personage implements Case {
    public Enemy(CharacterTypes type) {
        super(type);
    }

    @Override
    public void interact(Personage character) {
        int attack = character.getAttackPower() + character.getOffensiveStuff().getPower();
        System.out.println("Vous vous retrouver face à face avec un " + this.getName());
        System.out.println("Vous avez infligé " + Color.GREEN + attack + Color.RESET +" points de dégats avec votre " + character.getOffensiveStuff()+ ".");
        this.setHP(this.HP - attack);
        if (this.HP <= 0){
            System.out.println(this + " est mort.");
        }else {
            System.out.println(this + " réplique et vous inflige "+Color.RED+ this.getAttackPower()+Color.RESET+ " points de dégats");
            System.out.println(this + " s'enfuit.");
            character.setHP(character.getHP() - getAttackPower());
        }
    }


    @Override
    public boolean canInteract(){
        return this.HP > 0;
    }
    @Override
    public void delete() {
    }

    @Override
    public String display() {
        if (this.HP <= 0 ){
            return  this + " dead body";
        }else {
            return Color.RED.toString() + this + Color.RESET;
        }

    }
}
