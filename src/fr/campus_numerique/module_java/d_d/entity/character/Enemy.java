package fr.campus_numerique.module_java.d_d.entity.character;

import fr.campus_numerique.module_java.d_d.entity.board.Case;

abstract public class Enemy extends Personage implements Case  {
    public Enemy(String name){
        super(name);
    }
}
