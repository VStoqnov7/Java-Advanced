package JavaAdvanced.P08StreamsFilesAndDirectoriesExercises;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {

        //1. прочитам всички редове от файл inputLineNumbers.txt
        //2. обхождаме всеки ред -> записваме в нов файл с пореден номер отпред


        String pathIn = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-P14Exercises-Resources\\inputLineNumbers.txt";
        String pathOut = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-P14Exercises-Resources\\outputLineNumbers_5.txt";


        FileInputStream in = new FileInputStream(pathIn);

        PrintWriter writer = new PrintWriter(pathOut);


        List<String> line = Files.readAllLines(Path.of(pathIn));

        int count = 1;

        for (String item : line) {

            writer.printf("%d. %s%n",count,item);
            count++;


        }

        writer.close(); //спирам да пиша във файла и файлът се затваря

    }
}
