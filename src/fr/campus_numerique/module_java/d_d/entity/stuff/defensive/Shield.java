package fr.campus_numerique.module_java.d_d.entity.stuff.defensive;

public class Shield extends DefensiveStuff{
    public Shield(String name, int power) {
        super(name, power);
    }

    @Override
    public String toString(){
        return "Shield " + getName();
    }
}
