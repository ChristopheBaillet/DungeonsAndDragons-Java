package fr.campus_numerique.module_java.d_d.entity.stuff.items;

import fr.campus_numerique.module_java.d_d.entity.stuff.Item;

public class Potion extends Item {
    public Potion(String name, int power){
        super(name,power);
    }

    @Override
    public String toString(){
        return "Potion";
    }

    @Override
    public void interact() {

    }

    @Override
    public void delete() {

    }
}
