package JavaAdvanced.P08StreamsFilesAndDirectoriesExercises;


import java.io.*;

public class P11SerializeCustomObject {
    public static class Courses implements Serializable {
        String name;
        Integer numOfStudents;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-P14Exercises-Resources\\SerializeCustomObject_11_Courses.ser"));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-P14Exercises-Resources\\SerializeCustomObject_11_Courses.ser"));

        Courses course = new Courses();
        course.name = "SoftUni Java";
        course.numOfStudents = 7;
        objectOutputStream.writeObject(course);
        //Deserialized
        Courses deserialization = (Courses) objectInputStream.readObject();
        System.out.printf("%s: %d\n", deserialization.name, deserialization.numOfStudents);

        objectOutputStream.close();
        objectInputStream.close();

    }
}