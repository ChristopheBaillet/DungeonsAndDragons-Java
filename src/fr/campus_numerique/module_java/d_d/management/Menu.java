package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public UserChoice main(Personage character) {
        UserChoice userInput;
        String message = character != null ? "[1] Create character | [2] Start Game | [3] Modify | [q] Quit" : "[1] Create character | [q] Quit";
        do {
            switch (askQuestion(message)) {
                case "1" -> userInput = UserChoice.CREATE_CHARACTER;
                case "2" -> userInput = character != null ? UserChoice.PLAY : UserChoice.WRONG_ANSWER;
                case "3" -> userInput = character != null ? UserChoice.MODIFY : UserChoice.WRONG_ANSWER;
                case "q" -> userInput = UserChoice.QUIT;
                default -> userInput = UserChoice.WRONG_ANSWER;
            }
            ;
        } while (userInput == UserChoice.WRONG_ANSWER);
        return userInput;
    }

    public UserChoice askClass() {
        UserChoice userInput;
        do {
            userInput = switch (askQuestion("[1] Warrior |[2] Magician |[q] Quit")) {
                case "1" -> UserChoice.WARRIOR;
                case "2" -> UserChoice.MAGICIAN;
                case "q" -> UserChoice.QUIT;
                default -> askClass();
            };
        } while (userInput == UserChoice.WRONG_ANSWER);
        return userInput;
    }

    public String askCharacterName() {
        return askQuestion("What is the name of you character ?");
    }

    public UserChoice askValidationOfCharacter() {
        UserChoice userInput;
        do {
            userInput = switch (askQuestion("[1] Validate | [2] Modify | [q] Quit")) {
                case "1" -> UserChoice.VALIDATE;
                case "2" -> UserChoice.MODIFY;
                case "q" -> UserChoice.QUIT;
                default -> askValidationOfCharacter();
            };
        } while (userInput == UserChoice.WRONG_ANSWER);
        return userInput;
    }

    public void showCharacterNameAndClass(Personage character) {
        System.out.println(character);
    }

    private String askQuestion(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public UserChoice modifyCharacter() {
        UserChoice userInput;
        do {
            userInput = switch (askQuestion("What do you want to modify ? | [1] Class | [2] Name | [q] Quit")) {
                case "1" -> UserChoice.CLASS;
                case "2" -> UserChoice.NAME;
                case "q" -> UserChoice.QUIT;
                default -> modifyCharacter();
            };
        } while (userInput == UserChoice.WRONG_ANSWER);
        return userInput;
    }

    public UserChoice askToPlayAgain() {
        UserChoice userInput;
        do {
            userInput = switch (askQuestion("[1] Play Again |[q] Quit")) {
                case "1" -> UserChoice.PLAY_AGAIN;
                case "q" -> UserChoice.QUIT;
                default -> UserChoice.WRONG_ANSWER;
            };
        } while (userInput == UserChoice.WRONG_ANSWER);
        return userInput;
    }

    public UserChoice askToStartGame() {
        UserChoice userInput;
        do {
            if (askQuestion("Press enter to start the game.").equals("")) {
                userInput = UserChoice.CONTINUE;
            } else {
                userInput = UserChoice.WRONG_ANSWER;
            }
        } while (userInput == UserChoice.WRONG_ANSWER);
        return userInput;
    }

    public UserChoice askInteractWithItem(Case box) {
        UserChoice userInput;
        do {
            userInput = switch (askQuestion("Do you want to take this " + box + " ? [y] Yes | [n] No")) {
                case "y" -> UserChoice.YES;
                case "n" -> UserChoice.NO;
                default -> UserChoice.WRONG_ANSWER;
            };
        } while (userInput == UserChoice.WRONG_ANSWER);
        return userInput;
    }

    public UserChoice inGame() {
        UserChoice userInput;
        do {
            userInput = switch (scanner.nextLine()) {
                case "" -> UserChoice.PLAY;
                case "i" -> UserChoice.SHOW_INFOS;
                case "q" -> UserChoice.QUIT;
                case "help" -> UserChoice.HELP;
                default -> UserChoice.WRONG_ANSWER;
            };
        } while (userInput == UserChoice.WRONG_ANSWER);
        return userInput;
    }

    public void showHelpInfos() {
        System.out.println("During the game");
        System.out.println("Type enter to play a turn");
        System.out.println("Type i to show your character infos");
        System.out.println("Type q to exit the game");
        System.out.println("Type help to get this list");
    }

    public UserChoice askInteractWithEnemy(Case box) {
        UserChoice userInput;
        do {
            userInput = switch (askQuestion("this is a " + box + "\nDo you want to fight it?")) {
                case "y" -> UserChoice.YES;
                case "n" -> UserChoice.NO;
                default -> UserChoice.WRONG_ANSWER;
            };
        } while (userInput == UserChoice.WRONG_ANSWER);
        return userInput;
    }
}
