package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.character.HeroTypes;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Database INSTANCE = null;
    static final String DB_URL = "jdbc:mysql://localhost:3306/d&d";
    static final String USER = "christophe";
    static final String PASS = "";
    private Statement stmt;

    private final Menu menu = Menu.getInstance();

    private final String name = HeroColsDB.NAME.getName();
    private final String hp = HeroColsDB.HP.getName();
    private final String offensiveStuff = HeroColsDB.OFFENSIVE_STUFF.getName();
    private final String defensiveStuff = HeroColsDB.DEFENSIVE_STUFF.getName();
    private final String type = HeroColsDB.TYPE.getName();
    private final String attackPower = HeroColsDB.ATTACK_POWER.getName();
    private final String id = HeroColsDB.ID.getName();

    private Database() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Database getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Database();
        return INSTANCE;
    }

    public void getHeroes() {
        try {
            String QUERY = "SELECT * FROM hero";
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                displayHero(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveHero(Hero character) {
        executeUpdate("INSERT INTO `hero` (`type`, `hp`, `name`, `attackpower`, `offensivestuff`, `defensivestuff`) VALUES ('" + character.getType().getName() + "', '" + character.getHP() + "', '" + character.getName() + "', '" + character.getAttackPower() + "', '" + character.getOffensiveStuff().getType().getName() + "', '" + character.getDefensiveStuff().getType().getName() + "')");
    }

    public void deleteHero(Hero character) {

    }

    private void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayHero(ResultSet rs) throws SQLException {
        System.out.print("ID: " + rs.getInt(id) + " ");
        System.out.print(", Type: " + rs.getString(type) + " ");
        System.out.print(", HP: " + rs.getInt(hp) + " ");
        System.out.print("Name: " + rs.getString(name) + " ");
        System.out.print(", AttackPower: " + rs.getInt(attackPower) + " ");
        System.out.print(", OffensiveStuff: " + rs.getString(offensiveStuff) + " ");
        System.out.println(", DefensiveStuff: " + rs.getString(defensiveStuff));
    }

    public void editHero(Hero character, HeroColsDB col) {
        HashMap<String,String> map = selectHero(character);
        switch (col){
            case NAME -> changeName(character);
            case HP -> changeLifePoints(character);
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private void changeName(Hero character) {
        try {
            String name = menu.askCharacterName();
            stmt.executeUpdate("UPDATE hero SET name  = '" + name + "' WHERE name = '" + character.getName() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String,String> selectHero(Hero character) {
        HashMap <String,String> map = new HashMap<>();
        try {
            ResultSet result = stmt.executeQuery("SELECT * FROM hero WHERE name = '" + character.getName() + "' ");
            if (result.next()){
                map.put(name, result.getString(name));
                map.put(type, result.getString(type));
                map.put(attackPower, String.valueOf(result.getInt(attackPower)));
                map.put(hp, String.valueOf(result.getInt(hp)));
                map.put(offensiveStuff,result.getString(offensiveStuff));
                map.put(defensiveStuff,result.getString(defensiveStuff));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void changeLifePoints(Hero character) {
        try {
            int hp = 3;
            stmt.executeUpdate("UPDATE hero SET hp  = " + hp + " WHERE name = " + character.getName() + "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}