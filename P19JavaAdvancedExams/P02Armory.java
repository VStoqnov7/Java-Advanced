package JavaAdvanced.P19JavaAdvancedExams;

import java.util.Scanner;

public class P02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {

            String command = scanner.nextLine();
            matrix[row] = command.toCharArray();

        }

        int rowMatrix = -1;
        int colMatrix = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                if (symbol == 'A') {
                    rowMatrix = row;
                    colMatrix = col;
                    break;
                }
            }

        }

        int sum = 0;

        while (true) {

            String command = scanner.nextLine();

            switch (command) {
                case "right":
                    if (colMatrix + 1 < matrix[rowMatrix].length) {
                        matrix[rowMatrix][colMatrix] = '-';
                        colMatrix++;
                    } else {
                        System.out.println("I do not need more swords!");
                        System.out.printf("The king paid %d gold coins.%n", sum);
                        matrix[rowMatrix][colMatrix] = '-';


                        printMatrix(matrix);
                        return;
                    }

                    break;
                case "left":
                    if (colMatrix - 1 >= 0) {
                        matrix[rowMatrix][colMatrix] = '-';
                        colMatrix--;
                    } else {
                        System.out.println("I do not need more swords!");
                        System.out.printf("The king paid %d gold coins.%n", sum);
                        matrix[rowMatrix][colMatrix] = '-';
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case "up":
                    if (rowMatrix - 1 >= 0) {
                        matrix[rowMatrix][colMatrix] = '-';
                        rowMatrix--;
                    } else {
                        System.out.println("I do not need more swords!");
                        System.out.printf("The king paid %d gold coins.%n", sum);
                        matrix[rowMatrix][colMatrix] = '-';
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case "down":
                    if (rowMatrix + 1 < matrix.length) {
                        matrix[rowMatrix][colMatrix] = '-';
                        rowMatrix++;
                    } else {
                        System.out.println("I do not need more swords!");
                        System.out.printf("The king paid %d gold coins.%n", sum);
                        matrix[rowMatrix][colMatrix] = '-';
                        printMatrix(matrix);
                        return;
                    }
                    break;
            }

            char symbol = matrix[rowMatrix][colMatrix];

            if (symbol == 'M') {
                matrix[rowMatrix][colMatrix] = '-';
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        char currentSymbol = matrix[row][col];
                        if (currentSymbol == 'M') {
                            rowMatrix = row;
                            colMatrix = col;
                            break;
                        }
                    }
                }
                matrix[rowMatrix][colMatrix] = 'A';
            } else if (Character.isDigit(symbol)) {
                int num = Integer.parseInt(String.valueOf(symbol));
                sum += num;
                matrix[rowMatrix][colMatrix] = 'A';
                if (sum >= 65) {
                    System.out.println("Very nice swords, I will come back for more!");
                    System.out.printf("The king paid %d gold coins.%n", sum);
                    printMatrix(matrix);
                    return;

                }

            } else if (symbol == '-') {
                matrix[rowMatrix][colMatrix] = 'A';


            }


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
}
