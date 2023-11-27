package JavaAdvanced.P19JavaAdvancedExams;

import java.util.Objects;
import java.util.Scanner;

public class P02NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        char[][] battlefield = new char[n][n];

        for (int row = 0; row < battlefield.length; row++) {

            char[] symbols = scanner.nextLine().toCharArray();
            battlefield[row] = symbols;

        }

        int rowBattle = 0;
        int colBattle = 0;
        for (int row = 0; row < battlefield.length; row++) {
            for (int col = 0; col < battlefield[row].length; col++) {
                char symbols = battlefield[row][col];
                if (symbols == 'S'){
                    rowBattle = row;
                    colBattle = col;
                }

            }
        }

        String command = scanner.nextLine();

        int damage = 3;
        int cruiser = 3;

        while (true){
            battlefield[rowBattle][colBattle] = '-';

            switch (command){
                case "right":
                    colBattle++;
                    break;
                case "left":
                    colBattle--;
                    break;
                case "up":
                    rowBattle--;
                    break;
                case "down":
                    rowBattle++;
                    break;

            }

            if (rowBattle >= 0 && rowBattle < battlefield.length && colBattle >= 0 && colBattle < battlefield[rowBattle].length){

                char symbol = battlefield[rowBattle][colBattle];
                battlefield[rowBattle][colBattle] = 'S';
                if (symbol == '*') {
                    damage--;
                    if (damage == 0) {
                        System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n",rowBattle,colBattle);
                        printMatrix(battlefield);
                        return;
                    }
                } else if (symbol == 'C') {
                    cruiser--;
                    if (cruiser == 0){
                        System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                        printMatrix(battlefield);
                        return;

                    }

                }


            }


            command = scanner.nextLine();
        }



    }

    private static void printMatrix(char[][] battlefield) {
        for (int row = 0; row < battlefield.length; row++) {
            for (int col = 0; col < battlefield[row].length; col++) {
                System.out.print(battlefield[row][col]);

            }
            System.out.println();

        }
    }

}


//        int n = Integer.parseInt(scanner.nextLine());
//
//        char[][] matrix = new char[n][n];
//
//        int submarineRow = -1;
//        int submarineCol = -1;
//
//        for (int i = 0; i < n; i++) {
//            char[] arr = scanner.nextLine().toCharArray();
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = arr[j];
//                if (matrix[i][j] == 'S') {
//                    submarineRow = i;
//                    submarineCol = j;
//                }
//            }
//        }
//
//        int hits = 0;
//        int cruisersHit = 0;
//        String command = scanner.nextLine();
//
//        while (true){
//            matrix[submarineRow][submarineCol] = '-';
//
//            if (Objects.equals(command, "up")) {
//                submarineRow--;
//            } else if (Objects.equals(command, "down")) {
//                submarineRow++;
//            } else if (Objects.equals(command, "left")) {
//                submarineCol--;
//            } else if (Objects.equals(command, "right")) {
//                submarineCol++;
//            }
//
//            if (matrix[submarineRow][submarineCol] == '-') {
//                matrix[submarineRow][submarineCol] = 'S';
//            } else if (matrix[submarineRow][submarineCol] == '*') {
//                matrix[submarineRow][submarineCol] = 'S';
//                hits++;
//
//                if (hits == 3) {
//                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", submarineRow, submarineCol);
//                    break;
//                }
//            }
//
//            if (matrix[submarineRow][submarineCol] == 'C') {
//                matrix[submarineRow][submarineCol] = 'S';
//                cruisersHit++;
//                if (cruisersHit == 3) {
//                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
//                    break;
//                }
//            }
//            command = scanner.nextLine();
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
//    }
//}
