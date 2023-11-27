package JavaAdvanced.P20Exam;

import java.util.*;
import java.util.stream.Collectors;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(queue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(stack::push);


        List<Integer> data = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        while (!queue.isEmpty() && !stack.isEmpty()) {

            int first = queue.peek();
            int second = stack.peek();

            int result = first * second;

            if (data.contains(result)) {
                int indexToRemove = data.indexOf(result);
                data.remove(indexToRemove);
                queue.poll();
                stack.pop();
            } else {
                queue.poll();
                stack.pop();
                queue.offerLast(first + 1);
                if (second - 1 > 0) {
                    stack.push(second - 1);
                }
            }


        }


        if (data.size() > 0) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");


        } else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");

        }


        if (!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tools: ");
            int times = queue.size();
            for (int i = 0; i < times; i++) {
                sb.append(queue.poll());
                if (i != times - 1) {
                    sb.append(", ");
                }

            }
            System.out.println(sb.toString());

        }


        if (!stack.isEmpty()) {

            StringBuilder sb = new StringBuilder();
            sb.append("Substances: ");
            int times = stack.size();
            for (int i = 0; i < times; i++) {
                sb.append(stack.pop());
                if (i != times - 1) {
                    sb.append(", ");
                }

            }
            System.out.println(sb.toString());

        }


        if (!data.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Challenges: ");
            int size = data.size();
            for (int i = 0; i < size; i++) {
                sb.append(data.get(i));
                if (i != size - 1) {
                    sb.append(", ");
                }

            }
            System.out.println(sb.toString());

        }



    }


}

