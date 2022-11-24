package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.board.Board;
import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.entity.character.CharacterTypes;
import fr.campus_numerique.module_java.d_d.entity.character.CharactersFactory;
import fr.campus_numerique.module_java.d_d.entity.character.Enemy;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.stuff.Item;
import fr.campus_numerique.module_java.d_d.exception.CharacterOutsideOfBoardException;
import fr.campus_numerique.module_java.d_d.exception.CharacterTypeException;

import java.util.Random;


public class Game {
    private final Random random = new Random();
    private final Board board = new Board();
    private final Menu menu = new Menu();
    private Personage character;
    private GameStatus gameStatus;

    public Game() {
        gameStatus = GameStatus.UNINITIALIZED;
        do {
            switch (menu.main(character)) {
                case CREATE_CHARACTER -> {
                    gameStatus = GameStatus.CREATING_CHARACTER;
                    character = createCharacter();
                }
                case PLAY -> {
                    gameStatus = GameStatus.ON_GOING;
                    playGame();
                }
                case QUIT -> gameStatus = GameStatus.QUIT_GAME;
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
        try {
            switch (menu.askClass()) {
                case WARRIOR -> {
                    character = CharactersFactory.createCharacter(CharacterTypes.WARRIOR, name);
                }
                case MAGICIAN -> {
                    character = CharactersFactory.createCharacter(CharacterTypes.MAGICIAN, name);
                }
                case QUIT -> exit();
            }
        }catch (CharacterTypeException e){
            System.out.println(e);
            return null;
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
        while (board.getStatus() != GameStatus.QUIT_GAME) {
            switch (menu.askToStartGame()) {
                case CONTINUE -> {
                    board.initialize(character);
                    menu.showHelpInfos();
                    gameLoop();
                }
                case QUIT -> exit();
            }
        }
    }

    private void gameLoop() {
        while (board.getStatus() != GameStatus.FINISHED) {
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

    private int[] rollDices() {
        int dice1 = random.nextInt(1, 6);
        int dice2 = random.nextInt(1, 6);
        return new int[]{dice1, dice2};
    }

    public void playATurn(Personage character) throws CharacterOutsideOfBoardException {
        int[] roll = rollDices();
        int playerPosition = character.getPosition();
        int maxPosition = board.getNbCases();
        Case element = board.getBoxes().get(playerPosition);
        board.printArray(board.getBoxes(), character.getPosition());
//        playerPosition += roll[0] + roll[1];
        board.acceptPlayerAt(playerPosition++);
        if (playerPosition == maxPosition) {
            board.setStatus(GameStatus.FINISHED);
            System.out.println("finished " + playerPosition);
        } else {
            character.setPosition(playerPosition);
            if (element instanceof Enemy) {
                switch (menu.askInteractWithEnemy(element)) {
                    case YES -> element.interact(character);
                    case NO -> {
                    }
                }
                ;
            } else if (element instanceof Item) {
                switch (menu.askInteractWithItem(element)) {
                    case YES -> element.interact(character);
                    case NO -> {
                    }
                }
                ;
            } else {
                System.out.println("This is an empty room");
            }
        }
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

