package JavaAdvanced.P19JavaAdvancedExams.P03Aquarium;

public class Fish {

    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getFins() {
        return fins;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Fish: %s",name)).append("\n");
        sb.append(String.format("Color: %s",color)).append("\n");
        sb.append(String.format("Number of fins: %d",fins));

        return sb.toString().trim();
    }
}
