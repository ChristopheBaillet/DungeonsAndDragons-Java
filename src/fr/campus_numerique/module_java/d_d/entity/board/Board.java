package fr.campus_numerique.module_java.d_d.entity.board;

import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.character.type.Dragon;
import fr.campus_numerique.module_java.d_d.entity.character.type.Goblin;
import fr.campus_numerique.module_java.d_d.entity.character.type.Robber;
import fr.campus_numerique.module_java.d_d.entity.character.type.Wizard;
import fr.campus_numerique.module_java.d_d.entity.stuff.items.BigPotion;
import fr.campus_numerique.module_java.d_d.entity.stuff.items.Potion;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.*;
import fr.campus_numerique.module_java.d_d.exception.CharacterOutsideOfBoardException;

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

    public Board(){
        this.boxes.add(0,new EmptyCase());
        this.boxes.add(1,new Robber());
        this.boxes.add(2,new Sword( 1));
        this.boxes.add(3, new Potion(1));
        this.boxes.add(4, new Club(6));
        this.boxes.add(5, new Fireball(10));
        this.boxes.add(6, new BigPotion(10));
        this.boxes.add(7, new Dragon());
        this.boxes.add(8, new Goblin());
        this.boxes.add(9, new Wizard());
        this.boxes.add(10, new LightningBolt(20));
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
