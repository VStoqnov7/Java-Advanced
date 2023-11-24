package JavaAdvanced.P03MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] num1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int row1 = num1[0];
        int col1 = num1[1];

        int[][] firstMatrix = new int[row1][col1];


        for (int row = 0; row < row1; row++) {

            firstMatrix[row] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        }

        int[] num2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int row2 = num2[0];
        int col2 = num2[1];

        int[][] secondMatrix = new int[row2][col2];


        for (int row = 0; row < row2; row++) {

            secondMatrix[row] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        }

        if (row1 != row2 || col1 != col2) {
            System.out.println("not equal");

            return;
        }


        for (int row = 0; row < row1; row++) {
            for (int col = 0; col < col1; col++) {
                int firstNumber = firstMatrix[row][col];
                int secondNumber = secondMatrix[row][col];

                if (firstNumber != secondNumber) {
                    System.out.println("not equal");

                    return;
                }

            }
        }

        System.out.println("equal");


        //        String output = (Arrays.deepEquals(firstMatrix, secondMatrix)) ? "equal" : "not equal";
        //        System.out.println(output);


    }

}
