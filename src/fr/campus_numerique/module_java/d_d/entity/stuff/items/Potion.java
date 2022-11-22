package fr.campus_numerique.module_java.d_d.entity.stuff.items;

import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.stuff.Item;

public class Potion extends Item implements Case {
    private int power;
    public Potion(String name, int power){
        super(name);
        this.power = power;
    }
    @Override
    public String toString(){
        return "Potion";
    }

    @Override
    public void interact(Personage character) {
        System.out.println("Ceci est un "+this);
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
