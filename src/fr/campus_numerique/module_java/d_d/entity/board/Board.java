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

import java.util.ArrayList;

public class Board {
    private int nbCases;
    private String status;
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
        this.boxes.add(new EmptyCase());
        this.boxes.add(CharactersFactory.createEnemy(CharacterTypes.ROBBER));
        this.boxes.add(ItemsFactory.createItem(ItemsTypes.SWORD));
        this.boxes.add(ItemsFactory.createItem(ItemsTypes.POTION));
        this.boxes.add(ItemsFactory.createItem(ItemsTypes.CLUB));
        this.boxes.add(ItemsFactory.createItem(ItemsTypes.FIREBALL));
        this.boxes.add(ItemsFactory.createItem(ItemsTypes.BIG_POTION));
        this.boxes.add(CharactersFactory.createEnemy(CharacterTypes.DRAGON));
        this.boxes.add(CharactersFactory.createEnemy(CharacterTypes.GOBLIN));
        this.boxes.add(CharactersFactory.createEnemy(CharacterTypes.WIZARD));
        this.boxes.add(ItemsFactory.createItem(ItemsTypes.LIGHTNING_BOLT));
        this.nbCases = this.boxes.size();
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
        this.status = "playing";
        character.setPosition(0);
    }

    public void acceptPlayerAt(int pos) throws CharacterOutsideOfBoardException {
        if (pos >= nbCases && pos < 0){
            throw new CharacterOutsideOfBoardException();
        }
    }

    public String getStatus() {
        return status;
    }
    public ArrayList<Case> getBoxes() {
        return boxes;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNbCases() {
        return nbCases;
    }
}
