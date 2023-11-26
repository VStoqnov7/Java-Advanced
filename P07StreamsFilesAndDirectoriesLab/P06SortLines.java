package JavaAdvanced.P07StreamsFilesAndDirectoriesLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class P06SortLines {
    public static void main(String[] args) throws IOException {



        String pathRead = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        String pathWrite = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\SortLines_6.txt";

        List<String> allLines = Files.readAllLines(Path.of(pathRead));
        Collections.sort(allLines);
        Files.write(Path.of(pathWrite), allLines);


    }
}