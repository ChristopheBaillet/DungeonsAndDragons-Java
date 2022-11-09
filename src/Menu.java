import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public Personnage start() {
        System.out.println("[1] create a character | [2] exit the game");
        String userChoice = scanner.nextLine();
        if (userChoice.equals("1")) {
            return createCharacter();
        } else {
            exit();
            return null;
        }

    }
    public void exit() {
        System.exit(0);
    }

    public Personnage createCharacter() {
        String userClass = warriorOrMagician(askClass());
        String characterName = askCharacterName();
        return validateCharacter(new Personnage(userClass, characterName));
    }


    public String warriorOrMagician(String className) {
        if (className.equals("1") || className.equals("2")) {
            if (className.equals("1")){
                return "Warrior";
            }else {
                return "Magician";
            }
        } else {
            return askClass();
        }
    }

    public String askClass() {
        System.out.println("[1] Warrior |[2] Magician");
        String userInput = scanner.nextLine();
        System.out.println(userInput);
        return warriorOrMagician(userInput);
    }

    public String askCharacterName() {
        System.out.println("What is the name of you character ? ");
        return scanner.nextLine();
    }

    public void showCharacterInfos(Personnage character) {
        System.out.println(character);
    }

    public Personnage validateCharacter(Personnage character) {
        System.out.println("Here is your character :");
        System.out.println("class :" + character.getClasse() + " | name :" + character.getName());
        System.out.println("[1] validate | [2] modify");
        String userChoice = scanner.nextLine();
        if (!userChoice.equals("1")) {
            System.out.println("What do you want to modify ? | [1] name  | [2] class");
            userChoice = scanner.nextLine();
            if (userChoice.equals("1")) {
                character.setName(askCharacterName());
            } else {
                character.setClasse(askClass());
            }
            validateCharacter(character);
        }
        return character;
    }
}
