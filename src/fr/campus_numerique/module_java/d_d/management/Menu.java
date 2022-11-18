package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.character.Personage;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public String main(){
        return askQuestion("[1] Create character | [q] Quit");
    }

    public String askClass() {
        return askQuestion("[1] Warrior |[2] Magician |[q] Quit");
    }

    public String askCharacterName() {
        return askQuestion("What is the name of you character ? | [q] Quit");
    }

    public String askValidationOfCharacter(){
        return askQuestion("[1] Validate | [2] Modify | [q] Quit");
    }

    public void showCharacterNameAndClass(Personage character){
        System.out.println(character);
    }

    private String askQuestion(String question){
        System.out.println(question);
        return scanner.nextLine();
    }

    public String modifyCharacter(){
        return askQuestion("What do you want to modify ? | [1] Class | [2] Name | [q] Quit");
    }

    public String askToPlayAgain(){
        return askQuestion("[1] Play Again |[q] Quit");
    }

    public String askToStartGame(){
        return askQuestion("Press enter to start the game.");
    }
}
