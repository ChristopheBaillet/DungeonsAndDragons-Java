public class Personnage {
    private String classe, name;
    private int HP, attackPower;
    private OffensiveStuff offensiveStuff;
    private DefensiveStuff defensiveStuff;

    public Personnage(){

    }

    public Personnage(String name){
        this.name = name;
    }

    public Personnage(String classe, String name){
        if (classe.equals("Warrior")) {
            this.HP = 10;
            this.attackPower = 10;
            this.defensiveStuff = new DefensiveStuff("armure rouillée","Armure",3);
            this.offensiveStuff = new OffensiveStuff("épée rouillée","Arme", 1);
        }else {
            this.HP = 6;
            this.attackPower = 15;
            this.defensiveStuff = new DefensiveStuff("robe de chambre","Robe",1);
            this.offensiveStuff = new OffensiveStuff("baton miteux","Sort",3);
        }
        this.classe = classe;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Personnage : {\n" +
                "\tclasse = " + classe + "\n" +
                "\tname = " + name + "\n" +
                "\tHP = " + HP + "\n" +
                "\tattackPower =" + attackPower + "\n" +
                "\tstuff =\t" + defensiveStuff + "\n\t\t\t" + offensiveStuff + "\n" +
                '}';
    }

    public int getHP() {
        return HP;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getClasse() {
        return classe;
    }

    public String getName() {
        return name;
    }


    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setName(String name) {
        this.name = name;
    }


    public OffensiveStuff getOffensiveStuff() {
        return offensiveStuff;
    }

    public void setOffensiveStuff(OffensiveStuff offensiveStuff) {
        this.offensiveStuff = offensiveStuff;
    }

    public DefensiveStuff getDefensiveStuff() {
        return defensiveStuff;
    }

    public void setDefensiveStuff(DefensiveStuff defensiveStuff) {
        this.defensiveStuff = defensiveStuff;
    }
}
