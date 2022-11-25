package fr.campus_numerique.module_java.d_d.entity.stuff;

import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.utilitary.Color;

abstract public class Item implements Case {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public String display() {
        return Color.BLUE.toString() + this + Color.RESET;
    }

    @Override
    public boolean canInteract(){
        return true;
    }
}