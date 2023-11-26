package JavaAdvanced.P08StreamsFilesAndDirectoriesExercises;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P09CopyAPicture {


    public static void main(String[] args) throws IOException, FileNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-P14Exercises-Resources\\Ven.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-P14Exercises-Resources\\Ven-Copy.jpg");

        byte[] buffer = new byte[1024];

        while (fileInputStream.read(buffer) != -1) {
            fileOutputStream.write(buffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}