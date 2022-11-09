public class DefensiveStuff {
    private String name,type;
    private int power;

    public DefensiveStuff(String name, String type, int power){
        this.name = name;
        this.power = power;
        this.type = type;
    }
    @Override
    public String toString() {
        return "DefensiveStuff{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", power=" + power +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
