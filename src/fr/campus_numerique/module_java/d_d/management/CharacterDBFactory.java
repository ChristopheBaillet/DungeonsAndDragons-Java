package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.character.CharactersFactory;
import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.character.HeroTypes;
import fr.campus_numerique.module_java.d_d.entity.character.type.Magician;
import fr.campus_numerique.module_java.d_d.entity.character.type.Warrior;
import fr.campus_numerique.module_java.d_d.exception.ItemException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;



public class CharacterDBFactory {
    public static Hero createCharacterFromDBSource(ResultSet resultData) throws SQLException {
        String type = resultData.getString(HeroColsDB.TYPE.getName());
        String name = resultData.getString(HeroColsDB.NAME.getName());
        int hp = resultData.getInt(HeroColsDB.HP.getName());
        int attackPower = resultData.getInt(HeroColsDB.ATTACK_POWER.getName());
        String defensiveStuff = resultData.getString(HeroColsDB.DEFENSIVE_STUFF.getName());
        String offensiveStuff = resultData.getString(HeroColsDB.OFFENSIVE_STUFF.getName());
        try {
            return switch (type){
                case "Warrior" -> CharactersFactory.createCharacterFromDB(name,hp,attackPower,offensiveStuff,defensiveStuff,HeroTypes.WARRIOR);
                case "Magician" -> CharactersFactory.createCharacterFromDB(name,hp,attackPower,offensiveStuff,defensiveStuff,HeroTypes.MAGICIAN);
                default -> null;
            };
        }catch (ItemException e){
            e.printStackTrace();
        }
        return null;
    }
    public static Map<Integer, Hero> createCharacterList(ResultSet resultData) throws SQLException {
        Map<Integer, Hero> result = new HashMap<>();
        while (resultData.next()){
            Hero current = createCharacterFromDBSource(resultData);
            int id = resultData.getInt("id");
            result.put(id, current);
        }
        return result;
    }
}
