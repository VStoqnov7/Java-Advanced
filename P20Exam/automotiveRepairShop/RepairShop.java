package JavaAdvanced.P20Exam.automotiveRepairShop;

import java.util.ArrayList;
import java.util.List;

public class RepairShop {

    private List<Vehicle> vehicles;
    private int capacity;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        if (vehicles.size() < capacity){
            vehicles.add(vehicle);
        }
    }
    public boolean removeVehicle(String vin){
        for (Vehicle item : vehicles) {
            if (item.getVIN().equals(vin)){
                vehicles.remove(item);
                return true;
            }
        }
        return false;
    }

    public int getCount(){
        return vehicles.size();
    }

    public Vehicle getLowestMileage(){

        if (vehicles.isEmpty()){
            return null;
        }
        Vehicle vehicle = vehicles.get(0);
        for (Vehicle item : vehicles) {
            if (item.getMileage() < vehicle.getMileage()){
                vehicle = item;
            }
        }
        return vehicle;
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:").append(System.lineSeparator());

        for (Vehicle item : vehicles) {
            sb.append(item.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
