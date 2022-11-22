package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

public class Sword extends Weapon {
    public Sword(String name,int power) {
        super(name, power);
    }

    @Override
    public String toString(){
        return "Sword";
    }
}
