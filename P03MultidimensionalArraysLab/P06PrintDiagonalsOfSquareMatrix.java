package JavaAdvanced.P03MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];


        for (int row = 0; row < matrix.length; row++) {

            int[] num = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            matrix[row] = num;

        }


//        for (int row = 0; row < n; row++) {
//            System.out.print(matrix[row][row] + " ");
//
//        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (row == col) {
                    System.out.print(matrix[row][col] + " ");

                }

            }

        }

        System.out.println();


        for (int col = 0; col < n; col++) {
            System.out.print(matrix[n - 1 - col] [col] + " ");



        }


//        for (int i = 0; i < n; i++) {
//            System.out.print(matrix[i][n - i - 1] + " ");
//
//        }


    }
}
