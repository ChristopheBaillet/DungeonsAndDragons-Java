package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.board.Board;
import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.entity.character.CharacterTypes;
import fr.campus_numerique.module_java.d_d.entity.character.CharactersFactory;
import fr.campus_numerique.module_java.d_d.entity.character.Enemy;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.stuff.Item;
import fr.campus_numerique.module_java.d_d.exception.CharacterOutsideOfBoardException;

import java.util.Random;


public class Game {
    private final Random random = new Random();
    private final Board board = new Board(true);
    private final Menu menu = new Menu();
    private Personage character;
    private GameStatus gameStatus;

    public Game() {
        do {
            gameStatus = menu.main(character);
            switch (gameStatus) {
                case CREATING_CHARACTER -> character = createCharacter();
                case ON_GOING -> playGame();
                case MODIFY -> System.out.println(character);
            }
        } while (gameStatus != GameStatus.QUIT_GAME);
    }

    private Personage createCharacter() {
        return defineCharacter(defineName());
    }

    private void exit() {
        gameStatus = GameStatus.QUIT_GAME;
    }

    private Personage defineCharacter(String name) {
        Personage character = null;
        switch (menu.askClass()) {
            case WARRIOR -> {
                character = CharactersFactory.createCharacter(CharacterTypes.WARRIOR, name);
            }
            case MAGICIAN -> {
                character = CharactersFactory.createCharacter(CharacterTypes.MAGICIAN, name);
            }
            case QUIT -> exit();
        }
        return character;
    }

    private String defineName() {
        return menu.askCharacterName();
    }

    private void playAgain() {
        switch (menu.askToPlayAgain()) {
            case PLAY_AGAIN -> playGame();
            case QUIT -> exit();
        }
    }

    private void playGame() {
        board.initialize();
        while (gameStatus == GameStatus.ON_GOING) {
            board.display();
            switch (menu.inGame()) {
                case PLAY -> {
                    try {
                        playATurn(character);
                    } catch (CharacterOutsideOfBoardException exception) {
                        System.out.println(exception);
                        playAgain();
                    }
                }
                case SHOW_INFOS -> System.out.println(character.getInfos());
                case QUIT -> exit();
                case HELP -> menu.showHelpInfos();
            }
        }
    }


    public void playATurn(Personage character) throws CharacterOutsideOfBoardException {
        int playerPosition = board.getPlayerPosition();
        int maxPosition = board.getNbCases();
        playerPosition = moveForward(random.nextInt(1, 6), playerPosition);
        if (playerPosition == maxPosition) {
            gameStatus = GameStatus.FINISHED;
            System.out.println("finished " + playerPosition);
        } else {
            board.setPlayerPosition(playerPosition);
            Case element = board.getBoxes().get(playerPosition);
            CaseType elmt = element instanceof Item ? CaseType.ITEM : element instanceof Enemy ? CaseType.ENEMY : CaseType.EMPTY;
            if (element.canInteract()) {
                switch (elmt) {
                    case EMPTY -> {
                        element.interact(character);
                    }
                    case ENEMY -> {
                        board.display();
                        UserChoice userChoice = null;
                        Enemy enemy = (Enemy) element;
                        System.out.println("Vous vous retrouver face à face avec un " + enemy.getName());
                        do {
                            switch (menu.askFightOrFlee(enemy)) {
                                case FIGHT -> {
                                    element.interact(character);
                                    userChoice = UserChoice.FIGHT;
                                }
                                case FLEE -> {
                                    userChoice = UserChoice.FLEE;
                                    moveBackward(playerPosition, random.nextInt(1,6));
                                    System.out.println(board.getPlayerPosition()+ " " + playerPosition);
                                }
                            }
                        }while (userChoice == UserChoice.FIGHT && !enemy.fightIsFinished(character));
                    }
                    case ITEM -> {
                        switch (menu.askTakeItem((Item) element)) {
                            case YES -> element.interact(character);
                            case NO -> {
                            }
                        }
                    }
                }
            }
            if (character.getHP() <= 0) {
                gameStatus = GameStatus.GAME_OVER;
                menu.gameOver();
            }
        }
    }

    private int moveForward(int number, int position) throws CharacterOutsideOfBoardException {
        int newPosition = position + number;
        board.acceptPlayerAt(newPosition);
        board.setPlayerPosition(newPosition);
        return newPosition;
    }

    private void moveBackward(int position, int number) throws CharacterOutsideOfBoardException {
        int newPosition = position - number;
        if (newPosition < 0){
            newPosition = 0;
        }
        board.acceptPlayerAt(newPosition);
        board.setPlayerPosition(newPosition);
    }

    private Personage modify(Personage character) {
        switch (menu.modifyCharacter()) {
            case CLASS -> character = defineCharacter(character.getName());
            case NAME -> character.setName(defineName());
            case QUIT -> exit();
        }
        return character;
    }

    private Personage validateCharacter(Personage character) {
        menu.showCharacterNameAndClass(character);
        switch (menu.askValidationOfCharacter()) {
            case VALIDATE -> {
                return character;
            }
            case MODIFY -> validateCharacter(modify(character));
            case QUIT -> exit();
        }
        return character;
    }
}

