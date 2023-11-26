package JavaAdvanced.P12DefiningClassesExercises.P09CatLady.P09CatLady;

public class Cymrik {

    private String name;
    private double furLength;


    public Cymrik(String name, double furLength) {
        this.name = name;
        this.furLength = furLength;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cymric").append(" ").append(name).append(" ").append(String.format("%.2f",furLength));
        return sb.toString();
    }
}
