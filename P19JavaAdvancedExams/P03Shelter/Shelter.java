package JavaAdvanced.P19JavaAdvancedExams.P03Shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Animal> getData() {
        return data;
    }

    public void setData(List<Animal> data) {
        this.data = data;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Animal animal1) {
        if (data.size() < capacity){
            data.add(animal1);
        }
    }

    public boolean remove(String name){
        if (data.isEmpty()){
            return false;
        }
        for (Animal animal1 : data) {
            String nameAnimal = animal1.getName();
            if (nameAnimal.equals(name)){
                data.remove(animal1);
                return true;
            }
        }
        return false;
    }


    public Animal getAnimal(String name, String caretaker) {

        if (data.isEmpty()){
            return null;
        }

        for (Animal animal1 : data) {
            String nameAnimal = animal1.getName();
            String caretakerAnimal = animal1.getCaretaker();
            if (nameAnimal.equals(name) && caretakerAnimal.equals(caretaker)){
                return animal1;
            }
        }
        return null;
    }

    public Animal getOldestAnimal(){
        int ageOld = 0;
        Animal oldAnimal = null;

        for (Animal animal1 : data) {
            int age = animal1.getAge();
            if (ageOld < age){
                ageOld = age;
                oldAnimal= animal1;
            }
        }
        return oldAnimal;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){


        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:").append("\n");
        for (Animal animal1 : data) {
            sb.append(animal1.getName()).append(" ").append(animal1.getCaretaker()).append("\n");
        }


        return sb.toString();
    }


}






















