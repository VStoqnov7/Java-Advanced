package JavaAdvanced.P11DefiningClassesLab.P02Constructors;

public class Car {

    private String name;
    private String model;
    private int hp;


    public Car(String name, String model, int hp) {
        this.name = name;
        this.model = model;
        this.hp = hp;
    }

    public Car(String name) {
        this.name = name;
        this.model = "unknown";
        this.hp = -1;
    }

    public Car(String name, String model) {
        this.name = name;
        this.model = model;
        this.hp = -1;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getHp() {
        return hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",this.name,this.model,this.hp);
    }
}
