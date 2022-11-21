package fr.campus_numerique.module_java.d_d.entity.stuff.offensive;

public class LightningBolt extends Spell {
    public LightningBolt(int power) {
        super(power);
    }

    @Override
    public String toString(){
        return "Lightning Bolt";
    }
}
