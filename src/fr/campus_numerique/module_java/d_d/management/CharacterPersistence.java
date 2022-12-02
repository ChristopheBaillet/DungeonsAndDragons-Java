package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.character.Hero;

import java.util.Map;

public interface CharacterPersistence {
    Hero load(int id);
    Map<Integer, Hero> loadAll();
    void save(Hero character);
    void update(Hero character, int id);
    void remove(int id);
}
