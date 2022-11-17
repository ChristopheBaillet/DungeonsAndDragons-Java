package fr.campus_numerique.module_java.d_d;

public class Box {
    private int number;
    public Box(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Case{" +
                "number=" + number +
                '}';
    }
}
