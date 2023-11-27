package JavaAdvanced.P19JavaAdvancedExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(stack::push);

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(queue::offer);

        int count = 0;
        int lastBouquets = 0;

        while (!stack.isEmpty() && !queue.isEmpty()){

            int tulips = stack.peek();
            int daffodils = queue.peek();

            int result = tulips + daffodils;

            if (result == 15){
                count++;
                stack.pop();
                queue.poll();
            } else if (result > 15) {
                stack.push(stack.pop() - 2);
            } else if (result < 15) {
                stack.pop();
                queue.poll();
                lastBouquets += result;
            }


        }

        int last = lastBouquets / 15;
        count += last;

        if (count >= 5){

            System.out.printf("You made it! You go to the competition with %d bouquets!%n",count);
        }else {

            System.out.printf("You failed... You need more %d bouquets.%n",5 - count);



        }











    }
}
