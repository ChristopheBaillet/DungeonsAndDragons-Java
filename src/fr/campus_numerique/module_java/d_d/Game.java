package fr.campus_numerique.module_java.d_d;

import java.util.Random;
import java.util.Scanner;


public class Game {
    private final Random random = new Random();
    private final Board board = new Board();
    private final Menu menu = new Menu();
    private final Scanner scanner = new Scanner(System.in);
    private Personnage character;

    public void start() {
        switch (menu.main()) {
            case "1" -> character = createCharacter();
            case "q" -> exit();
        }
        playGame();
    }

    private Personnage createCharacter() {
        return validateCharacter(character());
    }

    private Personnage character() {
        Personnage character = defineCharacterClass();
        character.setName(defineName());
        return character;
    }

    private void exit() {
        System.exit(0);
    }

    private Personnage validateCharacter(Personnage character) {
        menu.showCharacterNameAndClass(character);
        String userChoice = menu.askValidationOfCharacter();
        switch (userChoice) {
            case "1" -> {
                return character;
            }
            case "2" -> validateCharacter(modify(character));
            case "q" -> exit();
            default -> validateCharacter(character);
        }
        return character;
    }

    private Personnage defineCharacterClassWithName(String name) {
        Personnage classe = null;
        switch (menu.askClass()) {
            case "1" -> classe = new Warrior(name);
            case "2" -> classe = new Magician(name);
            case "q" -> exit();
            default -> defineCharacterClassWithName(name);
        }
        return classe;
    }

    private Personnage modify(Personnage character) {
        String userInput = menu.modifyCharacter();
        switch (userInput) {
            case "1" -> character = defineCharacterClassWithName(character.getName());
            case "2" -> character.setName(defineName());
            case "q" -> exit();
            default -> modify(character);
        }
        return character;
    }

    private String defineName() {
       return menu.askCharacterName();
    }

    private Personnage defineCharacterClass() {
        Personnage classe = null;
        switch (menu.askClass()) {
            case "1" -> classe = new Warrior();
            case "2" -> classe = new Magician();
            case "q" -> exit();
            default -> defineCharacterClass();
        }
        return classe;
    }

    private String defineCharacterName(String name) {
        return name;
    }

    private void playAgain() {
        String playerInput = menu.askToPlayAgain();
        switch (playerInput) {
            case "1" -> playGame();
            case "2" -> exit();
            default -> playAgain();
        }
    }

    private void playGame() {
        switch (menu.askToStartGame()) {
            case "" -> {
                board.initialize(character);
                board.printArray(board.getCases(), character.getPosition());
                System.out.println(character.getPosition());
                while (!board.getStatus().equals("finished")) {
                    String userInput = scanner.nextLine();
                    switch (userInput) {
                        case "" -> {
                            try {
                                playATurn(character);
                            } catch (CharacterOutsideOfBoardException exception) {
                                System.out.println(exception);
                                playAgain();
                            }
                        }
                        case "i" -> System.out.println(character);
                        case "q" -> exit();
                    }
                }
                playAgain();
            }
            case "q" -> exit();
        }
    }

    private int[] rollDices() {
        int dice1 = random.nextInt(1, 6);
        int dice2 = random.nextInt(1, 6);
        return new int[]{dice1, dice2};
    }

    public void playATurn(Personnage character) throws CharacterOutsideOfBoardException {
        int[] roll = rollDices();
        int playerPosition = character.getPosition();
        int nbCases = board.getNbCases();
        playerPosition += roll[0] + roll[1];
        if (playerPosition > nbCases) {
            throw new CharacterOutsideOfBoardException();
        }
        character.setPosition(playerPosition);
        board.printArray(board.getCases(), character.getPosition());
        if (playerPosition == nbCases) {
            board.setStatus("finished");
            System.out.println("finished " + playerPosition);
        }
        System.out.println(playerPosition);
    }
}

