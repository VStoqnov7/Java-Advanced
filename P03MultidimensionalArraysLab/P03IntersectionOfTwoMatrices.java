package JavaAdvanced.P03MultidimensionalArraysLab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row1 = Integer.parseInt(scanner.nextLine());
        int col1 = Integer.parseInt(scanner.nextLine());

        char [][] firstMatrix = new char[row1][col1];


        for (int row = 0; row < row1; row++) {


            char[] input = scanner.nextLine().toCharArray();

            firstMatrix[row] = input;

        }

        char [][] secondMatrix = new char[row1][col1];

        for (int row = 0; row < row1; row++) {

            char[] input = scanner.nextLine().toCharArray();

            secondMatrix[row] = input;

        }

        for (int row = 0; row < firstMatrix.length; row++) {

            for (int col = 0; col < firstMatrix[row].length; col++) {

                char numberOfFirstMatrix = firstMatrix[row][col];
                char numberOfSecondMatrix = secondMatrix[row][col];

                if (numberOfFirstMatrix != numberOfSecondMatrix){
                    System.out.print("*");
                }else {
                    System.out.print(numberOfFirstMatrix);

                }


            }
            System.out.println();


        }

    }
}
