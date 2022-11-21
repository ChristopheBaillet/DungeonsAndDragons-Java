package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.board.Board;
import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.entity.character.Enemy;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.character.type.Magician;
import fr.campus_numerique.module_java.d_d.entity.character.type.Warrior;
import fr.campus_numerique.module_java.d_d.entity.stuff.Item;
import fr.campus_numerique.module_java.d_d.exception.CharacterOutsideOfBoardException;

import java.util.Random;
import java.util.Scanner;


public class Game {
    private final Random random = new Random();
    private final Board board = new Board();
    private final Menu menu = new Menu();
    private final Scanner scanner = new Scanner(System.in);
    private Personage character;

    public void start() {
        switch (menu.main()) {
            case CONTINUE -> character = createCharacter();
            case QUIT -> exit();
        }
        playGame();
    }

    private Personage createCharacter() {
        return validateCharacter(character());
    }

    private Personage character() {
        Personage character = defineCharacterClass();
        character.setName(defineName());
        return character;
    }

    private void exit() {
        System.exit(0);
    }

    private Personage validateCharacter(Personage character) {
        menu.showCharacterNameAndClass(character);
        switch (menu.askValidationOfCharacter()) {
            case VALIDATE -> {
                return character;
            }
            case MODIFY -> validateCharacter(modify(character));
            case QUIT -> exit();
        }
        return character;
    }

    private Personage defineCharacterClassWithName(String name) {
        Personage classe = null;
        switch (menu.askClass()) {
            case WARRIOR -> classe = new Warrior(name);
            case MAGICIAN -> classe = new Magician(name);
            case QUIT -> exit();
        }
        return classe;
    }

    private Personage modify(Personage character) {
        switch (menu.modifyCharacter()) {
            case CLASS -> character = defineCharacterClassWithName(character.getName());
            case NAME -> character.setName(defineName());
            case QUIT -> exit();
        }
        return character;
    }

    private String defineName() {
       return menu.askCharacterName();
    }

    private Personage defineCharacterClass() {
        Personage classe = null;
        switch (menu.askClass()) {
            case WARRIOR -> classe = new Warrior();
            case MAGICIAN -> classe = new Magician();
            case QUIT -> exit();
        }
        return classe;
    }

    private String defineCharacterName(String name) {
        return name;
    }

    private void playAgain() {
        switch (menu.askToPlayAgain()) {
            case PLAY_AGAIN -> playGame();
            case QUIT -> exit();
        }
    }

    private void playGame() {
        switch (menu.askToStartGame()) {
            case CONTINUE -> {
                board.initialize(character);
                menu.showHelpInfos();
                while (!board.getStatus().equals("finished")) {
                    switch (menu.inGame()) {
                        case PLAY -> {
                            try {
                                playATurn(character);
                            } catch (CharacterOutsideOfBoardException exception) {
                                System.out.println(exception);
                                playAgain();
                            }
                        }
                        case SHOW_INFOS -> System.out.println(character.getInfos());
                        case QUIT -> exit();
                        case HELP -> menu.showHelpInfos();
                    }
                }
                playAgain();
            }
            case QUIT -> exit();
        }
    }

    private int[] rollDices() {
        int dice1 = random.nextInt(1, 6);
        int dice2 = random.nextInt(1, 6);
        return new int[]{dice1, dice2};
    }

    public void playATurn(Personage character) throws CharacterOutsideOfBoardException {
        int[] roll = rollDices();
        int playerPosition = character.getPosition();
        int maxPosition = board.getNbCases();
        Case element = board.getBoxes().get(playerPosition);
        board.printArray(board.getBoxes(), character.getPosition());
//        playerPosition += roll[0] + roll[1];
        playerPosition++;
        if (playerPosition == maxPosition) {
            board.setStatus("finished");
            System.out.println("finished " + playerPosition);
        }else if (playerPosition > maxPosition) {
            throw new CharacterOutsideOfBoardException();
        }else {
            character.setPosition(playerPosition);
            if (element instanceof Enemy){
                switch(menu.askInteractWithEnemy(element)){
                    case YES -> element.interact(character);
                    case NO -> {
                    }
                };
            }else if (element instanceof Item){
                switch (menu.askInteractWithItem(element)){
                    case YES -> element.interact(character);
                    case NO -> {
                    }
                };
            }else {
                System.out.println("This is an empty room");
            }
        }
    }
}

