package JavaAdvanced.P19JavaAdvancedExams.P03SoftUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private List<Student> data;
    private int capacity;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public int getCapacity() {

        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public List<Student> getData() {

        return data;
    }

    public void setData(List<Student> data) {

        this.data = data;
    }

    public void setCapacity(int capacity) {

        this.capacity = capacity;
    }

    public String insert(Student student) {
        if (data.contains(student)) {
            return "Student is already in the hall.";
        } else {

            if (data.size() < capacity) {

                data.add(student);
                return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
            } else {
                return "The hall is full.";
            }

        }

    }


    public String remove(Student studentTwo) {
        if (data.contains(studentTwo)) {
            String firstName = studentTwo.getFirstName();
            String lastName = studentTwo.getLastName();
            data.remove(studentTwo);
            return String.format("Removed student %s %s.", firstName, lastName);
        }else {

            return "Student not found.";
        }
    }

    public Student getStudent(String firstNme, String lastName) {

        for (Student item : data) {
            if (item.getFirstName().equals(firstNme) && item.getLastName().equals(lastName)) {
                return item;
            }
        }


        return null;
    }

    public String getStatistics() {

        StringBuilder sb = new StringBuilder();
        sb.append("Hall size: ").append(data.size()).append(System.lineSeparator());
        for (Student item : data) {
            sb.append(item.toString()).append(System.lineSeparator());
        }



        return sb.toString();

    }
}
