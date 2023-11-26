package JavaAdvanced.P12DefiningClassesExercises.P03SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double priceForOneKilometer;
    private int distance = 0;

    public Car(String model, double fuel, double priceForOneKilometer) {
        this.model = model;
        this.fuel = fuel;
        this.priceForOneKilometer = priceForOneKilometer;
    }

    public Car(String model, double fuel, double priceForOneKilometer, int distance) {
        this.model = model;
        this.fuel = fuel;
        this.priceForOneKilometer = priceForOneKilometer;
        this.distance = distance;
    }

    public double getFuel() {
        return fuel;
    }

    public double getPriceForOneKilometer() {
        return priceForOneKilometer;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return String.format(" %.2f %d",this.fuel,this.distance);
    }
}
