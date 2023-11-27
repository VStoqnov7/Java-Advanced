package JavaAdvanced.P19JavaAdvancedExams.P03GroomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {

    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if (data.size() < capacity){
            data.add(pet);
        }
    }
    public boolean remove(String name){

        for (Pet item : data) {
            if (item.getName().equals(name)){
                data.remove(item);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        for (Pet item : data) {
            if (item.getName().equals(name) && item.getOwner().equals(owner)){
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
        sb.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet item : data) {
            sb.append(item.getName()).append(" ").append(item.getOwner()).append(System.lineSeparator());
        }

        return sb.toString().trim();

    }
}
