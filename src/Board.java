import java.util.Arrays;
import java.util.Random;
public class Board {
    private final int nbCases = 64;
    private String status;
    private final Random random = new Random();
    private final Case[] cases = new Case[nbCases];
    public Board(){
        for (int i = 0; i < this.cases.length ; i++){
            this.cases[i] = new Case(i+1);
        }
    }

    @Override
    public String toString() {
        return "Board{" +
                "status='" + status + '\'' +
                ", random=" + random +
                ", cases=" + Arrays.toString(cases) +
                '}';
    }

    public void printArray(Case[] cases, int playerPosition){
        for (Case c : cases) {
            if (c.getNumber() == playerPosition){
                System.out.print("|***");
            }else {
                System.out.print("|"+c.getNumber());
            }
        }
        System.out.println("");
    }
    public void initialize(Personnage character){
        this.status = "playing";
        character.setPosition(1);
    }

   /** private int[] rollDices(){
        int dice1 = random.nextInt(1,6);
        int dice2 = random.nextInt(1,6);
        return new int[]{dice1, dice2};
    }

    public void playATurn(){
        int[] roll = rollDices();
        this.playerPosition += roll[0] + roll[1];
        if (this.playerPosition > nbCases){
            int diff = this.playerPosition - 64;
            this.playerPosition = 64 - diff;
        }
        printArray(cases);
        if (this.playerPosition == nbCases){
            this.status = "finished";
            System.out.println("finished "+ this.playerPosition);
        }
        System.out.println(this.playerPosition);
    }
*/
    public String getStatus() {
        return status;
    }
    public Case[] getCases() {
        return cases;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNbCases() {
        return nbCases;
    }
}
