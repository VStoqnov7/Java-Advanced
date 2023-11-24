package JavaAdvanced.P03MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int row = numbers[0];
        int col = numbers[1];


        int[][] matrix = new int[row][col];

        for (int rows = 0; rows < row; rows++) {

            int[] num = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

            matrix[rows] = num;

        }

        int sum = 0;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {

                sum += matrix[rows][cols];

            }

        }

        System.out.println(row);
        System.out.println(col);
        System.out.println(sum);

    }
}
