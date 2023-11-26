package JavaAdvanced.P08StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class P10SerializeArrayList {

        public static void main(String[] args) throws IOException, ClassNotFoundException {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-P14Exercises-Resources\\SerializeArrayList_10.ser"));
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-P14Exercises-Resources\\SerializeArrayList_10.ser"));

            List<Double> serializableList = new ArrayList<>();
            serializableList.add(22.3);
            serializableList.add(1.8);
            serializableList.add(9.2);

            objectOutputStream.writeObject(serializableList);
            List<Double> newSerializableList = (List<Double>) objectInputStream.readObject();
            newSerializableList.forEach(System.out::println);
        }
    }