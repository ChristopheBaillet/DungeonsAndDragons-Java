package fr.campus_numerique.module_java.d_d.entity.stuff.defensive;

import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;

public class Robe extends DefensiveStuff {
    public Robe(String name, int power) {
        super(name, power);
    }


    @Override
    public void interact(Personage character) {
        System.out.println(this);
    }

    @Override
    public void delete() {

    }
}
