import java.util.Scanner;

public class Game {
    private final Menu menu = new Menu();
    private final Scanner scanner = new Scanner(System.in);

    public void main() {
        start();
    }
    public void start(){
        Personnage character = menu.start();
    }


}
