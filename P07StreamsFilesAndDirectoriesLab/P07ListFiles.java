package JavaAdvanced.P07StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.FileNotFoundException;

public class P07ListFiles {
    public static void main(String[] args) throws FileNotFoundException {


        String pathRead = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File folder = new File(pathRead);


        if (folder.exists()) {
            //съществува такъв файл
            if (folder.isDirectory()) {
                //файлър е папка
                File[] allFiles = folder.listFiles();
                for (File file : allFiles) {
                    if (!file.isDirectory()) {
                        System.out.printf("%s: [%d]%n", file.getName(), file.length());
                    }
                }
            }
        }
    }
}