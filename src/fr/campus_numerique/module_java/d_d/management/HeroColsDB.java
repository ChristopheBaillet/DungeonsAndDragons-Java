package fr.campus_numerique.module_java.d_d.management;

public enum HeroColsDB {
    NAME("name"),
    ID("id"),
    HP("hp"),
    TYPE("type"),
    ATTACK_POWER("attackpower"),
    OFFENSIVE_STUFF("offensivestuff"),
    DEFENSIVE_STUFF("defensivestuff");
    private final String name;
    HeroColsDB (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
