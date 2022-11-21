package fr.campus_numerique.module_java.d_d.entity.stuff.items;

public class BigPotion extends Potion{
    public BigPotion(int level) {
        super(level);
    }

    @Override
    public String toString(){
        return "Big potion";
    }
}
