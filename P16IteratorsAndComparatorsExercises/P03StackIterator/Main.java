package JavaAdvanced.P16IteratorsAndComparatorsExercises.P03StackIterator;

import java.util.NoSuchElementException;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Stack<Integer> stack = new Stack<>();

            String input = scanner.nextLine();
            while (!input.equals("END")) {
                String[] tokens = input.split(" ");
                String command = tokens[0];

                switch (command) {
                    case "Push":
                        for (int i = 1; i < tokens.length; i++) {
                            int element = Integer.parseInt(tokens[i].replace(",", ""));
                            stack.push(element);
                        }
                        break;
                    case "Pop":
                        try {
                            stack.pop();
                        } catch (NoSuchElementException e) {
                            System.out.println("No elements");
                        }
                        break;
                }

                input = scanner.nextLine();
            }

            for (int i = 0; i < 2; i++) {
                for (int element : stack) {
                    System.out.println(element);
                }
            }
        }
    }