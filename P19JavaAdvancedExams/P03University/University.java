package JavaAdvanced.P19JavaAdvancedExams.P03University;

import java.util.ArrayList;
import java.util.List;

public class University {
    public List<Student> students;
    public int capacity;


    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStudentCount(){
        return students.size();
    }

    public String registerStudent(Student student){
        if (students.contains(student)){
            return "Student is already in the university";
        }
        if (students.size() < capacity ){
            students.add(student);
            return String.format("Added student %s %s",student.getFirstName(),student.getLastName());
        }else {
            return "No seats in the university";
        }
    }

    public String dismissStudent(Student student){
        if (!students.contains(student)){
            return "Student not found";
        }else {
            students.remove(student);
            return String.format("Removed student %s %s",student.getFirstName(),student.getLastName());
        }
    }

    public Student getStudent(String firstName, String lastName){

        for (Student item : students) {
            if (item.getFirstName().equals(firstName) && item.getLastName().equals(lastName)){
                return item;
            }

        }
        return null;
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        for (Student item : students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    item.getFirstName(),
                    item.getLastName(),
                    item.getBestSubject()))
                    .append(System.lineSeparator());

        }
        return sb.toString();
    }
}
