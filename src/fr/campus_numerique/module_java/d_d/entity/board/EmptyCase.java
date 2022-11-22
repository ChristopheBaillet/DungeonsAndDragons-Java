package fr.campus_numerique.module_java.d_d.entity.board;

import fr.campus_numerique.module_java.d_d.entity.character.Personage;

public class EmptyCase implements Case{
    @Override
    public String toString(){
        return "Empty";
    }

    @Override
    public void interact(Personage character) {
        System.out.println("Ceci est un "+this);
    }

    @Override
    public void delete() {

    }
}
