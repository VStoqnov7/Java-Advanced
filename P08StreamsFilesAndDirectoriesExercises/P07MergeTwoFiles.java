package JavaAdvanced.P08StreamsFilesAndDirectoriesExercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P07MergeTwoFiles {
        public static void main(String[] args) throws IOException {


            //1. четем всички редове от файл 1
            String pathOne = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-P14Exercises-Resources\\inputOne.txt";

            //2. четем всички редове от файл 2
            String pathTwo = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-P14Exercises-Resources\\inputTwo.txt";

            //3. записваме всички редове във файл 3
            String pathOfPrint = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-P14Exercises-Resources\\outputMergeTwoFiles.txt";
            PrintWriter writer = new PrintWriter(pathOfPrint);



            List<String> allLinesFileOne = Files.readAllLines(Path.of(pathOne)); //всички редове от файл 1
            allLinesFileOne.forEach(line -> writer.println(line));
            List<String> allLinesFileTwo = Files.readAllLines(Path.of(pathTwo)); //всички редове от файл 2
            allLinesFileTwo.forEach(line -> writer.println(line));

            writer.close();


        }

    }