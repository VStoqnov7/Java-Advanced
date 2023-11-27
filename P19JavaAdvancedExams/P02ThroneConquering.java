package JavaAdvanced.P19JavaAdvancedExams;

import java.util.Scanner;

public class P02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int energy = Integer.parseInt(scanner.nextLine());

        int n = Integer.parseInt(scanner.nextLine());

        char [][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {

            String command = scanner.nextLine();
            char[] symbols = command.toCharArray();
            matrix[row] = symbols;

        }

        int rowMatrix = -1;
        int colMatrix = -1;


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                if (symbol == 'P'){
                    rowMatrix = row;
                    colMatrix = col;
                }

            }
        }

        while (true){

            String[] command = scanner.nextLine().split("\\s+");

            String move = command[0];
            int enemyRow = Integer.parseInt(command[1]);
            int enemyCol = Integer.parseInt(command[2]);

            if (enemyRow >= 0 && enemyRow < matrix.length && enemyCol >= 0 && enemyCol < matrix[rowMatrix].length){
                matrix[enemyRow][enemyCol] = 'S';

            }

            switch (move){

                case "right":
                    if (colMatrix + 1 < matrix[rowMatrix].length){
                        matrix[rowMatrix][colMatrix] = '-';
                        colMatrix++;

                    }
                    energy -= 1;
                    break;
                case "left":
                    if (colMatrix - 1 >= 0){
                        matrix[rowMatrix][colMatrix] = '-';
                        colMatrix--;

                    }
                    energy -= 1;
                    break;
                case "up":
                    if (rowMatrix - 1 >= 0){
                        matrix[rowMatrix][colMatrix] = '-';
                        rowMatrix--;

                    }
                    energy -= 1;
                    break;
                case "down":
                    if (rowMatrix + 1 < matrix.length){
                        matrix[rowMatrix][colMatrix] = '-';
                        rowMatrix++;

                    }
                    energy -= 1;
                    break;

            }

            char symbol = matrix[rowMatrix][colMatrix];
            if (energy > 0){

                if (symbol == 'S'){
                    energy -= 2;
                    if (energy <= 0){
                        matrix[rowMatrix][colMatrix] = 'X';
                        System.out.printf("Paris died at %d;%d.%n",rowMatrix,colMatrix);
                        printMatrix(matrix);
                        return;
                    }else {
                        matrix[rowMatrix][colMatrix] = 'P';
                    }

                }else if (symbol == 'H'){
                    matrix[rowMatrix][colMatrix] = '-';
                    System.out.print("Paris has successfully abducted Helen! ");
                    System.out.printf("Energy left: %d%n",energy);
                    printMatrix(matrix);
                    return;
                }else {
                    matrix[rowMatrix][colMatrix] = 'P';
                }






            }else {
                if (symbol == 'H'){
                    matrix[rowMatrix][colMatrix] = '-';
                    System.out.print("Paris has successfully abducted Helen! ");
                    System.out.printf("Energy left: %d%n",energy);

                }else {
                    matrix[rowMatrix][colMatrix] = 'X';
                    System.out.printf("Paris died at %d;%d.%n",rowMatrix,colMatrix);
                }
                printMatrix(matrix);
                return;


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
