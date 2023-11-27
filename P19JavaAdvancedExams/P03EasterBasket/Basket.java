package JavaAdvanced.P19JavaAdvancedExams.P03EasterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }


    public List<Egg> getData() {
        return data;
    }

    public void addEgg(Egg egg){
        if (data.size() < capacity){
            data.add(egg);
        }
    }

    public boolean removeEgg(String color){
        if (data.isEmpty()){
            return false;
        }
        for (Egg item : data) {
            if (item.getColor().equals(color)){
                data.remove(item);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg(){
        int power = 0;
        Egg powerEgg = null;
        for (Egg item : data) {
            if (item.getStrength() > power){
                power = item.getStrength();
                powerEgg = item;
            }
        }

        return powerEgg;
    }

    public Egg getEgg(String color){
        Egg colorEgg = null;
        for (Egg item : data) {
            if (item.getColor().equals(color)){
                colorEgg = item;
            }
        }
        return colorEgg;
    }

    public int getCount(){
        return data.size();
    }

    public String report(){

        StringBuilder sb = new StringBuilder();
        sb.append(material).append(" basket contains:").append("\n");
        for (Egg item : data) {
            sb.append(item.toString()).append("\n");
        }

        return sb.toString().trim();
    }
}
