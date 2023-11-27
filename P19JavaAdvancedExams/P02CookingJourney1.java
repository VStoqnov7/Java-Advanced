package JavaAdvanced.P19JavaAdvancedExams;

import java.util.Scanner;

public class P02CookingJourney1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] pastryShop = new char[size][size];

        int playerRow = -1;
        int playerCol = -1;
        int moneyCollected = 0;

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            pastryShop[row] = line.toCharArray();
            if (line.contains("S")) {
                playerRow = row;
                playerCol = line.indexOf("S");
            }
        }

        boolean outOfShop = false;
        boolean enoughMoney = false;

        while (!outOfShop && !enoughMoney) {
            String command = scanner.nextLine();

            pastryShop[playerRow][playerCol] = '-';
            playerRow = getNextRow(playerRow, command);
            playerCol = getNextCol(playerCol, command);

            if (isOutOfBounds(playerRow, playerCol, size)) {
                outOfShop = true;
                break;
            }

            char currentPosition = pastryShop[playerRow][playerCol];
            if (Character.isDigit(currentPosition)) {
                int price = Character.getNumericValue(currentPosition);
                moneyCollected += price;
                pastryShop[playerRow][playerCol] = 'S';
                if (moneyCollected >= 50) {
                    enoughMoney = true;
                    break;
                }
            } else if (currentPosition == 'P') {
                pastryShop[playerRow][playerCol] = '-';
                int[] pillar = findPillar(pastryShop);
                playerRow = pillar[0];
                playerCol = pillar[1];
                pastryShop[playerRow][playerCol] = '-';
            }

            pastryShop[playerRow][playerCol] = 'S';
        }

        if (outOfShop) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else if (enoughMoney) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + moneyCollected);
        printMatrix(pastryShop);
    }

    private static int getNextRow(int row, String command) {
        if (command.equals("up")) {
            return row - 1;
        } else if (command.equals("down")) {
            return row + 1;
        }
        return row;
    }

    private static int getNextCol(int col, String command) {
        if (command.equals("left")) {
            return col - 1;
        } else if (command.equals("right")) {
            return col + 1;
        }
        return col;
    }

    private static boolean isOutOfBounds(int row, int col, int size) {
        return row < 0 || row >= size || col < 0 || col >= size;
    }

    private static int[] findPillar(char[][] pastryShop) {
        int[] pillar = new int[2];
        for (int row = 0; row < pastryShop.length; row++) {
            for (int col = 0; col < pastryShop[row].length; col++) {
                if (pastryShop[row][col] == 'P') {
                    pillar[0] = row;
                    pillar[1] = col;
                    break;
                }
            }
        }
        return pillar;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char ch : row) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}