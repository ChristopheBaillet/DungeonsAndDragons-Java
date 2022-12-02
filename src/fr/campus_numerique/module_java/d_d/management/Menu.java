package fr.campus_numerique.module_java.d_d.management;

import fr.campus_numerique.module_java.d_d.entity.character.Enemy;
import fr.campus_numerique.module_java.d_d.entity.character.Hero;
import fr.campus_numerique.module_java.d_d.entity.character.Personage;
import fr.campus_numerique.module_java.d_d.entity.character.type.Warrior;
import fr.campus_numerique.module_java.d_d.entity.stuff.Item;
import fr.campus_numerique.module_java.d_d.utilitary.Color;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Menu implements MenuListenable {
    private final ArrayList<MenuListener> observers = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private static Menu INSTANCE = null;

    public synchronized static Menu getInstance() {
        if (INSTANCE == null){
            INSTANCE = new Menu();
        }
        return INSTANCE;
    }

    private Menu(){

    }

    public GameStatus main(Personage character) {
        UserChoice userInput;
        GameStatus status = null;
        String message = character != null ? "[1] Create character | [2] Load Character |[3] Start Game | [4] Modify | [q] Quit"
                : "[1] Create character | [2] Load character |[q] Quit";
        String characterInfos = character != null ? "Your character is : "+character : "";
        do {
            if (!characterInfos.equals("")){
                System.out.println(characterInfos);
            }
            switch (askQuestion(message)) {
                case "1" -> {
                    userInput = UserChoice.CREATE_CHARACTER;
                    status = GameStatus.CREATING_CHARACTER;
                }
                case "2" -> {
                    userInput = UserChoice.LOAD_CHARACTER;
                    status = GameStatus.LOAD_CHARACTER;
                }
                case "3" -> {
                    userInput = character != null ? UserChoice.PLAY : UserChoice.WRONG_ANSWER;
                    status = userInput != UserChoice.WRONG_ANSWER ? GameStatus.ON_GOING : GameStatus.UNINITIALIZED;
                }
                case "4" -> {
                    userInput = character != null ? UserChoice.MODIFY : UserChoice.WRONG_ANSWER;
                    status = userInput != UserChoice.WRONG_ANSWER ? GameStatus.MODIFY : GameStatus.UNINITIALIZED;
                }
                case "q" -> {
                    userInput = UserChoice.QUIT;
                    status = GameStatus.QUIT_GAME;
                }
                default -> userInput = UserChoice.WRONG_ANSWER;
            }
        } while (userInput == UserChoice.WRONG_ANSWER);
        return status;
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

    public UserChoice inGame() {
        UserChoice userInput;
        do {
            userInput = switch (askQuestion("[] Type nothing and press enter to continue | [i] Show infos | [q] Quit | [help] Show Help Menu")) {
                case "" -> UserChoice.PLAY;
                case "i" -> UserChoice.SHOW_INFOS;
                case "q" -> UserChoice.QUIT;
                case "help" -> UserChoice.HELP;
                default -> UserChoice.WRONG_ANSWER;
            };
        } while (userInput == UserChoice.WRONG_ANSWER);
        if(userInput == UserChoice.QUIT){
            notifyOnQuitAsked();
        }
        return userInput;
    }

    public void showHelpInfos() {
        System.out.println("During the game");
        System.out.println("Type enter to play a turn");
        System.out.println("Type i to show your character infos");
        System.out.println("Type q to exit the game");
        System.out.println("Type help to get this list");
    }

    public void gameOver() {
        System.out.println(Color.RED_BOLD_BRIGHT + "                                                                                                                                                                         \n" +
                "                                                                                                                                                                         \n" +
                "        GGGGGGGGGGGGG                                                                        OOOOOOOOO                                                                   \n" +
                "     GGG::::::::::::G                                                                      OO:::::::::OO                                                                 \n" +
                "   GG:::::::::::::::G                                                                    OO:::::::::::::OO                                                               \n" +
                "  G:::::GGGGGGGG::::G                                                                   O:::::::OOO:::::::O                                                              \n" +
                " G:::::G       GGGGGG  aaaaaaaaaaaaa      mmmmmmm    mmmmmmm       eeeeeeeeeeee         O::::::O   O::::::Ovvvvvvv           vvvvvvv eeeeeeeeeeee    rrrrr   rrrrrrrrr   \n" +
                "G:::::G                a::::::::::::a   mm:::::::m  m:::::::mm   ee::::::::::::ee       O:::::O     O:::::O v:::::v         v:::::vee::::::::::::ee  r::::rrr:::::::::r  \n" +
                "G:::::G                aaaaaaaaa:::::a m::::::::::mm::::::::::m e::::::eeeee:::::ee     O:::::O     O:::::O  v:::::v       v:::::ve::::::eeeee:::::eer:::::::::::::::::r \n" +
                "G:::::G    GGGGGGGGGG           a::::a m::::::::::::::::::::::me::::::e     e:::::e     O:::::O     O:::::O   v:::::v     v:::::ve::::::e     e:::::err::::::rrrrr::::::r\n" +
                "G:::::G    G::::::::G    aaaaaaa:::::a m:::::mmm::::::mmm:::::me:::::::eeeee::::::e     O:::::O     O:::::O    v:::::v   v:::::v e:::::::eeeee::::::e r:::::r     r:::::r\n" +
                "G:::::G    GGGGG::::G  aa::::::::::::a m::::m   m::::m   m::::me:::::::::::::::::e      O:::::O     O:::::O     v:::::v v:::::v  e:::::::::::::::::e  r:::::r     rrrrrrr\n" +
                "G:::::G        G::::G a::::aaaa::::::a m::::m   m::::m   m::::me::::::eeeeeeeeeee       O:::::O     O:::::O      v:::::v:::::v   e::::::eeeeeeeeeee   r:::::r            \n" +
                " G:::::G       G::::Ga::::a    a:::::a m::::m   m::::m   m::::me:::::::e                O::::::O   O::::::O       v:::::::::v    e:::::::e            r:::::r            \n" +
                "  G:::::GGGGGGGG::::Ga::::a    a:::::a m::::m   m::::m   m::::me::::::::e               O:::::::OOO:::::::O        v:::::::v     e::::::::e           r:::::r            \n" +
                "   GG:::::::::::::::Ga:::::aaaa::::::a m::::m   m::::m   m::::m e::::::::eeeeeeee        OO:::::::::::::OO          v:::::v       e::::::::eeeeeeee   r:::::r            \n" +
                "     GGG::::::GGG:::G a::::::::::aa:::am::::m   m::::m   m::::m  ee:::::::::::::e          OO:::::::::OO             v:::v         ee:::::::::::::e   r:::::r            \n" +
                "        GGGGGG   GGGG  aaaaaaaaaa  aaaammmmmm   mmmmmm   mmmmmm    eeeeeeeeeeeeee            OOOOOOOOO                vvv            eeeeeeeeeeeeee   rrrrrrr            \n" +
                "                                                                                                                                                                         " + Color.RESET);
    }

    public UserChoice askFightOrFlee(Enemy enemy) {
        UserChoice userInput;
        do {
            userInput = switch (askQuestion("[1] Fight | [2] Flee")) {
                case "1" -> UserChoice.FIGHT;
                case "2" -> UserChoice.FLEE;
                default -> UserChoice.WRONG_ANSWER;
            };
        }while (userInput == UserChoice.WRONG_ANSWER);
        return userInput;
    }

    public UserChoice askTakeItem(Item item) {
        return UserChoice.YES;
    }

    @Override
    public void addMenuObserver(MenuListener menuObserver) {
        if (menuObserver != null && !observers.contains(menuObserver)){
            observers.add(menuObserver);
        }
    }

    @Override
    public void removeMenuObserver(MenuListener menuObserver) {
        observers.remove(menuObserver);
    }

    private void notifyOnQuitAsked(){
        for (MenuListener observer : observers) {
            observer.onQuitAsked();
        }
    }

    public Integer chooseCharacter(Map<Integer, Hero> result) {
        String message = "";
        ArrayList <Integer> availableIndex = new ArrayList<>();
        for (Map.Entry<Integer,Hero> entry : result.entrySet()){
            availableIndex.add(entry.getKey());
            message += "Press ["+ entry.getKey()+"] to select " + entry.getValue() + "\n";
        }
        String userChoice = "";
        Integer index;
        do {
            userChoice = askQuestion(message);
            index = Integer.parseInt(userChoice);
        }while (!availableIndex.contains(index));
        return index;
    }
}
