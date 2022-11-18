package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

public class Spell extends OffensiveStuff {
    public Spell(String name, int power) {
        super(name, power);
    }

    @Override
    public String toString(){
        return "Spell " + getName();
    }

    @Override
    public void interact() {

    }

    @Override
    public void delete() {

    }
}
