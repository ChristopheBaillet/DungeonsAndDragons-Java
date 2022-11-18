package fr.campus_numerique.module_java.d_d.entity.stuff.defensive;

public class Robe extends DefensiveStuff{
    public Robe(String name, int power) {
        super(name, power);
    }

    @Override
    public String toString(){
        return "Robe " + getName();
    }
}
