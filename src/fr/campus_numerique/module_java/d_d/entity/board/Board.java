package fr.campus_numerique.module_java.d_d.entity.board;

import fr.campus_numerique.module_java.d_d.entity.character.EnemyTypes;
import fr.campus_numerique.module_java.d_d.entity.character.CharactersFactory;
import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsFactory;
import fr.campus_numerique.module_java.d_d.entity.stuff.ItemsTypes;

import fr.campus_numerique.module_java.d_d.exception.CharacterOutsideOfBoardException;
import fr.campus_numerique.module_java.d_d.management.GameStatus;
import fr.campus_numerique.module_java.d_d.utilitary.Color;

import java.util.*;

public class Board {
    private int playerPosition;
    private final int nbCases = 64;
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

    public Board(boolean random) {
        if (random){
            generateRandomBoard();
        }else {
            generateBoard();
        }
    }

    private void generateBoard() {
        for (int i = 0; i < nbCases + 1; i++) {
            this.boxes.add(addCaseToBoard(i));
        }
    }

    public void display() {
        for (int i = 0; i < this.boxes.size(); i++) {
            if (i == this.playerPosition) {
                System.out.print(Color.GREEN + "You" + Color.RESET );
            } else if (i < this.playerPosition) {
                System.out.print(boxes.get(i).display());
            } else {
                System.out.print("...");
            }
            System.out.print("|");
        }
        System.out.println();
    }

    public void initialize(Hero character) {
        this.status = GameStatus.ON_GOING;
        character.reset();
        this.playerPosition = 0;
    }

    public void acceptPlayerAt(int pos) throws CharacterOutsideOfBoardException {
        if (pos >= nbCases || pos < 0) {
            throw new CharacterOutsideOfBoardException();
        }
    }

    private Case addCaseToBoard(int position) {
        return switch (position) {
            case 45, 52, 56, 62 -> CharactersFactory.createEnemy(EnemyTypes.DRAGON);
            case 10, 20, 25, 32, 35, 36, 37, 40, 44, 47 -> CharactersFactory.createEnemy(EnemyTypes.WIZARD);
            case 3, 6, 9, 12, 15, 18, 21, 24, 27, 30 -> CharactersFactory.createEnemy(EnemyTypes.GOBLIN);
            case 2, 11, 5, 22, 38 ->ItemsFactory.createItem(ItemsTypes.CLUB);
            case 19, 26, 42, 53 ->ItemsFactory.createItem(ItemsTypes.SWORD);
            case 1, 4, 8, 17, 23 -> ItemsFactory.createItem(ItemsTypes.LIGHTNING_BOLT);
            case 48, 49 -> ItemsFactory.createItem(ItemsTypes.FIREBALL);
            case 7, 13, 31, 33, 39, 43 -> ItemsFactory.createItem(ItemsTypes.POTION);
            case 28, 41 -> ItemsFactory.createItem(ItemsTypes.BIG_POTION);
            default -> new EmptyCase();
        };
    }
    private void generateRandomBoard() {
        ArrayList<Integer> availableIndex = new ArrayList<>();
        for (int i = 0; i< nbCases; i++){
            availableIndex.add(i, i);
        }
        Random random = new Random();
        this.boxes.add(addCaseToBoard(0));
        while (availableIndex.size() != 0){
            int randomIndex = random.nextInt(availableIndex.size());
            this.boxes.add(addCaseToBoard(randomIndex));
            availableIndex.remove(randomIndex);
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

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }
}
