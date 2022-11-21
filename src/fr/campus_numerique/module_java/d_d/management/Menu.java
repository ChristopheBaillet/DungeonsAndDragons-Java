package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public UserChoice main() {
        return switch (askQuestion("[1] Create character | [q] Quit")) {
            case "1" -> UserChoice.CONTINUE;
            case "q" -> UserChoice.QUIT;
            default -> main();
        };
    }

    public UserChoice askClass() {
        return switch (askQuestion("[1] Warrior |[2] Magician |[q] Quit")) {
            case "1" -> UserChoice.WARRIOR;
            case "2" -> UserChoice.MAGICIAN;
            case "q" -> UserChoice.QUIT;
            default -> askClass();
        };
    }

    public String askCharacterName() {
        return askQuestion("What is the name of you character ? | [q] Quit");
    }

    public UserChoice askValidationOfCharacter() {
        return switch (askQuestion("[1] Validate | [2] Modify | [q] Quit")) {
            case "1" -> UserChoice.VALIDATE;
            case "2" -> UserChoice.MODIFY;
            case "q" -> UserChoice.QUIT;
            default -> askValidationOfCharacter();
        };
    }

    public void showCharacterNameAndClass(Personage character) {
        System.out.println(character);
    }

    private String askQuestion(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public UserChoice modifyCharacter() {
        return switch (askQuestion("What do you want to modify ? | [1] Class | [2] Name | [q] Quit")) {
            case "1" -> UserChoice.CLASS;
            case "2" -> UserChoice.NAME;
            case "q" -> UserChoice.QUIT;
            default -> modifyCharacter();
        };
    }

    public UserChoice askToPlayAgain() {
        return switch (askQuestion("[1] Play Again |[q] Quit")) {
            case "1" -> UserChoice.PLAY_AGAIN;
            case "q" -> UserChoice.QUIT;
            default -> askToPlayAgain();
        };
    }

    public UserChoice askToStartGame() {
        if (askQuestion("Press enter to start the game.").equals("")){
            return UserChoice.CONTINUE;
        }else {
            askToStartGame();
        }
        return null;
    }

    public UserChoice askInteractWithItem(Case box) {
        return switch (askQuestion("Do you want to take this " + box + " ? [y] Yes | [n] No")) {
            case "y" -> UserChoice.YES;
            case "n" -> UserChoice.NO;
            default -> askInteractWithItem(box);
        };
    }

    public UserChoice inGame() {
        return switch (scanner.nextLine()) {
            case "" -> UserChoice.PLAY;
            case "i" -> UserChoice.SHOW_INFOS;
            case "q" -> UserChoice.QUIT;
            case "help" -> UserChoice.HELP;
            default -> inGame();
        };
    }

    public void showHelpInfos() {
        System.out.println("During the game");
        System.out.println("Type enter to play a turn");
        System.out.println("Type i to show your character infos");
        System.out.println("Type q to exit the game");
        System.out.println("Type help to get this list");
    }

    public UserChoice askInteractWithEnemy(Case box) {
        return switch (askQuestion("this is a " + box + "\nDo you want to fight it?")) {
            case "y" -> UserChoice.YES;
            case "n" -> UserChoice.NO;
            default -> askInteractWithItem(box);
        };
    }
}
