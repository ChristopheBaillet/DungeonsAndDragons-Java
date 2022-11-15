public class Case {
    private int number;
    public Case(int number) {
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
