package JavaAdvanced.P19JavaAdvancedExams;

import java.util.Scanner;

public class P02Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char [][] matrix = new char[n][n];
        fillMatrix(matrix,scanner);
        int rowMatrix = searchRow(matrix);
        int colMatrix = searchCol(matrix);

        int count = 0;

        String command = scanner.nextLine();

        while (true){

            switch (command) {
                case "right":
                    if (colMatrix + 1 < matrix[rowMatrix].length) {
                        matrix[rowMatrix][colMatrix] = '-';
                        colMatrix++;
                    }else {
                        matrix[rowMatrix][colMatrix] = '-';
                        System.out.println("Bad news, you are out of the bakery.");
                        System.out.printf("Money: %d%n",count);
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case "left":
                    if (colMatrix - 1 >= 0) {
                        matrix[rowMatrix][colMatrix] = '-';
                        colMatrix--;
                    }else {
                        matrix[rowMatrix][colMatrix] = '-';
                        System.out.println("Bad news, you are out of the bakery.");
                        System.out.printf("Money: %d%n",count);
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case "up":
                    if (rowMatrix - 1 >= 0) {
                        matrix[rowMatrix][colMatrix] = '-';
                        rowMatrix--;
                    }else {
                        matrix[rowMatrix][colMatrix] = '-';
                        System.out.println("Bad news, you are out of the bakery.");
                        System.out.printf("Money: %d%n",count);
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case "down":
                    if (rowMatrix + 1 < matrix.length) {
                        matrix[rowMatrix][colMatrix] = '-';
                        rowMatrix++;
                    }else {
                        matrix[rowMatrix][colMatrix] = '-';
                        System.out.println("Bad news, you are out of the bakery.");
                        System.out.printf("Money: %d%n",count);
                        printMatrix(matrix);
                        return;
                    }
                    break;
            }


            char symbol = matrix[rowMatrix][colMatrix];

            if (Character.isDigit(symbol)){
                count += Character.getNumericValue(symbol);
                matrix[rowMatrix][colMatrix] = 'S';
                if (count >= 50){
                    System.out.println("Good news! You succeeded in collecting enough money!");
                    System.out.printf("Money: %d%n",count);
                    printMatrix(matrix);
                    return;

                }
            } else if (symbol == 'O') {
                matrix[rowMatrix][colMatrix] = '-';
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        if (matrix[row][col] == 'O'){
                            rowMatrix = row;
                            colMatrix = col;
                            break;
                        }
                    }
                }

                matrix[rowMatrix][colMatrix] = 'S';
            } else if (symbol == '-') {
                matrix[rowMatrix][colMatrix] = 'S';

            }


            command = scanner.nextLine();

        }

























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
                if (symbol == 'S'){                                                   /////TODO!!!!!!!!!!!!!!!!!!!
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
                if (symbol == 'S'){                                                  ///TODO!!!!!!!!!!!!!!!!!!!!
                    return row;
                }
            }
        }
        return -1;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            String command = scanner.nextLine();
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
