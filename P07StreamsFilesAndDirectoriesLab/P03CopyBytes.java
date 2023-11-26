package JavaAdvanced.P07StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class P03CopyBytes {
    public static void main(String[] args) throws IOException {

        String pathInput = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        String pathOutput = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\CopyBytes_3.txt";

        FileInputStream in = new FileInputStream(pathInput);
        FileOutputStream out = new FileOutputStream(pathOutput);

        int oneByte = in.read();
        while (oneByte >= 0) {
            if (oneByte == 32 || oneByte == 10) {
                out.write(oneByte);
            } else {
                String digits = String.valueOf(oneByte);
                for (int i = 0; i < digits.length(); i++) {
                    out.write(digits.charAt(i));
                }
            }
            oneByte = in.read();

        }
    }
}