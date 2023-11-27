package JavaAdvanced.P19JavaAdvancedExams.P03Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
        if (roster.size() < capacity){
            roster.add(person);
        }
    }

    public boolean remove(String name){
        for (Person item : roster) {
            if (item.getName().equals(name)){
                roster.remove(item);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown){

        for (Person item : roster) {
            if (item.getName().equals(name) && item.getHometown().equals(hometown)){
                return item;
            }
        }
        return null;
    }

    public int getCount(){
        return roster.size();
    }

    public String getStatistics(){

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("The people in the hotel %s are:",name)).append(System.lineSeparator());

        for (Person item : roster) {
            sb.append(item).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}

























