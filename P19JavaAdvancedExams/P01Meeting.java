package JavaAdvanced.P19JavaAdvancedExams;

import java.util.*;

public class P01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(stack::push);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(queue::offer);

        int matches = 0;



        while (!stack.isEmpty() && !queue.isEmpty()){

            if (queue.peek() <= 0){
                queue.poll();
                continue;
            }
            if (queue.peek() % 25 == 0) {
                queue.poll();
                if (!queue.isEmpty()) {
                    queue.poll();
                }
                continue;
            }
            if (stack.peek() <= 0 ){
                stack.pop();
                continue;
            }

            if (stack.peek() % 25 == 0){
                stack.pop();
                if (!stack.isEmpty()){
                    stack.pop();
                }
                continue;

            }





            int manValue = stack.peek();
            int girlValue = queue.peek();


            if (manValue == girlValue){
                stack.pop();
                queue.poll();
                matches++;
            }else {
                queue.poll();
                stack.pop();
                stack.push(manValue - 2);
            }

        }

        if (queue.isEmpty() && stack.isEmpty()){
            System.out.printf("Matches: %d%n",matches);
            System.out.println("Males left: none");
            System.out.println("Females left: none");
            return;

        }

        System.out.printf("Matches: %d%n",matches);
        if (stack.isEmpty()){
            System.out.println("Males left: none");

        }else {
            StringBuilder sb = new StringBuilder();
            int count = stack.size();
            sb.append("Males left: ");
            for (int i = 0; i < count; i++) {
                sb.append(stack.pop());
                if (i < count - 1){
                    sb.append(", ");
                }
            }
            System.out.println(sb.toString());

        }


        if (queue.isEmpty()){
            System.out.println("Females left: none");

        }else {
            StringBuilder sb = new StringBuilder();
            int count = queue.size();
            sb.append("Females left: ");
            for (int i = 0; i < count; i++) {
                sb.append(queue.poll());
                if (i < count - 1){
                    sb.append(", ");
                }
            }
            System.out.println(sb.toString());

        }








    }
}
