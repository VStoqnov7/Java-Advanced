package JavaAdvanced.P12DefiningClassesExercises.P09CatLady.P09CatLady;

public class StreetExtraordinaire {

    private String name;
    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        this.name = name;
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StreetExtraordinaire").append(" ").append(name).append(" ").append(String.format("%.2f",decibelsOfMeows));
        return sb.toString();
    }
}
