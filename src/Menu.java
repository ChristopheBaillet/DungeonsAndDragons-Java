import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public Personnage start() {
        System.out.println("[1] create a character | [2] Quit");
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
        String userClass = askClass();
        String characterName = askCharacterName();
        return validateCharacter(new Personnage(userClass, characterName));
    }


    public String warriorOrMagician(String userInput) {
        if (userInput.equals("1") || userInput.equals("2")) {
            if (userInput.equals("1")){
                return "Warrior";
            }else {
                return "Magician";
            }
        }else if (userInput.equals("q")){
            exit();
            return null;
        }
        else {
            return askClass();
        }
    }

    public String askClass() {
        System.out.println("[1] Warrior |[2] Magician |[q] Quit");
        String userInput = scanner.nextLine();
        return warriorOrMagician(userInput);
    }

    public String askCharacterName() {
        System.out.println("What is the name of you character ? | [q] Quit");
        String userInput = scanner.nextLine();
        if (userInput.equals("q")){
            exit();
        }
        return userInput;
    }

    public void showCharacterInfos(Personnage character) {
        System.out.println(character);
    }

    public Personnage validateCharacter(Personnage character) {
        System.out.println("Here is your character :");
        System.out.println("class :" + character.getClasse() + " | name :" + character.getName());
        System.out.println("[1] validate | [2] modify | [q] Quit");
        String userChoice = scanner.nextLine();
        if (userChoice.equals("2")) {
            System.out.println("What do you want to modify ? | [1] name  | [2] class | [q] Quit");
            userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1" -> character.setName(askCharacterName());
                case "2" -> character.setClasse(askClass());
                case "q" -> exit();
            }
            validateCharacter(character);
        }else if (userChoice.equals("q")){
            exit();
        }
        return character;
    }
}
