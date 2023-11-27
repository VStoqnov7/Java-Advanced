package JavaAdvanced.P19JavaAdvancedExams;

import java.util.Scanner;

public class P02Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
         char [][] matrix = new char[n][n];
         String[] command = scanner.nextLine().split(",");
        fillMatrix(matrix,scanner);
        int rowMatrix = searchRow(matrix);
        int colMatrix = searchCol(matrix);

        int countBomb = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B'){
                    countBomb++;
                }
            }
        }

        for (String item : command) {

            switch (item) {
                case "right":
                    if (colMatrix + 1 < matrix[rowMatrix].length) {
                        matrix[rowMatrix][colMatrix] = '+';
                        colMatrix++;
                    }
                    break;
                case "left":
                    if (colMatrix - 1 >= 0) {
                        matrix[rowMatrix][colMatrix] = '+';
                        colMatrix--;
                    }
                    break;
                case "up":
                    if (rowMatrix - 1 >= 0) {
                        matrix[rowMatrix][colMatrix] = '+';
                        rowMatrix--;
                    }
                    break;
                case "down":
                    if (rowMatrix + 1 < matrix.length) {
                        matrix[rowMatrix][colMatrix] = '+';
                        rowMatrix++;
                    }
                    break;
            }


            char symbol = matrix[rowMatrix][colMatrix];
            if (symbol == 'B'){
                countBomb--;
                matrix[rowMatrix][colMatrix] = 's';
                System.out.println("You found a bomb!");
                if (countBomb == 0){
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (symbol == 'e') {
                System.out.printf("END! %d bombs left on the field",countBomb);
                return;
            } else if (symbol == '+') {
                matrix[rowMatrix][colMatrix] = 's';
            }


        }


        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",countBomb,rowMatrix,colMatrix);























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
                if (symbol == 's'){                                                   /////TODO!!!!!!!!!!!!!!!!!!!
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
                if (symbol == 's'){                                                  ///TODO!!!!!!!!!!!!!!!!!!!!
                    return row;
                }
            }
        }
        return -1;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            String command = scanner.nextLine().replaceAll(" ","");
            matrix[row] = command.toCharArray();
        }



    }

//            switch (command){
//                case "right":
//                    if (colMatrix + 1 < matrix[rowMatrix].length){
//                        colMatrix++;
//                    }
//                    break;
//                case "left":
//                    if (colMatrix - 1 >= 0){
//                        colMatrix--;
//                    }
//                    break;
//                case "up":
//                    if (rowMatrix - 1 >= 0){
//                        rowMatrix--;
//                    }
//                    break;
//                case "down":
//                    if (rowMatrix + 1 < matrix.length){
//                        rowMatrix++;
//                    }
//                    break;
//            }
}
