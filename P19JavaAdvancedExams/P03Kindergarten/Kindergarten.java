package JavaAdvanced.P19JavaAdvancedExams.P03Kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {

    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child){


        if (registry.size() < capacity){
            registry.add(child);
            return true;
        }else {
            return false;
        }
    }

    public boolean removeChild(String firstName){

        if (registry.isEmpty()){
            return false;
        }

        for (Child child : registry) {

            if (firstName.equals(child.getFirstName())){
                registry.remove(child);
                return true;
            }

        }

        return false;
    }

    public int getChildrenCount(){

        return registry.size();
    }
    public Child getChild(String firstName){

//        return registry.stream().filter(e -> e.getFirstName().equals(firstName)).findFirst().orElse(null);

        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)){
                return child;
            }
        }
        return null;
    }



    public String registryReport(){



        List<Child> sortedList = registry.stream()
                .sorted(Comparator.comparing(Child::getAge).thenComparing(Child::getFirstName).thenComparing(Child::getLastName)).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Registered children in %s:",name)).append(System.lineSeparator());



        for (Child child : sortedList) {
            sb.append("--").append(System.lineSeparator());

            sb.append(child.toString()).append(System.lineSeparator());
        }

//        return sb.toString().trim();

        return sb.toString();
    }

}
