package JavaAdvanced.P12DefiningClassesExercises.P09CatLady.P09CatLady;

public class Siamese {

    private String name;
    private double earSize;


    public Siamese(String name, double earSize) {
        this.name = name;
        this.earSize = earSize;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Siamese").append(" ").append(name).append(" ").append(String.format("%.2f",earSize));
        return sb.toString();
    }
}
