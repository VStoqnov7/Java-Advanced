package JavaAdvanced.P02StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split(" ");

            int command = Integer.parseInt(input[0]);

            switch (command){
                case 1:

                    String text = input[1];

                    stack.push(sb.toString());

                    sb.append(text);


                    break;
                case 2:
                    int indexToRemove = Integer.parseInt(input[1]);
                    String currentText = sb.toString();

                    int newLength = currentText.length() - indexToRemove;


                    stack.push(sb.toString());
                    sb = new StringBuilder(currentText.substring(0,newLength));


                    break;
                case 3:
                    int indexSymbol = Integer.parseInt(input[1]);
                    char symbol = sb.toString().charAt(indexSymbol - 1);


                    System.out.println(symbol);

                    break;
                case 4:
                    sb = new StringBuilder(stack.pop());
                    break;

            }

        }


    }
}
