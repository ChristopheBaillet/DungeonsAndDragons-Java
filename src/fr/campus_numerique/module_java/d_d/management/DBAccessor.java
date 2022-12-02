package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.character.Hero;

import java.sql.*;

public class DBAccessor {
    private static DBAccessor INSTANCE = null;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/d&d";
    private static final String USER = "christophe";
    private static final String PASS = "";
    private Connection conn;

    private DBAccessor() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DBAccessor getInstance(){
        if (INSTANCE == null){
            INSTANCE = new DBAccessor();
        }
        return INSTANCE;
    }

    public ResultSet selectHeroList() {
        String QUERY = "SELECT * FROM hero";
        PreparedStatement stmt;
        try{
            stmt = conn.prepareStatement(QUERY);
            return stmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet selectHero(int id) {
        String QUERY = "SELECT * FROM hero WHERE id = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(QUERY);
            stmt.setInt(1, id);
            return stmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void saveHero(Hero character){
        String QUERY = "INSERT INTO `hero` (`type`, `hp`, `name`, `attackpower`, `offensivestuff`, `defensivestuff`) " +
                "VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(QUERY);
            stmt.setString(1, character.getType().getName());
            stmt.setInt(2,character.getHP());
            stmt.setString(3,character.getName());
            stmt.setInt(4,character.getAttackPower());
            stmt.setString(5,character.getOffensiveStuff().getType().getName());
            stmt.setString(6,character.getDefensiveStuff().getType().getName());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateHero(Hero character, int id) {
        String QUERY = "UPDATE hero SET " +
                "name  = ? , type = ? , hp = ?, attackpower =  ?,  offensivestuff = ?, defensivestuff = ?"+
                " WHERE id = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(QUERY);
            stmt.setString(1, character.getName());
            stmt.setString(2,character.getType().getName());
            stmt.setInt(3,character.getHP());
            stmt.setInt(4,character.getAttackPower());
            stmt.setString(5,character.getOffensiveStuff().getType().getName());
            stmt.setString(6,character.getDefensiveStuff().getType().getName());
            stmt.setInt(7, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeHero(int id) {
        String QUERY = "DELETE FROM hero WHERE id = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(QUERY);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
