package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.board.Box;
import fr.campus_numerique.module_java.d_d.entity.type.Personnage;

import java.util.Arrays;
public class Board {
    private final int nbCases = 64;
    private String status;
    private final Box[] boxes = new Box[nbCases];
    public Board(){
        for (int i = 0; i < this.boxes.length ; i++){
            this.boxes[i] = new Box(i+1);
        }
    }

    @Override
    public String toString() {
        return "Board{" +
                "status='" + status + '\'' +
                ", cases=" + Arrays.toString(boxes) +
                '}';
    }

    public void printArray(Box[] boxes, int playerPosition){
        for (Box c : boxes) {
            if (c.getNumber() == playerPosition){
                System.out.print("|***");
            }else {
                System.out.print("|"+c.getNumber());
            }
        }
        System.out.println("");
    }
    public void initialize(Personnage character){
        this.status = "playing";
        character.setPosition(1);
    }

    public String getStatus() {
        return status;
    }
    public Box[] getCases() {
        return boxes;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNbCases() {
        return nbCases;
    }
}
