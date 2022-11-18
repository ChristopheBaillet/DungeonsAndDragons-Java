package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

import fr.campus_numerique.module_java.d_d.entity.board.Case;

public class Spell extends OffensiveStuff implements Case {
    public Spell(String name, int power) {
        super(name, power);
    }

    @Override
    public String toString(){
        return "Spell " + getName();
    }
}
