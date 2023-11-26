package JavaAdvanced.P07StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;

import java.io.IOException;


public class P01ReadFile {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";


        FileInputStream inputStream = new FileInputStream(path);

        int currentByte = inputStream.read();
        while (currentByte >= 0) {
            //79 -> двоична бройна система ("1001111")
            System.out.print(Integer.toBinaryString(currentByte) + " ");
            currentByte = inputStream.read();
        }

        inputStream.close();
    }
}
