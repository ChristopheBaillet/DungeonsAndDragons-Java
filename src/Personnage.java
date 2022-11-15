import java.util.Random;

public class Personnage {
    private String classe, name;
    private int HP, attackPower;
    private OffensiveStuff offensiveStuff;
    private DefensiveStuff defensiveStuff;

    private String genre;
    private int position;

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
        this.genre = chooseRandomGenre();
        chooseRandomClass();
        this.name = chooseRandomName(this.genre);
    }
    public Personnage(String name, String genre) {
        chooseRandomClass();
        this.genre = genre;
        this.name = name;
    }

    public Personnage(String classe, String name, String genre) {
        switch (classe){
            case "Warrior" -> {
                this.HP = 10;
                this.attackPower = 10;
                this.defensiveStuff = warriorDefensiveStuff[rand.nextInt(warriorDefensiveStuff.length)];
                this.offensiveStuff = warriorOffensiveStuff[rand.nextInt(warriorOffensiveStuff.length)];
            }
            case "Magician" -> {
                this.HP = 6;
                this.attackPower = 15;
                this.defensiveStuff = magicianDefensiveStuff[rand.nextInt(magicianDefensiveStuff.length)];
                this.offensiveStuff = magicianOffensiveStuff[rand.nextInt(magicianOffensiveStuff.length)];
            }
        }
        this.classe = classe;
        this.genre = genre;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Personnage { " +
                "classe = " + classe + "\n" +
                "name = " + name + "\n" +
                "HP = " + HP + "\n"+
                "attackPower = " + attackPower +"\n"+
                offensiveStuff +"\n"+
                defensiveStuff +"\n"+
                "genre = " + genre + "\n"+
                '}';
    }

    private String chooseRandomGenre() {
        return Utilitaire.randomBetweenTwoStrings("Male","Female");
    }
    private void chooseRandomClass(){
        String randClass = Utilitaire.randomBetweenTwoStrings("Warrior", "Magician");
        switch (randClass) {
            case "Warrior" -> {
                this.HP = 10;
                this.attackPower = 10;
                this.defensiveStuff = warriorDefensiveStuff[rand.nextInt(warriorDefensiveStuff.length)];
                this.offensiveStuff = warriorOffensiveStuff[rand.nextInt(warriorOffensiveStuff.length)];
            }
            case "Magician" -> {
                this.HP = 6;
                this.attackPower = 15;
                this.defensiveStuff = magicianDefensiveStuff[rand.nextInt(magicianDefensiveStuff.length)];
                this.offensiveStuff = magicianOffensiveStuff[rand.nextInt(magicianOffensiveStuff.length)];
            }
        }
        this.classe = randClass;
    }

    public String chooseRandomName(String genre){
        String name = "";
        switch (genre) {
            case "Male" -> {
                name = namesMale[rand.nextInt(this.namesMale.length)];
            }
            case "Female" -> {
                name = namesFemale[rand.nextInt(this.namesFemale.length)];
            }
        }
        return name;
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

    public void setDefensiveStuff(DefensiveStuff defensiveStuff) { this.defensiveStuff = defensiveStuff; }
    public int getPosition() { return position; }

    public void setPosition(int position) { this.position = position; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

}