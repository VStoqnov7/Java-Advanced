package JavaAdvanced.P04MultidimensionalArraysExercises;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        char startLetter = 'a';
        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cols ; col++) {
                //(a -> b -> c)(startLetter + 1)()
                String palindrome = "" + startLetter + (char)(startLetter + col) + startLetter;
                matrix[row][col] = palindrome;
            }
            startLetter = (char)(startLetter + 1);
        }

        printMatrix(matrix, rows, cols);
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

//
//        String[] input = scanner.nextLine().split(" ");
//
//        int rows = Integer.parseInt(input[0]);
//        int cols = Integer.parseInt(input[1]);
//
//
//        String [][] matrix = new String[rows][cols];
//
//        char symbolStart = 'a';
//
//
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                matrix[row][col] = "" + (char)(symbolStart + row) + (char)(symbolStart + col + row) + (char)(symbolStart + row);
//
//            }
//
//        }
//
//
//        printMatrix(matrix);
//
//
//    }
//
//    private static void printMatrix(String[][] matrix) {
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                System.out.print(matrix[row][col] + " ");
//            }
//            System.out.println(); //свали курсора на следващия ред
//        }
//    }
//}
