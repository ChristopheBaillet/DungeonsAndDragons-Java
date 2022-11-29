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
        executeUpdate("INSERT INTO `hero` (`type`, `hp`, `name`, `attackpower`, `offensivestuff`, `defensivestuff`) VALUES ('" + character.getType().getName() + "', '" + character.getHP() + "', '" + character.getName() + "', '" + character.getAttackPower() + "', '" + character.getOffensiveStuff() + "', '" + character.getDefensiveStuff() + "')");
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
        System.out.print("ID: " + rs.getInt("id") + " ");
        System.out.print(", Type: " + rs.getString("type") + " ");
        System.out.print(", HP: " + rs.getInt("hp") + " ");
        System.out.print("Name: " + rs.getString("name") + " ");
        System.out.print(", AttackPower: " + rs.getInt("attackpower") + " ");
        System.out.print(", OffensiveStuff: " + rs.getString("offensivestuff") + " ");
        System.out.println(", DefensiveStuff: " + rs.getString("defensivestuff"));
    }

    public void editHero(Hero character) {

    }

    public HashMap<String,String> selectHero(Hero character) {
        HashMap <String,String> map = new HashMap<>();
        try {
            ResultSet result = stmt.executeQuery("SELECT * FROM hero WHERE name = " + character.getName() + "");
            ResultSet offResult = stmt.executeQuery("SELECT * FROM offensivestuff WHERE id = " + result.getInt("offensivestuff_id") + "");
            ResultSet defResult = stmt.executeQuery("SELECT * FROM defensivestuff WHERE id = " + result.getInt("defensivestuff_id") + "");
            map.put("name", result.getString("name"));
            map.put("type", result.getString("type"));
            map.put("attackPower", String.valueOf(result.getInt("attackpower")));
            map.put("hp", String.valueOf(result.getInt("hp")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void changeLifePoints(Hero character) {
        try {
            stmt.executeUpdate("UPDATE hero SET hp  = " + character.getHP() + " WHERE name = " + character.getName() + "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}