package JavaAdvanced.P19JavaAdvancedExams.P03Parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private List<Parrot> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (data.size() < capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        if (data.isEmpty()){
            return false;
        }

        for (Parrot item : data) {
            if (item.getName().equals(name)) {
                data.remove(item);
                return true;
            }
        }
        return false;
    }


    public Parrot sellParrot(String name) {
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {

        List<Parrot> sort = new ArrayList<>();
        for (Parrot item : data) {
            if (item.getSpecies().equals(species)) {
                item.setAvailable(false);
                sort.add(item);

            }
        }
        return sort;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(name).append(":").append("\n");
        for (Parrot item : data) {
            if (item.getAvailable()){
                sb.append(item.toString()).append("\n");

            }
        }
        return sb.toString().trim();
    }

}
