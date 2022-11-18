package fr.campus_numerique.module_java.d_d.entity.board;

import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.stuff.items.Potion;
import fr.campus_numerique.module_java.d_d.entity.stuff.offensive.Weapon;
import fr.campus_numerique.module_java.d_d.entity.character.type.Robber;

import java.util.ArrayList;

public class Board {
    private final int nbCases = 4;
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
        this.boxes.add(1,new Robber("Roger"));
        this.boxes.add(2,new Weapon("dague de débutant", 1));
        this.boxes.add(3, new Potion("Healing potion", 2));
    }

    public void printArray(ArrayList<Case> boxes, int playerPosition){
        for (int i = 0 ; i< boxes.size(); i++) {
            if (i == playerPosition){
                System.out.println(boxes.get(i) + " <--");
            }else {
                System.out.println(boxes.get(i));
            }
        }

    }
    public void initialize(Personage character){
        this.status = "playing";
        character.setPosition(0);
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
