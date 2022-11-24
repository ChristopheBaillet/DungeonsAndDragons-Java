package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.board.Board;
import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.entity.board.EmptyCase;
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
        } catch (CharacterTypeException e) {
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

    private int[] rollDices() {
        int dice1 = random.nextInt(1, 6);
        int dice2 = random.nextInt(1, 6);
        return new int[]{dice1, dice2};
    }

    public void playATurn(Personage character) throws CharacterOutsideOfBoardException {
        int[] roll = rollDices();
        int playerPosition = board.getPlayerPosition();
        int maxPosition = board.getNbCases();
        Case element = board.getBoxes().get(playerPosition);
        playerPosition += roll[0] + roll[1];
        board.acceptPlayerAt(playerPosition);
        if (playerPosition == maxPosition) {
            gameStatus = GameStatus.FINISHED;
            System.out.println("finished " + playerPosition);
        } else {
            board.setPlayerPosition(playerPosition);
            switch (menu.askInteract(element)) {
                case YES -> element.interact(character);
                case NO -> {
                }
            }
        }
    }


    private void moveCharacterForward(Personage character, int number) {

    }

    private void moveCharacterBackward(Personage Character, int number) {

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

