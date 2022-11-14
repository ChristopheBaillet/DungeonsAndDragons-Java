import java.util.Random;

public class Personnage {
    private String classe, name;
    private int HP, attackPower;
    private OffensiveStuff offensiveStuff;
    private DefensiveStuff defensiveStuff;

    private final Random rand = new Random();

    private final String[] namesMale = {
            "Tebald", "Wy", "Hutch", "Hamelot", "Wilkie", "Jem", "Rainerus", "Samson", "Sanses", "Tommie",
            "Victor", "Vicar", "Tybost", "Jarvis", "Hugues", "Ancelm", "Tomasin", "Jacques", "Brock"
    };

    private final String[] namesFemale = {
            "Nanette", "Crystina", "Lizbeth", "Emeline", "Besseta", "Tephania", "Tetty", "Farfelee",
            "Magdalene", "Madeleine", "Sallie", "Linyive", "Macie", "Richmal", "Sully", "Jeene", "Lillian", "Eliza"
    };

    private final OffensiveStuff[] warriorOffensiveStuff = {
            new OffensiveStuff("Epée rouillée", "Arme",1),
            new OffensiveStuff("Marteau fendu", "Arme", 3),
            new OffensiveStuff("Bout de lance", "Arme", 2)
    };

    private final DefensiveStuff[] warriorDefensiveStuff = {
            new DefensiveStuff("Armure rouillée", "Armure",2),
            new DefensiveStuff("Etoffe roussie", "Armure", 1),
            new DefensiveStuff("Armure de fer", "Armure", 3)
    };

    private final OffensiveStuff[] magicianOffensiveStuff = {
            new OffensiveStuff("Bout de bois", "Sort",1),
            new OffensiveStuff("Grimoire déchiré", "Sort", 3),
            new OffensiveStuff("Arcanes du débutant", "Sort", 2)
    };

    private final DefensiveStuff[] magicianDefensiveStuff = {
            new DefensiveStuff("Toge de moine", "Robe",2),
            new DefensiveStuff("Robe de chambre", "Robe", 1),
            new DefensiveStuff("Manteau mystérieux", "Robe", 3)
    };
    public Personnage() {
        chooseRandomClass();
        chooseRandomName(rand.nextInt(2));
    }

    public Personnage(String name) {
        chooseRandomClass();
        this.name = name;
    }

    public Personnage(String classe, String name) {
        if (classe.equals("Warrior")) {
            this.HP = 10;
            this.attackPower = 10;
            this.defensiveStuff = warriorDefensiveStuff[rand.nextInt(warriorDefensiveStuff.length)];
            this.offensiveStuff = warriorOffensiveStuff[rand.nextInt(warriorOffensiveStuff.length)];
        } else {
            this.HP = 6;
            this.attackPower = 15;
            this.defensiveStuff = magicianDefensiveStuff[rand.nextInt(magicianDefensiveStuff.length)];
            this.offensiveStuff = magicianOffensiveStuff[rand.nextInt(magicianOffensiveStuff.length)];
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

    private void chooseRandomClass(){
        int randClass = rand.nextInt(2);
        switch (randClass) {
            case 0 -> {
                this.HP = 10;
                this.attackPower = 10;
                this.defensiveStuff = warriorDefensiveStuff[rand.nextInt(warriorDefensiveStuff.length)];
                this.offensiveStuff = warriorOffensiveStuff[rand.nextInt(warriorOffensiveStuff.length)];
                this.classe = "Warrior";
            }
            case 1 -> {
                this.HP = 6;
                this.attackPower = 15;
                this.defensiveStuff = magicianDefensiveStuff[rand.nextInt(magicianDefensiveStuff.length)];
                this.offensiveStuff = magicianOffensiveStuff[rand.nextInt(magicianOffensiveStuff.length)];
                this.classe = "Magician";
            }
        }
    }


    public void chooseRandomName(int randGenre){
        int randName;
        switch (randGenre) {
            case 0 -> {
                randName = rand.nextInt(this.namesMale.length);
                this.name = namesMale[randName];
            }
            case 1 -> {
                randName = rand.nextInt(this.namesFemale.length);
                this.name = namesFemale[randName];
            }
        }
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
