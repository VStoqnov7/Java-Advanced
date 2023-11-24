package JavaAdvanced.P04MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {

            int[] num = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[row] = num;

        }


        int firstDiagonal = 0;
        int secondDiagonal = 0;


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                int number = matrix[row][col];

                if (row == col){
                    firstDiagonal += number;
                }


                if (col == matrix.length - 1 - row){
                    secondDiagonal += number;



                }



            }

        }




        System.out.println(Math.abs(firstDiagonal - secondDiagonal));




    }
}
