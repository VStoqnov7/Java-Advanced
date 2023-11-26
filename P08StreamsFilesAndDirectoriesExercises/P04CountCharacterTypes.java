package JavaAdvanced.P08StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P04CountCharacterTypes {
        public static void main(String[] args) throws IOException {
            //гласни: a, e, i, o, u
            //пунктуационни знаци: ! , . ?
            //съгласни: всичко останало
            int vowelsCount = 0; //броя на гласните букви
            int punctuationCount = 0; //броя на пунктуационните знаци
            int consonantsCount = 0; //броя на съгласните букви

            Set<Character> vowels = getVowels(); //всички възможни главни букви
            Set<Character> punctuationalMarks = getPuntMarks(); //всички възможни пунктуационни знаци


            String pathToFile = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-P14Exercises-Resources\\input.txt";
            String pathOutFile = "C:\\Users\\Bobi\\Desktop\\Pb-oct-2022\\Java-Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-P14Exercises-Resources\\outputCountCharactersTypes.txt";

            List<String> allLines = Files.readAllLines(Path.of(pathToFile));

            for (String line : allLines) {
                //"On January 1 , 1533 , "
                for (int index = 0; index < line.length(); index++) {
                    char currentSymbol = line.charAt(index);
                    if (currentSymbol == ' ') {
                        continue;
                    }
                    //проверка на символа
                    if (vowels.contains(currentSymbol)) { //гласна буква
                        vowelsCount++;
                    } else if (punctuationalMarks.contains(currentSymbol)) { //пунктуационен знак
                        punctuationCount++;
                    } else { //съгласна буква
                        consonantsCount++;
                    }
                }
            }
            //знаем броят на символите във всяка категория
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathOutFile));
            writer.write("Vowels: " + vowelsCount);
            writer.newLine();
            writer.write("Other symbols: " + consonantsCount);
            writer.newLine();
            writer.write("Punctuation: " + punctuationCount);
            writer.close();

        }

        private static Set<Character> getPuntMarks() {
            Set<Character> marks = new HashSet<>();
            marks.add('!');
            marks.add('?');
            marks.add('.');
            marks.add(',');
            return marks;
        }

        private static Set<Character> getVowels() {
            Set<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            return vowels;
        }
    }