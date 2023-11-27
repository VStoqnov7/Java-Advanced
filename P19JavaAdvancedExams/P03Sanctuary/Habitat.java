package JavaAdvanced.P19JavaAdvancedExams.P03Sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {

    private List<Elephant> data;
    private int capacity;


    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Elephant> getData() {
        return data;
    }

    public void setData(List<Elephant> data) {
        this.data = data;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Elephant elephant) {

        if (data.size() < capacity){
            data.add(elephant);
        }

    }

    public boolean remove(String name){

        for (Elephant elephant : data) {

            String nameElephant = elephant.getName();
            if (nameElephant.equals(name)){
                data.remove(elephant);
                return true;
            }
        }

        return false;

    }

    public Elephant getElephant(String retiredFrom){

        for (Elephant elephant : this.data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                return elephant;
            }
        }
        return null;
    }

    public Elephant getOldestElephant(){
        int age = 0;
        Elephant elephant = null;

        for (Elephant element : data) {

            int ageElement = element.getAge();
            if (age < ageElement){
                age = ageElement;
                elephant = element;
            }

        }
        return elephant;
    }
    public int getAllElephants(){
        return data.size();
    }

    public String getReport(){
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:").append("\n");
        if (!data.isEmpty()){
            for (Elephant elephant : data) {
                sb.append(elephant.getName()).append(" came from: ").append(elephant.getRetiredFrom()).append("\n");
            }

        }
        return sb.toString().trim();
        ////Saved elephants in the park:
        ////Bibi came from: Private Zoo
        ////Lola came from: National Circus of Thailand

    }
}
