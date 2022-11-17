package fr.campus_numerique.module_java.d_d;

public class Stuff {
    private String offensive,defensive;
    public Stuff(String offensiveStuff,String defensiveStuff){
        this.offensive = offensiveStuff;
        this.defensive = defensiveStuff;
    }

    public String getOffensive() {
        return offensive;
    }

    public void setOffensive(String offensive) {
        this.offensive = offensive;
    }

    public String getDefensive() {
        return defensive;
    }

    public void setDefensive(String defensive) {
        this.defensive = defensive;
    }
}
