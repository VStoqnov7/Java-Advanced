package JavaAdvanced.P19JavaAdvancedExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(queue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(stack::push);


        int count = 0;

        while (!queue.isEmpty() && !stack.isEmpty()){

            int first = queue.peek();
            int second = stack.peek();

            int result = first + second;

            if (result % 2 == 0){
                count += result;
                queue.poll();
                stack.pop();
            }else {
                stack.pop();
                queue.offerLast(second);

            }


        }


        if (queue.isEmpty()){
            System.out.println("First magic box is empty.");
        }

        if (stack.isEmpty()){
            System.out.println("Second magic box is empty.");
        }

        if (count >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d%n",count);

        }else {
            System.out.printf("Poor prey... Value: %d%n",count);
        }







    }
}
