package fr.campus_numerique.module_java.d_d.game;

import fr.campus_numerique.module_java.d_d.Utilitaire;
import fr.campus_numerique.module_java.d_d.board.Board;
import fr.campus_numerique.module_java.d_d.character.type.Magician;
import fr.campus_numerique.module_java.d_d.character.Personnage;
import fr.campus_numerique.module_java.d_d.character.type.Warrior;
import fr.campus_numerique.module_java.d_d.game.exception.CharacterOutsideOfBoardException;
import fr.campus_numerique.module_java.d_d.menu.Menu;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Random random = new Random();
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
        return createRandomCharacter();
    }

    private Personnage createCharacter() {
        return validateCharacter(character());
    }

    private Personnage character(){
        String methodOfCreationForCharacter = menu.askMethodOfCreationForCharacter();
        switch (methodOfCreationForCharacter){
            case "1" ->{
                Personnage character = defineCharacterClass();
                String genre = defineCharacterGenre();
                character.setGenre(genre);
                character.setName(defineName(genre));
                return character;
            }
            case "r" -> {
                return createRandomCharacter();
            }
            case "q"-> exit();
            default -> createCharacter();
        }
        return null;
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

    private Personnage defineCharacterClassWithNameAndGenre(String name, String genre){
        Personnage classe = null;
        switch (menu.askClass()){
            case "1" -> classe = new Warrior(name,genre);
            case "2" -> classe = new Magician(name,genre);
            case "r" -> classe = defineRandomClassWithNameAndGenre(name,genre);
            case "q" -> exit();
            default -> defineCharacterClassWithNameAndGenre(name,genre);
        }
        return classe;
    }

    private Personnage defineRandomClassWithNameAndGenre(String name, String genre) {
        switch (Utilitaire.randomBetweenTwoStrings("Warrior", "Magician")){
            case "Warrior" -> {
                return new Warrior(name,genre);
            }
            case ("Magician") -> {
                return new Magician(name,genre);
            }
        }
        return null;
    }

    private Personnage modify(Personnage character) {
        String userInput = menu.modifyCharacter();
        switch (userInput) {
            case "1" -> character = defineCharacterClassWithNameAndGenre(character.getName(), character.getGenre());
            case "2" -> character.setName(defineName(character.getGenre()));
            case "3" -> character.setGenre(defineCharacterGenre());
            case "4" -> createCharacter();
            case "q" -> exit();
            default -> modify(character);
        }
        return character;
    }

    private String defineName(String genre){
        String userInputName = menu.askCharacterName();
        String name = "";
        switch (userInputName){
            case "r" -> name = defineRandomName(genre);
            case "q" -> exit();
            default ->  name = defineCharacterName(userInputName);
        }
        return name;
    }
    private Personnage defineCharacterClass(){
        Personnage classe = null;
        switch (menu.askClass()){
            case "1" -> classe = new Warrior();
            case "2" -> classe = new Magician();
            case "r" -> classe = defineRandomClass();
            case "q" -> exit();
            default -> defineCharacterClass();
        }
        return classe;
    }
    private String defineCharacterName(String name){
        return name;
    }


    private String defineCharacterGenre(){
        String genre = "";
        switch (menu.askCharacterGenre()){
            case "1" -> genre = "Male";
            case "2" -> genre = "Female";
            case "r" -> genre = defineRandomGenre();
            case "q" -> exit();
            default -> defineCharacterGenre();
        }
        return genre;
    }
    private Personnage createRandomCharacter() {
        String genre = defineRandomGenre();
        String name = defineRandomName(genre);
        return defineRandomClassWithNameAndGenre(name,genre);
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
        switch(menu.askToStartGame()){
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
                            }
                            catch (CharacterOutsideOfBoardException e){
                                System.out.println(e);
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

    private int[] rollDices(){
        int dice1 = random.nextInt(1,6);
        int dice2 = random.nextInt(1,6);
        return new int[]{dice1, dice2};
    }

    public void playATurn(Personnage character) throws CharacterOutsideOfBoardException {
        int[] roll = rollDices();
        int playerPosition = character.getPosition();
        int nbCases = board.getNbCases();
        playerPosition += roll[0] + roll[1];
        if (playerPosition > nbCases){
            throw new CharacterOutsideOfBoardException();
        }
        character.setPosition(playerPosition);
        board.printArray(board.getCases(), character.getPosition());
        if (playerPosition == nbCases){
            board.setStatus("finished");
            System.out.println("finished "+ playerPosition);
        }
        System.out.println(playerPosition);
    }

    private String defineRandomName(String genre){
        return Personnage.chooseRandomName(genre);
    }

    private String defineRandomGenre(){
        return Utilitaire.randomBetweenTwoStrings("Male", "Female");
    }

    private Personnage defineRandomClass(){
        switch (Utilitaire.randomBetweenTwoStrings("Warrior", "Magician")){
            case "Warrior" -> {
                return new Warrior();
            }
            case ("Magician") -> {
                return new Magician();
            }
        }
        return null;
    }
}
