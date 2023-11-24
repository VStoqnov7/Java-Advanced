package JavaAdvanced.P01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P1BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> stack = new ArrayDeque<>();

        String command = scanner.nextLine();


        while (!command.equals("Home")) {

            if (command.equals("back")) {

                if (stack.size() > 1) {
                    stack.pop();
                    System.out.println(stack.peek());

                } else {
                    System.out.println("no previous URLs");

                }


            } else {
                stack.push(command);
                System.out.println(stack.peek());

            }


            command = scanner.nextLine();
        }



    }
}