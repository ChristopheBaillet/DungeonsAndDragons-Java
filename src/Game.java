import java.util.Scanner;

public class Game {
    private final Menu menu = new Menu();
    private final Scanner scanner = new Scanner(System.in);
    private Personnage character;

    public void main() {
        start();
    }
    private void start(){
        String userInput = menu.main();
        switch (userInput){
            case "1" -> character = createCharacter();
            case "2" -> character = loadCharacter();
            case "q" -> exit();
        }
        System.out.println(character);
    }

    private Personnage loadCharacter(){
        return new Personnage();
    }

    private Personnage createCharacter(){
        String userClass = warriorOrMagician(menu.askClass());
        String userName = menu.askCharacterName();
        return validateCharacter(new Personnage(userClass, userName));
    }

    private void exit(){
        System.exit(0);
    }

    private String warriorOrMagician(String userInput) {
        switch (userInput){
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

    private void validate(){

    }

    private Personnage modify(Personnage character){
        String userInput = menu.modifyCharacter();
        switch (userInput){
            case "1" -> character.setClasse(menu.askClass());
            case "2" -> character.setName(menu.askCharacterName());
            case "3" -> setClassAndName(character);
            case "q" -> exit();
            default -> modify(character);
        }
        return character;
    }

    private void setClassAndName(Personnage character){
        character.setClasse(menu.askClass());
        character.setName(menu.askCharacterName());
    }
}
