package JavaAdvanced.P07StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String pathInput = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        String pathOutputWriter = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\ExtractIntegers_4.txt";

        FileInputStream inputStream = new FileInputStream(pathInput);
        Scanner scanner = new Scanner(inputStream);

        FileOutputStream outputStream = new FileOutputStream(pathOutputWriter);
        PrintWriter writer = new PrintWriter(outputStream);

        //hasNext -> true: не сме стигнали до края на файла
        //hasNext -> false: сме стигнали до края на файла
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.println(number);
            }
            scanner.next();
        }

        writer.close();
    }
}