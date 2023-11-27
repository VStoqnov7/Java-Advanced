package JavaAdvanced.P20Exam;


import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int nRow = Integer.parseInt(input.split(",")[0]);
        int nCol = Integer.parseInt(input.split(",")[1]);


        char[][] matrix = new char[nRow][nCol];
        fillMatrix(matrix, scanner);
        int rowMatrix = searchRow(matrix);
        int colMatrix = searchCol(matrix);


        int countCheese = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'C') {
                    countCheese++;
                }
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("danger")) {


            switch (command) {
                case "right":
                    if (colMatrix + 1 < matrix[rowMatrix].length) {
                        if (matrix[rowMatrix][colMatrix + 1] != '@') {
                            matrix[rowMatrix][colMatrix] = '*';
                            colMatrix++;
                        }
                    }else {
                        System.out.println("No more cheese for tonight!");
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case "left":
                    if (colMatrix - 1 >= 0) {
                        if (matrix[rowMatrix][colMatrix - 1] != '@') {
                            matrix[rowMatrix][colMatrix] = '*';
                            colMatrix--;
                        }

                    }else {
                        System.out.println("No more cheese for tonight!");
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case "up":
                    if (rowMatrix - 1 >= 0) {
                        if (matrix[rowMatrix - 1][colMatrix] != '@') {
                            matrix[rowMatrix][colMatrix] = '*';
                            rowMatrix--;
                        }

                    }else {
                        System.out.println("No more cheese for tonight!");
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case "down":
                    if (rowMatrix + 1 < matrix.length) {
                        if (matrix[rowMatrix + 1][colMatrix] != '@') {
                            matrix[rowMatrix][colMatrix] = '*';
                            rowMatrix++;

                        }
                    }else {
                        System.out.println("No more cheese for tonight!");
                        printMatrix(matrix);
                        return;
                    }
                    break;
            }


            char symbol = matrix[rowMatrix][colMatrix];
            if (symbol == 'T'){
                System.out.println("Mouse is trapped!");
                matrix[rowMatrix][colMatrix] = 'M';
                printMatrix(matrix);
                return;
            } else if (symbol == 'C') {
                matrix[rowMatrix][colMatrix] = 'M';
                countCheese--;
                if (countCheese == 0){
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    printMatrix(matrix);
                    return;
                }

            } else if (symbol == '*') {
                matrix[rowMatrix][colMatrix] = 'M';

            }

            command = scanner.nextLine();
        }


        System.out.println("Mouse will come back later!");
        printMatrix(matrix);







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
                if (symbol == 'M') {                                                   /////TODO!!!!!!!!!!!!!!!!!!!
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
                if (symbol == 'M') {                                                  ///TODO!!!!!!!!!!!!!!!!!!!!
                    return row;
                }
            }
        }
        return -1;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            String command = scanner.nextLine().replaceAll(" ", "");
            ;
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
