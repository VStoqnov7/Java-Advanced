package JavaAdvanced.P19JavaAdvancedExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String rowAndCol = scanner.nextLine();
        int rows = Integer.parseInt(rowAndCol.split("\\s+")[0]);
        int cols = Integer.parseInt(rowAndCol.split("\\s+")[1]);

        char [][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {

            String command = scanner.nextLine().replaceAll(" ","");
            char[] symbols = command.toCharArray();
            matrix[row] = symbols;
        }

        int rowMatrix = -1;
        int colMatrix = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'Y'){
                    rowMatrix = row;
                    colMatrix = col;
                    break;
                }
            }

        }

        List<String> list = new ArrayList<>();

        String command = scanner.nextLine();

        while (!command.equals("Finish")){





            switch (command){
                case "right":
                    if (colMatrix + 1 < matrix[rowMatrix].length){
                        if (matrix[rowMatrix][colMatrix + 1] != 'T'){
                        colMatrix++;
                            list.add(command.trim());
                        }
                    }
                    break;
                case "left":
                    if (colMatrix - 1 >= 0){
                        if (matrix[rowMatrix][colMatrix - 1] != 'T'){
                            colMatrix--;
                            list.add(command.trim());
                        }
                    }
                    break;
                case "up":
                    if (rowMatrix - 1 >= 0){
                        if (matrix[rowMatrix - 1][colMatrix] != 'T'){
                            rowMatrix--;
                            list.add(command.trim());
                        }
                    }
                    break;
                case "down":
                    if (rowMatrix + 1 < matrix.length){
                        if (matrix[rowMatrix + 1][colMatrix] != 'T'){
                            rowMatrix++;
                            list.add(command.trim());
                        }
                    }
                    break;

            }

            command = scanner.nextLine();
        }

        char currentSymbol = matrix[rowMatrix][colMatrix];
        StringBuilder sb = new StringBuilder();


        if (currentSymbol == 'X'){
            sb.append("I've found the treasure!").append("\n");
            sb.append("The right path is ");

            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1){
                    sb.append(", ");
                }
            }

        }else {
            sb.append("The map is fake!");

        }


        System.out.println(sb.toString());



    }
}
