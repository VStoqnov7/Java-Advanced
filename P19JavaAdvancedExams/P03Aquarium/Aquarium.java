package JavaAdvanced.P19JavaAdvancedExams.P03Aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void add(Fish fish){

        boolean isValid = true;

        for (Fish item : fishInPool) {
            if (item.getName().equals(fish.getName())){
                isValid = false;
            }
        }


        if (fishInPool.size() < capacity && isValid){
            fishInPool.add(fish);
        }

    }

    public boolean remove(String name){

        for (Fish item : fishInPool) {
            if (item.getName().equals(name)) {
                fishInPool.remove(item);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name){


        for (Fish item : fishInPool) {
            if (item.getName().equals(name)){
                return item;
            }
        }


        return null;

    }

    public String report(){

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Aquarium: %s ^ Size: %d",name,size)).append("\n");
        for (Fish item : fishInPool) {
            sb.append(item.toString()).append("\n");
        }

        return sb.toString().trim();

    }
}
