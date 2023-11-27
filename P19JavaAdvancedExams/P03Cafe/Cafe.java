package JavaAdvanced.P19JavaAdvancedExams.P03Cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {

    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }


    public void addEmployee(Employee employee){
        if (employees.size() < capacity){
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){

        for (Employee item : employees) {
            if (item.getName().equals(name)){
                employees.remove(item);
                return true;
            }
        }

        return false;
    }

    public Employee getOldestEmployee(){
        Employee employee = employees.get(0);
        for (Employee item : employees) {
            if (item.getAge() > employee.getAge()){
                employee = item;
            }
        }
        return employee;
    }

    public Employee getEmployee(String name){
        for (Employee item : employees) {
            if (item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }
    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:",name)).append(System.lineSeparator());
        for (Employee item : employees) {
            sb.append(item.toString()).append(System.lineSeparator());
        }


        return sb.toString().trim();

    }
}
