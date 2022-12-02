package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.character.Hero;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBCharacter implements CharacterPersistence {
    private DBAccessor DB = DBAccessor.getInstance();

    @Override
    public Hero load(int id) {
        ResultSet data = DB.selectHero(id);

        try {
            if(data.next()){
                return CharacterDBFactory.createCharacterFromDBSource(data);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Integer, Hero> loadAll() {
        ResultSet data = DB.selectHeroList();
        try {
            return CharacterDBFactory.createCharacterList(data);
        } catch (SQLException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    @Override
    public void save(Hero character) {
        DB.saveHero(character);
    }

    @Override
    public void update(Hero character, int id) {
        DB.updateHero(character, id);
    }

    @Override
    public void remove(int id) {
        DB.removeHero(id);
    }
}
