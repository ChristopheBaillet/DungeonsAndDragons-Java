package fr.campus_numerique.module_java.d_d.character;

import fr.campus_numerique.module_java.d_d.Utilitaire;
import fr.campus_numerique.module_java.d_d.character.stuff.defensive.DefensiveStuff;
import fr.campus_numerique.module_java.d_d.character.stuff.offensive.OffensiveStuff;

import java.util.Random;

 abstract public class Personnage {
    protected String classe, name;
    protected int HP, attackPower;
    protected String genre;
    protected int position;
    protected OffensiveStuff offensiveStuff;
    protected DefensiveStuff defensiveStuff;

    protected final Random rand = new Random();
    protected static final String[] namesMale = {
            "Tebald", "Wy", "Hutch", "Hamelot", "Wilkie", "Jem", "Rainerus", "Samson", "Sanses", "Tommie",
            "Victor", "Vicar", "Tybost", "Jarvis", "Hugues", "Ancelm", "Tomasin", "Jacques", "Brock"
    };

    protected static final String[] namesFemale = {
            "Nanette", "Crystina", "Lizbeth", "Emeline", "Besseta", "Tephania", "Tetty", "Farfelee",
            "Magdalene", "Madeleine", "Sallie", "Linyive", "Macie", "Richmal", "Sully", "Jeene", "Lillian", "Eliza"
    };

    public Personnage(String classe) {
        this.classe = classe;
        this.genre = chooseRandomGenre();
        this.name = chooseRandomName(this.genre);
    }
    public Personnage(String name, String genre) {
        chooseRandomClass();
        this.genre = genre;
        this.name = name;
    }

    public Personnage(String classe, String name, String genre) {
        this.classe = classe;
        this.genre = genre;
        this.name = name;
    }

    @Override
    public String toString() {
        return "fr.campus_numerique.module_java.d_d.character.Personnage { " +
                "classe = " + classe + "\n" +
                "name = " + name + "\n" +
                "genre = " + genre + "\n"+
                "HP = " + HP + "\n"+
                "attackPower = " + attackPower +"\n"+
                offensiveStuff +"\n"+
                defensiveStuff +"\n"+
                '}';
    }

    static String chooseRandomGenre() {
        return Utilitaire.randomBetweenTwoStrings("Male","Female");
    }
    static String chooseRandomClass(){
        return Utilitaire.randomBetweenTwoStrings("fr.campus_numerique.module_java.d_d.character.type.Warrior", "fr.campus_numerique.module_java.d_d.character.type.Magician");
    }

    public static String chooseRandomName(String genre){
        String name = "";
        switch (genre) {
            case "Male" -> {
                name = Utilitaire.getRandomStringFromArray(namesMale);
            }
            case "Female" -> {
                name = Utilitaire.getRandomStringFromArray(namesFemale);
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