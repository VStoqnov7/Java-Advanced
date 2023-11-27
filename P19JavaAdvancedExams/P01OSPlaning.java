package JavaAdvanced.P19JavaAdvancedExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class P01OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(stack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(queue::offer);

        int n = Integer.parseInt(scanner.nextLine());


        while (!stack.isEmpty() && !queue.isEmpty()){

            int takes = stack.peek();    /// zadacha
            int thread = queue.peek();    /// nishka


            if (thread >= takes){
                stack.pop();
                queue.poll();
            } else {
                if (takes == n){
                    stack.pop();
                    queue.poll();
                }else {
                    queue.poll();

                }
            }

            if (!stack.contains(n)){
                System.out.printf("Thread with value %d killed task %d%n",thread,n);

                StringBuilder sb = new StringBuilder();
                int size = queue.size();
                sb.append(thread + " ");
                for (int i = 0; i < size; i++) {
                    sb.append(queue.poll() + " ");
                }

                System.out.println(sb.toString());
                return;


            }


        }









    }
}
