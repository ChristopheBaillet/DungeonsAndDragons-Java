public class OffensiveStuff {
    private String name,type;
    private int power;

    public OffensiveStuff(String name, String type, int power){
        this.name = name;
        this.power = power;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OffensiveStuff{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", power=" + power +
                '}';
    }
}
