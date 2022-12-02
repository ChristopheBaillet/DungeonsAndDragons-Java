package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.board.Board;
import fr.campus_numerique.module_java.d_d.entity.board.Case;
import fr.campus_numerique.module_java.d_d.entity.board.CaseType;
import fr.campus_numerique.module_java.d_d.entity.character.*;
import fr.campus_numerique.module_java.d_d.entity.stuff.Item;
import fr.campus_numerique.module_java.d_d.exception.CharacterOutsideOfBoardException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Game implements MenuListener {
    private final Random random = new Random();
    private final Board board;
    private final Menu menu;
    private Hero character;
    private GameStatus gameStatus;
    private DBCharacter dbCharacter;

    public Game() {
        this.menu = Menu.getInstance();
        this.menu.addMenuObserver(this);
        this.board = new Board(true);
        this.dbCharacter = new DBCharacter();
    }

    public void start(){
        do {
            gameStatus = menu.main(character);
            switch (gameStatus) {
                case CREATING_CHARACTER -> {
                    character = createCharacter();
                    dbCharacter.save(character);
                }
                case LOAD_CHARACTER -> character = loadCharacter();
                case ON_GOING -> playGame();
                case MODIFY -> System.out.println(character);
            }
        } while (gameStatus != GameStatus.QUIT_GAME);
    }

    private Hero loadCharacter() {
        Map<Integer, Hero> result = dbCharacter.loadAll();
        int index = menu.chooseCharacter(result);
        return dbCharacter.load(index);
    }

    private Hero createCharacter() {
        return defineCharacter(defineName());
    }

    private Hero defineCharacter(String name) {
        Hero character = null;
        switch (menu.askClass()) {
            case WARRIOR -> {
                character = CharactersFactory.createCharacter(HeroTypes.WARRIOR, name);
            }
            case MAGICIAN -> {
                character = CharactersFactory.createCharacter(HeroTypes.MAGICIAN, name);
            }
            case QUIT -> onQuitAsked();
        }
        return character;
    }

    private String defineName() {
        return menu.askCharacterName();
    }

    private void playAgain() {
        switch (menu.askToPlayAgain()) {
            case PLAY_AGAIN -> playGame();
            case QUIT -> onQuitAsked();
        }
    }

    private void playGame() {
        board.initialize(character);
        while (gameStatus == GameStatus.ON_GOING) {
            board.display();
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
                case QUIT -> onQuitAsked();
                case HELP -> menu.showHelpInfos();
            }
        }
    }


    public void playATurn(Hero character) throws CharacterOutsideOfBoardException {
        int playerPosition = board.getPlayerPosition();
        int maxPosition = board.getNbCases();
        playerPosition = moveForward(random.nextInt(1, 6), playerPosition);
        if (playerPosition == maxPosition) {
            gameStatus = GameStatus.FINISHED;
            System.out.println("finished " + playerPosition);
        } else {
            board.setPlayerPosition(playerPosition);
            Case element = board.getBoxes().get(playerPosition);
            CaseType elmt = element instanceof Item ? CaseType.ITEM : element instanceof Enemy ? CaseType.ENEMY : CaseType.EMPTY;
            if (element.canInteract()) {
                switch (elmt) {
                    case EMPTY -> {
                        element.interact(character);
                    }
                    case ENEMY -> {
                        board.display();
                        UserChoice userChoice = null;
                        Enemy enemy = (Enemy) element;
                        System.out.println("Vous vous retrouver face à face avec un " + enemy.getName());
                        do {
                            switch (menu.askFightOrFlee(enemy)) {
                                case FIGHT -> {
                                    element.interact(character);
                                    userChoice = UserChoice.FIGHT;
                                }
                                case FLEE -> {
                                    userChoice = UserChoice.FLEE;
                                    moveBackward(playerPosition, random.nextInt(1,6));
                                    System.out.println(board.getPlayerPosition()+ " " + playerPosition);
                                }
                            }
                        }while (userChoice == UserChoice.FIGHT && !enemy.fightIsFinished(character));
                    }
                    case ITEM -> {
                        switch (menu.askTakeItem((Item) element)) {
                            case YES -> element.interact(character);
                            case NO -> {
                            }
                        }
                    }
                }
            }
            if (character.getHP() <= 0) {
                gameStatus = GameStatus.GAME_OVER;
                menu.gameOver();
            }
        }
    }

    private int moveForward(int number, int position) throws CharacterOutsideOfBoardException {
        int newPosition = position + number;
        board.acceptPlayerAt(newPosition);
        board.setPlayerPosition(newPosition);
        return newPosition;
    }

    private void moveBackward(int position, int number) throws CharacterOutsideOfBoardException {
        int newPosition = position - number;
        if (newPosition < 0){
            newPosition = 0;
        }
        board.acceptPlayerAt(newPosition);
        board.setPlayerPosition(newPosition);
    }

    private Hero modify(Hero character) {
        switch (menu.modifyCharacter()) {
            case CLASS -> character = defineCharacter(character.getName());
            case NAME -> character.setName(defineName());
            case QUIT -> onQuitAsked();
        }
        return character;
    }

    private Hero validateCharacter(Hero character) {
        menu.showCharacterNameAndClass(character);
        switch (menu.askValidationOfCharacter()) {
            case VALIDATE -> {
                return character;
            }
            case MODIFY -> validateCharacter(modify(character));
            case QUIT -> onQuitAsked();
        }
        return character;
    }

    @Override
    public void onQuitAsked() {
        gameStatus = GameStatus.QUIT_GAME;
    }
}

