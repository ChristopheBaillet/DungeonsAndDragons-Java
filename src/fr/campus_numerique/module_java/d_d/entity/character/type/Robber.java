package fr.campus_numerique.module_java.d_d.entity.character.type;

import fr.campus_numerique.module_java.d_d.entity.character.Enemy;

public class Robber extends Enemy {
    public Robber(String name){
        super(name);
    }

    @Override
    public String toString(){
        return "Robber " + getName();
    }

    @Override
    public void interact() {

    }

    @Override
    public void delete() {

    }
}
