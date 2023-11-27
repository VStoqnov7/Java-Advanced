package JavaAdvanced.P19JavaAdvancedExams.P03Dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Car car){
        if (data.size() < capacity){
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model){
        for (Car item : data) {
            if (item.getManufacturer().equals(manufacturer) && item.getModel().equals(model)){
                data.remove(item);
                return true;
            }
        }
        return false;
    }
    public Car getLatestCar(){
        if (data.isEmpty()){
            return null;
        }
        Car car = data.get(0);
        for (Car item : data) {
            if (item.getYear() > car.getYear()){
                car = item;
            }
        }
        return car;
    }

    public Car getCar(String manufacturer, String model){

        for (Car item : data) {
            if (item.getManufacturer().equals(manufacturer) && item.getModel().equals(model)){
                return item;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(" The cars are in a car dealership %s:",name)).append(System.lineSeparator());

        for (Car item : data) {
            sb.append(item.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

}
