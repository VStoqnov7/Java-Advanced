package JavaAdvanced.P19JavaAdvancedExams;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //------b-
        //--------
        //--------
        //--------
        //--------
        //-w------
        //--------
        //--------

        LinkedHashMap<Integer, LinkedHashMap<Integer, String>> data = new LinkedHashMap<>();
        fillData(data);

        char[][] matrix = new char[8][8];

        for (int row = 0; row < 8; row++) {
            String input = scanner.nextLine();
            matrix[row] = input.toCharArray();
        }


        int rowW = -1;
        int colW = -1;

        int rowB = -1;
        int colB = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                if (symbol == 'w') {
                    rowW = row;
                    colW = col;
                } else if (symbol == 'b') {
                    rowB = row;
                    colB = col;
                }
            }
        }


        while (rowW != 0 && rowB < 7) {

            matrix[rowW][colW] = '-';
            if (colW - 1 >= 0 ) {
                if (matrix[rowW - 1][colW - 1] == 'b') {
                    String position = data.get(rowW - 1).get(colW - 1);
                    System.out.printf("Game over! White capture on %s.%n", position);
                    matrix[rowW - 1][colW - 1] = 'w';
                    return;

                }

            }

            if (colW + 1 < 8) {

                if (matrix[rowW - 1][colW + 1] == 'b') {
                    String position = data.get(rowW - 1).get(colW + 1);
                    System.out.printf("Game over! White capture on %s.%n", position);
                    matrix[rowW - 1][colW + 1] = 'w';
                    return;
                }

            }
            rowW--;
            matrix[rowW][colW] = 'w';


            matrix[rowB][colB] = '-';
            if (colB - 1 >= 0) {
                if (matrix[rowB + 1][colB - 1] == 'w') {
                    String position = data.get(rowB + 1).get(colB - 1);
                    System.out.printf("Game over! Black capture on %s.%n", position);
                    matrix[rowB + 1][colB - 1] = 'b';
                    return;
                }

            }

            if (colB + 1 < 8) {

                if (matrix[rowB + 1][colB + 1] == 'w') {
                    String position = data.get(rowB + 1).get(colB + 1);
                    System.out.printf("Game over! Black capture on %s.%n", position);
                    matrix[rowB + 1][colB + 1] = 'b';
                    return;
                }


            }


            rowB++;
            matrix[rowB][colB] = 'b';


        }

        if (rowW == 0) {
            String position = data.get(rowW).get(colW);
            System.out.printf("Game over! White pawn is promoted to a queen at %s.", position);
            matrix[rowW][colW] = 'w';


        } else if (rowB == 7) {
            String position = data.get(rowB).get(colB);
            System.out.printf("Game over! Black pawn is promoted to a queen at %s.", position);
            matrix[rowW][colW] = 'w';

        }


    }

    private static void fillData(LinkedHashMap<Integer, LinkedHashMap<Integer, String>> data) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                char symbolLetter = (char) (97 + col);
                char symbolNumber = (char) (56 - row);
                StringBuilder sb = new StringBuilder();
                sb.append((char) symbolLetter);
                sb.append((char) symbolNumber);
                data.putIfAbsent(row, new LinkedHashMap<>());
                data.get(row).putIfAbsent(col, sb.toString());

            }

        }
    }

}
