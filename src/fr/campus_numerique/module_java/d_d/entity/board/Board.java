package fr.campus_numerique.module_java.d_d.entity.board;

import fr.campus_numerique.module_java.d_d.entity.character.CharacterTypes;
import fr.campus_numerique.module_java.d_d.entity.character.CharactersFactory;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.character.type.Dragon;
import fr.campus_numerique.module_java.d_d.entity.character.type.Goblin;
import fr.campus_numerique.module_java.d_d.entity.character.type.Robber;
import fr.campus_numerique.module_java.d_d.entity.character.type.Wizard;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsFactory;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsTypes;
import fr.campus_numerique.module_java.d_d.entity.stuff.items.BigPotion;
import fr.campus_numerique.module_java.d_d.entity.stuff.items.Potion;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.*;
import fr.campus_numerique.module_java.d_d.exception.CharacterOutsideOfBoardException;
import fr.campus_numerique.module_java.d_d.exception.ItemException;
import fr.campus_numerique.module_java.d_d.management.GameStatus;

import java.util.ArrayList;

public class Board {
    private int nbCases;
    private GameStatus status;
    private final ArrayList<Case> boxes = new ArrayList<>();

    @Override
    public String toString() {
        return "Board{" +
                "nbCases=" + nbCases +
                ", status='" + status + '\'' +
                ", boxes=" + boxes +
                '}';
    }

    public Board() {
        this.nbCases = 64;
        for (int i = 1; i < nbCases +1  ;i++ ){
            switch (i){
                case 45, 52, 56, 62 -> this.boxes.add(CharactersFactory.createEnemy(CharacterTypes.DRAGON));
                case 10, 20, 25, 32, 35, 36, 37, 40, 44, 47 -> this.boxes.add(CharactersFactory.createEnemy(CharacterTypes.WIZARD));
                case 3, 6, 9 , 12, 15, 18, 21, 24, 27, 30 -> this.boxes.add(CharactersFactory.createEnemy(CharacterTypes.GOBLIN));
                case 2, 11, 5, 22, 38 -> this.boxes.add(ItemsFactory.createItem(ItemsTypes.CLUB));
                case 19, 26, 42 ,53 -> this.boxes.add(ItemsFactory.createItem(ItemsTypes.SWORD));
                case 1, 4 , 8, 17 ,23 -> this.boxes.add(ItemsFactory.createItem(ItemsTypes.LIGHTNING_BOLT));
                case 48, 49 -> this.boxes.add(ItemsFactory.createItem(ItemsTypes.FIREBALL));
                case 7, 13, 31, 33, 39, 43 -> this.boxes.add(ItemsFactory.createItem(ItemsTypes.POTION));
                case 28, 41 -> this.boxes.add(ItemsFactory.createItem(ItemsTypes.BIG_POTION));
            }
        }
    }

    public void printArray(ArrayList<Case> boxes, int playerPosition){
        for (int i = 0 ; i< boxes.size(); i++) {
            if (i == playerPosition){
                System.out.print("You");
            }else {
                System.out.print("...");
            }
            System.out.print("|");
        }
        System.out.println();
    }
    public void initialize(Personage character){
        this.status = GameStatus.ON_GOING;
        character.setPosition(0);
    }

    public void acceptPlayerAt(int pos) throws CharacterOutsideOfBoardException {
        if (pos >= nbCases && pos < 0){
            throw new CharacterOutsideOfBoardException();
        }
    }

    public GameStatus getStatus() {
        return status;
    }
    public ArrayList<Case> getBoxes() {
        return boxes;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public int getNbCases() {
        return nbCases;
    }
}
