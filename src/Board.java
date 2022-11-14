import java.util.Random;
public class Board {
    private String status;
    private final Random random = new Random();
    private int playerPosition;
    private final int[] cases = new int[64];

    public Board(){
        for (int i = 0; i < this.cases.length ; i++){
            this.cases[i] = i + 1;
        }
    }


    private void printArray(int[] array){
        for (int j : array) {
            if (j == this.playerPosition){
                System.out.print("|***");
            }else {
                System.out.print("|"+j);
            }
        }
        System.out.println("");
    }
    public void initialize(){
        this.status = "playing";
        this.playerPosition = 1;
    }

    private int[] rollDices(){
        int dice1 = random.nextInt(1,6);
        int dice2 = random.nextInt(1,6);
        return new int[]{dice1, dice2};
    }

    public void playATurn(){
        int[] roll = rollDices();
        this.playerPosition += roll[0] + roll[1];
        if (this.playerPosition > 64){
            int diff = this.playerPosition - 64;
            this.playerPosition = 64 - diff;
        }
        printArray(this.cases);
        if (this.playerPosition == 64){
            this.status = "finished";
            System.out.println("finished "+ this.playerPosition);
        }
        System.out.println(this.playerPosition);
    }

    public String getStatus() {
        return status;
    }
}
