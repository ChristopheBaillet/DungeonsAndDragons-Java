package fr.campus_numerique.module_java.d_d.game;

import fr.campus_numerique.module_java.d_d.Utilitaire;
import fr.campus_numerique.module_java.d_d.board.Board;
import fr.campus_numerique.module_java.d_d.character.type.Magician;
import fr.campus_numerique.module_java.d_d.character.Personnage;
import fr.campus_numerique.module_java.d_d.character.type.Warrior;

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
                String genre = defineCharacterGenre(menu.askCharacterGenre());
                String classe = defineCharacterClass(menu.askClass());
                String name = defineName(genre);
                switch (classe){
                    case "fr.campus_numerique.module_java.d_d.character.type.Warrior" -> {
                        return new Warrior(name,genre);
                    }
                    case "fr.campus_numerique.module_java.d_d.character.type.Magician" -> {
                        return new Magician(name,genre);
                    }
                }
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
    private Personnage modify(Personnage character) {
        String userInput = menu.modifyCharacter();
        switch (userInput) {
            case "1" -> character.setClasse(defineCharacterClass(menu.askClass()));
            case "2" -> character.setName(defineName(character.getGenre()));
            case "3" -> setClassAndName(character);
            case "q" -> exit();
            default -> modify(character);
        }
        return character;
    }

    private void setClassAndName(Personnage character) {
        character.setClasse(defineCharacterClass(menu.askClass()));
        character.setName(defineName(character.getGenre()));
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
    private String defineCharacterClass(String classe){
        switch (classe){
            case "1" -> classe = "fr.campus_numerique.module_java.d_d.character.type.Warrior";
            case "2" -> classe = "fr.campus_numerique.module_java.d_d.character.type.Magician";
            case "r" -> classe = defineRandomClass();
            case "q" -> exit();
            default -> defineCharacterClass(menu.askCharacterName());
        }
        return classe;
    }
    private String defineCharacterName(String name){
        return name;
    }


    private String defineCharacterGenre(String genre){
        switch (genre){
            case "1" -> genre = "Male";
            case "2" -> genre = "Female";
            case "r" -> genre = defineRandomGenre();
            case "q" -> exit();
            default -> defineCharacterGenre(menu.askCharacterGenre());
        }
        return genre;
    }


    private Personnage createRandomCharacter() {
        String genre = defineRandomGenre();
        String classe = defineRandomClass();
        String name = defineRandomName(genre);
        switch (classe){
            case "fr.campus_numerique.module_java.d_d.character.type.Warrior" -> {
                return new Warrior(name, genre);
            }
            case "fr.campus_numerique.module_java.d_d.character.type.Magician" -> {
                return new Magician(name, genre);
            }
        }
      return null;
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
                        case "" -> playATurn(character);
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

    public void playATurn(Personnage character){
        int[] roll = rollDices();
        int playerPosition = character.getPosition();
        int nbCases = board.getNbCases();
        playerPosition += roll[0] + roll[1];
        if (playerPosition > nbCases){
            int diff = playerPosition - 64;
            playerPosition = 64 - diff;
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

    private String defineRandomClass(){
        return Utilitaire.randomBetweenTwoStrings("fr.campus_numerique.module_java.d_d.character.type.Warrior", "Female");
    }
}
