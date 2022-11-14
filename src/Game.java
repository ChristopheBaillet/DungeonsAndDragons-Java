import java.util.Objects;
import java.util.Scanner;

public class Game {
    private final Board board = new Board();
    private final Menu menu = new Menu();
    private final Scanner scanner = new Scanner(System.in);
    private Personnage character;

    public void start() {
        String userInput = menu.main();
        switch (userInput) {
            case "1" -> character = createCharacter();
            case "2" -> character = loadCharacter();
            case "q" -> exit();
        }
        playGame();
    }

    private Personnage loadCharacter() {
        return new Personnage();
    }

    private Personnage createCharacter() {
        String methodOfCreationForCharacter = menu.askMethodOfCreationForCharacter();
        Personnage newPersonnage = null;
        switch (methodOfCreationForCharacter) {
            case "1" -> {
                String userClass = warriorOrMagician(menu.askClass());
                String userName = menu.askCharacterName();
                newPersonnage = new Personnage(userClass, userName);
            }
            case "2" -> newPersonnage = createCharacterWithRandomClass();
            case "3" -> newPersonnage = createCharacterWithRandomName();
            case "4" -> newPersonnage = createRandomCharacter();
            case "q" -> exit();
            default -> createCharacter();

        }

        return validateCharacter(newPersonnage);
    }

    private void exit() {
        System.exit(0);
    }

    private String warriorOrMagician(String userInput) {
        switch (userInput) {
            case "1" -> userInput = "Warrior";
            case "2" -> userInput = "Magician";
            case "q" -> exit();
            default -> warriorOrMagician(menu.askClass());
        }
        return userInput;
    }

    private Personnage validateCharacter(Personnage character) {
        menu.showCharacterNameAndClass(character);
        String userChoice = menu.askValidationOfCharacter();
        switch (userChoice) {
            case "1" -> validate();
            case "2" -> validateCharacter(modify(character));
            case "q" -> exit();
            default -> validateCharacter(character);
        }
        return character;
    }

    private void validate() {

    }

    private Personnage modify(Personnage character) {
        String userInput = menu.modifyCharacter();
        switch (userInput) {
            case "1" -> character.setClasse(menu.askClass());
            case "2" -> character.setName(menu.askCharacterName());
            case "3" -> setClassAndName(character);
            case "q" -> exit();
            default -> modify(character);
        }
        return character;
    }

    private void setClassAndName(Personnage character) {
        character.setClasse(menu.askClass());
        character.setName(menu.askCharacterName());
    }

    private Personnage createCharacterWithRandomName() {
        Personnage newPersonnage = new Personnage();
        String userInput = menu.askCharacterGenre();
        int genreChoice = 0;
        switch (userInput) {
            case "0" -> {
            }
            case "1" -> genreChoice = 1;
            case "q" -> exit();
            default -> createCharacterWithRandomName();
        }
        newPersonnage.chooseRandomName(genreChoice);
        return newPersonnage;
    }

    private Personnage createCharacterWithRandomClass() {
        String userName = menu.askCharacterName();
        return new Personnage(userName);
    }

    private Personnage createRandomCharacter() {
        return new Personnage();
    }

    private void playAgain() {
        String playerInput = menu.playAgain();
        switch (playerInput) {
            case "1" -> playGame();
            case "2" -> exit();
            default -> playAgain();
        }
    }

    private void playGame() {
        System.out.println("press enter to start the game");
        board.initialize();
        while (!board.getStatus().equals("finished")) {
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "" -> board.playATurn();
                case "i" -> System.out.println(character);
                case "q" -> exit();
            }
        }
        playAgain();
    }
}
