package fr.campus_numerique.module_java.d_d.entity.board;

import fr.campus_numerique.module_java.d_d.entity.character.Enemy;
import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.utilitary.Color;

public class EmptyCase implements Case {
    @Override
    public String toString() {
        return "Empty";
    }

    @Override
    public void interact(Hero character) {
        System.out.println("Ceci est un " + this);
    }
    @Override
    public void delete() {

    }

    @Override
    public String display() {
        return Color.YELLOW + "..." + Color.RESET;
    }

    @Override
    public boolean canInteract(){
        return true;
    }
}
