package JavaAdvanced.P19JavaAdvancedExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> move = Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());
        char[][] matrix = new char[n][n];
        fillMatrix(matrix, scanner);
        int rowMatrix = searchRow(matrix);
        int colMatrix = searchCol(matrix);

        int countFood = 0;
        int length = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                if (symbol == 'f') {
                countFood++;
                }
            }
        }


        for (String item : move) {

            switch (item) {
                case "right":
                    if (colMatrix + 1 < matrix[rowMatrix].length) {
                        matrix[rowMatrix][colMatrix] = '*';
                        colMatrix++;
                    }else {
                        matrix[rowMatrix][colMatrix] = '*';
                        colMatrix = 0;
                    }
                    break;
                case "left":
                    if (colMatrix - 1 >= 0) {
                        matrix[rowMatrix][colMatrix] = '*';
                        colMatrix--;
                    }else {
                        matrix[rowMatrix][colMatrix] = '*';
                        colMatrix = matrix[rowMatrix].length - 1;
                    }
                    break;
                case "up":
                    if (rowMatrix - 1 >= 0) {
                        matrix[rowMatrix][colMatrix] = '*';
                        rowMatrix--;
                    }else {
                        matrix[rowMatrix][colMatrix] = '*';
                        rowMatrix = matrix.length - 1;
                    }
                    break;
                case "down":
                    if (rowMatrix + 1 < matrix.length) {
                        matrix[rowMatrix][colMatrix] = '*';
                        rowMatrix++;
                    }else {
                        matrix[rowMatrix][colMatrix] = '*';
                        rowMatrix = 0;
                    }
                    break;
            }


            char symbol = matrix[rowMatrix][colMatrix];
            if (symbol == 'f'){
                countFood--;
                length++;
                matrix[rowMatrix][colMatrix] = 's';
                if (countFood == 0){
                    System.out.printf("You win! Final python length is %d%n",length);
                    return;

                }
            } else if (symbol == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            } else if (symbol == '*') {
                matrix[rowMatrix][colMatrix] = 's';
            }


        }



        System.out.printf("You lose! There is still %d food to be eaten.",countFood);


    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();

        }

    }

    private static int searchCol(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                if (symbol == 's') {                                                   /////TODO!!!!!!!!!!!!!!!!!!!
                    return col;
                }
            }
        }
        return -1;

    }

    public static int searchRow(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                if (symbol == 's') {                                                  ///TODO!!!!!!!!!!!!!!!!!!!!
                    return row;
                }
            }
        }
        return -1;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            String command = scanner.nextLine().replaceAll(" ", "");
            matrix[row] = command.toCharArray();
        }


    }

//            switch (command){
//                case "right":
//                    if (colMatrix + 1 < matrix[rowMatrix].length){
//                        colMatrix++;
//                    }
//                    break;
//                case "left":
//                    if (colMatrix - 1 >= 0){
//                        colMatrix--;
//                    }
//                    break;
//                case "up":
//                    if (rowMatrix - 1 >= 0){
//                        rowMatrix--;
//                    }
//                    break;
//                case "down":
//                    if (rowMatrix + 1 < matrix.length){
//                        rowMatrix++;
//                    }
//                    break;
//            }
}
