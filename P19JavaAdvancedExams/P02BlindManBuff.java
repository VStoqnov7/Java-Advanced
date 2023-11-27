package JavaAdvanced.P19JavaAdvancedExams;

import java.util.Scanner;

public class P02BlindManBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] command = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(command[0]);
        int cols = Integer.parseInt(command[1]);

        char [][] matrix = new char[rows][cols];

        int rowMatrix = -1;
        int colMatrix = -1;

        for (int row = 0; row < matrix.length; row++) {
            String input = scanner.nextLine().replaceAll(" ","");
            char[] symbols = input.toCharArray();
            matrix[row] = symbols;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                if (symbol == 'B'){
                    rowMatrix = row;
                    colMatrix = col;
                    break;
                }
            }
        }

        String move = scanner.nextLine();

        int touchedOpponents = 0;
        int movesMade = 0;

        while (!move.equals("Finish")){

            switch (move){
//                - - - O - P - O
//                - P - O O - - -
//                - - - - - - O -
//                - P B - O - - O
//                - - - O - - - -

                case "left":
                    if (colMatrix - 1 >= 0){
                        if (matrix[rowMatrix][colMatrix - 1] == '-'){
                            matrix[rowMatrix][colMatrix] = '-';
                            colMatrix--;
                            movesMade++;
                            matrix[rowMatrix][colMatrix] = 'B';
                        } else if (matrix[rowMatrix][colMatrix - 1] == 'P') {
                            matrix[rowMatrix][colMatrix] = '-';
                            colMatrix--;
                            movesMade++;
                            touchedOpponents++;
                            matrix[rowMatrix][colMatrix] = 'B';
                        }
                    }
                    break;
                case "right":
                    if (colMatrix + 1 < matrix[rowMatrix].length){

                        if (matrix[rowMatrix][colMatrix + 1] == '-'){
                            matrix[rowMatrix][colMatrix] = '-';
                            colMatrix++;
                            movesMade++;
                            matrix[rowMatrix][colMatrix] = 'B';
                        } else if (matrix[rowMatrix][colMatrix + 1] == 'P') {
                            matrix[rowMatrix][colMatrix] = '-';
                            colMatrix++;
                            movesMade++;
                            touchedOpponents++;
                            matrix[rowMatrix][colMatrix] = 'B';
                        }
                    }
                    break;
                case "up":
                    if (rowMatrix - 1 >= 0){
                        if (matrix[rowMatrix - 1][colMatrix] == '-'){
                            matrix[rowMatrix][colMatrix] = '-';
                            rowMatrix--;
                            movesMade++;
                            matrix[rowMatrix][colMatrix] = 'B';
                        } else if (matrix[rowMatrix - 1][colMatrix] == 'P') {
                            matrix[rowMatrix][colMatrix] = '-';
                            rowMatrix--;
                            movesMade++;
                            touchedOpponents++;
                            matrix[rowMatrix][colMatrix] = 'B';
                        }
                    }
                    break;
                case "down":
                    if (rowMatrix + 1 < matrix[rowMatrix].length){
                        if (matrix[rowMatrix + 1][colMatrix ] == '-'){
                            matrix[rowMatrix][colMatrix] = '-';
                            rowMatrix++;
                            movesMade++;
                            matrix[rowMatrix][colMatrix] = 'B';
                        } else if (matrix[rowMatrix + 1][colMatrix] == 'P') {
                            matrix[rowMatrix][colMatrix] = '-';
                            rowMatrix++;
                            movesMade++;
                            touchedOpponents++;
                            matrix[rowMatrix][colMatrix] = 'B';
                        }
                    }
                    break;
            }
            if (touchedOpponents == 3){
                break;
            }

            move = scanner.nextLine();
        }



        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d",touchedOpponents,movesMade);














    }
}
