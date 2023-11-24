package JavaAdvanced.P03MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] num = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int row = num[0];
        int col = num[1];



        int [][] matrix = new int[row][col];


        for (int rows = 0; rows < row; rows++) {

            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            matrix[rows] = input;


        }


        int searchNumber = Integer.parseInt(scanner.nextLine());

        boolean isValid = true;


        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                int numberOfPosition = matrix[rows][cols];

                if (searchNumber == numberOfPosition){
                    System.out.println(rows + " " + cols);
                    isValid = false;

                }

            }

        }

        if (isValid){
            System.out.println("not found");

        }

    }
}
