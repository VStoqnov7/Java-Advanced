package JavaAdvanced.P19JavaAdvancedExams;

import java.util.Scanner;

public class P02RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String name = scanner.nextLine();

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {

            String command = scanner.nextLine().replaceAll(" ", "");
            char[] symbols = command.toCharArray();
            matrix[i] = symbols;


        }

        int km = 0;

        int rowDrive = 0;
        int colDrive = 0;

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            int newRowDrive = rowDrive;
            int newColDrive = colDrive;

            switch (command) {
                case "right":
                    newColDrive++;
                    break;
                case "left":
                    newColDrive--;
                    break;
                case "up":
                    newRowDrive--;
                    break;
                case "down":
                    newRowDrive++;
                    break;
            }

            if (isInsideMatrix(newRowDrive, newColDrive, matrix)) {
                char symbol = matrix[newRowDrive][newColDrive];
                if (symbol == 'F') {
                    km += 10;
                    System.out.printf("Racing car %s finished the stage!%n", name);
                    System.out.printf("Distance covered %d km.%n", km);
                    matrix[rowDrive][colDrive] = '.';
                    matrix[newRowDrive][newColDrive] = 'C';
                    printMatrix(matrix);
                    return;
                } else if (symbol == 'T') {
                    km += 30;
                    int[] tunnelExit = findTunnelExit(matrix, newRowDrive, newColDrive);
                    newRowDrive = tunnelExit[0];
                    newColDrive = tunnelExit[1];
                    matrix[rowDrive][colDrive] = '.';
                    matrix[newRowDrive][newColDrive] = 'C';
                    rowDrive = newRowDrive;
                    colDrive = newColDrive;
                } else if (symbol == '.') {
                    km += 10;
                    matrix[rowDrive][colDrive] = '.';
                    matrix[newRowDrive][newColDrive] = 'C';
                    rowDrive = newRowDrive;
                    colDrive = newColDrive;
                }
            }

            command = scanner.nextLine();
        }

        System.out.printf("Racing car %s DNF.%n", name);
        System.out.printf("Distance covered %d km.%n", km);
        printMatrix(matrix);
    }

    private static boolean isInsideMatrix(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int[] findTunnelExit(char[][] matrix, int row, int col) {
        int[] tunnelExit = new int[2];
        boolean found = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'T' && (i != row || j != col)) {
                    tunnelExit[0] = i;
                    tunnelExit[1] = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        return tunnelExit;
    }
}