package JavaAdvanced.P19JavaAdvancedExams;

import java.util.Scanner;

public class P02MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();

        int rowMatrix = searchRow(matrix);
        int colMatrix = searchCol(matrix);

        int cheese = 0;


        while (!command.equals("end")) {

            switch (command) {
                case "right":
                    if (colMatrix + 1 < matrix[rowMatrix].length) {
                        matrix[rowMatrix][colMatrix] = '-';
                        colMatrix++;
                        char symbol = matrix[rowMatrix][colMatrix];
                        if (symbol == 'B'){
                            matrix[rowMatrix][colMatrix] = '-';
                            colMatrix++;
                        }
                    } else {
                        matrix[rowMatrix][colMatrix] = '-';
                        System.out.println("Where is the mouse?");
                        if (cheese >= 5) {
                            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);

                        } else {
                            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
                        }
                        printMatrix(matrix);

                    return;
                    }
                break;
                case "left":
                    if (colMatrix - 1 >= 0) {
                        matrix[rowMatrix][colMatrix] = '-';
                        colMatrix--;
                        char symbol = matrix[rowMatrix][colMatrix];
                        if (symbol == 'B'){
                            matrix[rowMatrix][colMatrix] = '-';
                            colMatrix--;
                        }
                    } else {
                        matrix[rowMatrix][colMatrix] = '-';
                        System.out.println("Where is the mouse?");
                        if (cheese >= 5) {
                            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);

                        } else {
                            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
                        }
                        printMatrix(matrix);

                    return;
                    }

                break;
                case "up":
                    if (rowMatrix - 1 >= 0) {
                        matrix[rowMatrix][colMatrix] = '-';
                        rowMatrix--;
                        char symbol = matrix[rowMatrix][colMatrix];
                        if (symbol == 'B'){
                            matrix[rowMatrix][colMatrix] = '-';
                            rowMatrix--;
                        }
                    } else {
                        matrix[rowMatrix][colMatrix] = '-';
                        System.out.println("Where is the mouse?");
                        if (cheese >= 5) {
                            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);

                        } else {
                            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
                        }
                        printMatrix(matrix);
                    return;

                    }

                break;
                case "down":
                    if (rowMatrix + 1 < matrix.length) {
                        matrix[rowMatrix][colMatrix] = '-';
                        rowMatrix++;
                        char symbol = matrix[rowMatrix][colMatrix];
                        if (symbol == 'B'){
                            matrix[rowMatrix][colMatrix] = '-';
                            rowMatrix++;
                        }
                    } else {
                        matrix[rowMatrix][colMatrix] = '-';
                        System.out.println("Where is the mouse?");
                        if (cheese >= 5) {
                            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);

                        } else {
                            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
                        }
                        printMatrix(matrix);
                        return;

                    }

                break;
            }

            char symbol = matrix[rowMatrix][colMatrix];
            if (symbol == 'c') {
                cheese++;
                matrix[rowMatrix][colMatrix] = 'M';
            } else if (symbol == '-') {
                matrix[rowMatrix][colMatrix] = 'M';
            }


            command = scanner.nextLine();
        }

        if (cheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);

        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        }
        printMatrix(matrix);


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
                if (symbol == 'M') {
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
                if (symbol == 'M') {
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
}
