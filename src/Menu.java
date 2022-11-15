import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public String main(){
        return askQuestion("[1] Create character | [2] Load character | [q] Quit");
    }

    public String askMethodOfCreationForCharacter(){
        return askQuestion("[1] Choose for each | [r] All Random | [q] Quit");
    }
    public String askClass() {
        return askQuestion("[1] Warrior |[2] Magician |[r] Randomize |[q] Quit");
    }

    public String askCharacterName() {
        return askQuestion("What is the name of you character ? |[r] Randomize | [q] Quit");
    }

    public String askValidationOfCharacter(){
        return askQuestion("[1] validate | [2] modify | [q] Quit");
    }

    public void showCharacterInfos(Personnage character) {
        System.out.println(character);
    }
    public void showCharacterNameAndClass(Personnage character){
        System.out.println("Here is your character :");
        System.out.println("class :" + character.getClasse() + " | name :" + character.getName() + " | genre :"+ character.getGenre());
    }

    private String askQuestion(String question){
        System.out.println(question);
        return scanner.nextLine();
    }

    public String modifyCharacter(){
        return askQuestion("What do you want to modify ? | [1] class | [2] name | [3] Both | [q] Quit");
    }

    public String askCharacterGenre(){
        return askQuestion("[1] Male | [2] Female |[r] Randomize | [q] Quit");
    }

    public String askToPlayAgain(){
        return askQuestion("[1] Play Again |[2] Quit");
    }

    public String askToStartGame(){
        return askQuestion("press enter to start the game");
    }
}
