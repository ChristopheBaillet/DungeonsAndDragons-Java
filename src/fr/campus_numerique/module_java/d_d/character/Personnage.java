package fr.campus_numerique.module_java.d_d.character;

import fr.campus_numerique.module_java.d_d.Utilitaire;
import fr.campus_numerique.module_java.d_d.character.stuff.defensive.DefensiveStuff;
import fr.campus_numerique.module_java.d_d.character.stuff.offensive.OffensiveStuff;

 abstract public class Personnage {
    protected String name,genre;
    protected int HP, attackPower,position;
    protected OffensiveStuff offensiveStuff;
    protected DefensiveStuff defensiveStuff;
    protected static final String[] namesMale = {
            "Tebald", "Wy", "Hutch", "Hamelot", "Wilkie", "Jem", "Rainerus", "Samson", "Sanses", "Tommie",
            "Victor", "Vicar", "Tybost", "Jarvis", "Hugues", "Ancelm", "Tomasin", "Jacques", "Brock"
    };

    protected static final String[] namesFemale = {
            "Nanette", "Crystina", "Lizbeth", "Emeline", "Besseta", "Tephania", "Tetty", "Farfelee",
            "Magdalene", "Madeleine", "Sallie", "Linyive", "Macie", "Richmal", "Sully", "Jeene", "Lillian", "Eliza"
    };

    public Personnage(String name, String genre) {
        this.genre = genre;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Personnage { " +
                "name = " + name + "\n" +
                "genre = " + genre + "\n"+
                "HP = " + HP + "\n"+
                "attackPower = " + attackPower +"\n"+
                offensiveStuff +"\n"+
                defensiveStuff +"\n"+
                '}';
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
    }abstract public String showNameGenreClass(Personnage character);

    public int getHP() {
        return HP;
    }

    public int getAttackPower() {
        return attackPower;
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