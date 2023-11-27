package JavaAdvanced.P19JavaAdvancedExams;

import java.util.Scanner;

public class P02TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String[] leftRight = scanner.nextLine().split(", ");

        char[][] matrix = new char[n][n];

        int hazelnut = 0;


        for (int i = 0; i < n; i++) {
            char[] input = scanner.nextLine().toCharArray();

            matrix[i] = input;

        }

//•         s - представлява позицията на катерицата.
//•         h – представлява лешник.
//•         * – звездичката представлява празна позиция.
//•         t – представлява капан.

        int rowToSetSquirrel = 0;
        int colToSetSquirrel = 0;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {

                if (matrix[rows][cols] == 's') {
                    rowToSetSquirrel = rows;
                    colToSetSquirrel = cols;
                    break;

                }

            }
        }

        for (String move : leftRight) {

            switch (move) {
                case "left":
                    colToSetSquirrel--;
                    break;
                case "right":
                    colToSetSquirrel++;
                    break;
                case "up":
                    rowToSetSquirrel--;
                    break;
                case "down":
                    rowToSetSquirrel++;
                    break;

            }

            if (rowToSetSquirrel >= 0 && rowToSetSquirrel < matrix.length && colToSetSquirrel >= 0 && colToSetSquirrel < matrix[rowToSetSquirrel].length) {

                char symbol = matrix[rowToSetSquirrel][colToSetSquirrel];
                matrix[rowToSetSquirrel][colToSetSquirrel] = '*';
                if (symbol == 'h') {
                    hazelnut++;
                    if (hazelnut == 3){
                        System.out.println("Good job! You have collected all hazelnuts!");
                        System.out.println("Hazelnuts collected: " + hazelnut);
                        return;
                    }
                } else if (symbol == 't') {
                    System.out.println("Unfortunately, the squirrel stepped on a trap...");
                    System.out.println("Hazelnuts collected: " + hazelnut);
                    return;
                }
            } else {
                System.out.println("The squirrel is out of the field.");
                System.out.println("Hazelnuts collected: " + hazelnut);
                return;
            }




        }

        System.out.println("There are more hazelnuts to collect.");
        System.out.println("Hazelnuts collected: " + hazelnut);



    }

}
