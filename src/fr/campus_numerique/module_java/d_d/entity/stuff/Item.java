package fr.campus_numerique.module_java.d_d.entity.stuff;

import fr.campus_numerique.module_java.d_d.entity.board.Case;

abstract public class Item implements Case {
    private String name;
    private int power;

    public Item(int power){
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}