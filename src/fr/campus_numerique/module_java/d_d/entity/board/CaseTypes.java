package fr.campus_numerique.module_java.d_d.entity.board;

public enum CaseTypes {
    EMPTY(10),
    DRAGON(3),
    WIZARD(6),
    GOBLIN(10),
    ROBBER(6),
    SWORD(3),
    CLUB(3),
    FIREBALL(3),
    LIGHTNING_BOLT(3),
    POTION(7),
    BIG_POTION(3);

    private final int number;

    CaseTypes (int number){
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }
}
