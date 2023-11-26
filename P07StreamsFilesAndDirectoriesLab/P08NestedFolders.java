package JavaAdvanced.P07StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.util.ArrayDeque;

public class P08NestedFolders {

    public static void main(String[] args) {


        String pathRead = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";


        File root = new File(pathRead);

        ArrayDeque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 0;
        //Breadth-First Search (BFS)
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.printf("%d folders\n", count);
    }
}