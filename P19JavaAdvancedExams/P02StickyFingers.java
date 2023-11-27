package JavaAdvanced.P19JavaAdvancedExams;

import java.util.Scanner;

public class P02StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String[] move = scanner.nextLine().split(",");

        char[][] matrix = new char[n][n];


        for (int row = 0; row < n; row++) {

            String input = scanner.nextLine().replaceAll(" ", "");
            matrix[row] = input.toCharArray();

        }

        int matrixRow = 0;
        int matrixCol = 0;

        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'D') {
                    matrixRow = row;
                    matrixCol = col;
                }

            }

        }


        for (int i = 0; i < move.length; i++) {

            String input = move[i];

            switch (input) {
                case "right":
                    if (matrixCol + 1 < matrix[matrixRow].length) {
                        matrix[matrixRow][matrixCol] = '+';
                        matrixCol++;

                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");

                    }
                    break;
                case "left":
                    if (matrixCol - 1 >= 0) {
                        matrix[matrixRow][matrixCol] = '+';
                        matrixCol--;

                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "up":
                    if (matrixRow - 1 >= 0) {
                        matrix[matrixRow][matrixCol] = '+';
                        matrixRow--;

                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "down":
                    if (matrixRow + 1 < matrix.length) {
                        matrix[matrixRow][matrixCol] = '+';
                        matrixRow++;

                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");

                    }
                    break;

            }

            char symbol = matrix[matrixRow][matrixCol];

            if (symbol == '$'){
                int result = matrixRow * matrixCol;
                sum += result;
                matrix[matrixRow][matrixCol] = 'D';
                System.out.printf("You successfully stole %d$.%n",result);
            } else if (symbol == 'P') {
                matrix[matrixRow][matrixCol] = '#';
                System.out.printf("You got caught with %d$, and you are going to jail.%n",sum);
                printMatrix(matrix);
                return;


            } else if (symbol == '+') {
                matrix[matrixRow][matrixCol] = 'D';

            }


        }

        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n",sum);
        printMatrix(matrix);


    }

    private static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();

        }
    }
}
