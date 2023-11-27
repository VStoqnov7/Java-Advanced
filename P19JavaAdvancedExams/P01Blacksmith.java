package JavaAdvanced.P19JavaAdvancedExams;

import java.util.*;

public class P01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(queue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(stack::push);

        TreeMap<String,Integer> data = new TreeMap<>();
        data.put("Gladius",0);
        data.put("Shamshir",0);
        data.put("Katana",0);
        data.put("Sabre",0);

        boolean isValid = false;


        while (!queue.isEmpty() && !stack.isEmpty()){

            int currentQueue = queue.peek();
            int currentStack = stack.peek();

            int result = currentQueue + currentStack;

            if (result == 70){
                data.put("Gladius",data.get("Gladius") + 1);
                queue.poll();
                stack.pop();
                isValid = true;
            } else if (result == 80) {
                data.put("Shamshir",data.get("Shamshir") + 1);
                queue.poll();
                stack.pop();
                isValid = true;
            } else if (result == 90) {
                data.put("Katana",data.get("Katana") + 1);
                queue.poll();
                stack.pop();
                isValid = true;
            } else if (result == 110) {
                data.put("Sabre",data.get("Sabre") + 1);
                queue.poll();
                stack.pop();
                isValid = true;
            }else {
                queue.poll();
                stack.pop();
                int sumToAdd = currentStack + 5;
                stack.push(sumToAdd);
            }


        }


        if (isValid){
            int sum = data.values().stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            System.out.printf("You have forged %d swords.%n",sum);

        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }


        if (queue.isEmpty()){
            System.out.println("Steel left: none");

        }else {
            StringBuilder sb = new StringBuilder();
            sb.append("Steel left: ");
            int times = queue.size();
            for (int i = 0; i < times; i++) {
                sb.append(queue.poll());
                if (i != times - 1){
                    sb.append(", ");
                }

            }
            System.out.println(sb.toString());

        }

        if (stack.isEmpty()){
            System.out.println("Carbon left: none");

        }else {
            StringBuilder sb = new StringBuilder();
            sb.append("Carbon left: ");
            int times = stack.size();
            for (int i = 0; i < times; i++) {
                sb.append(stack.pop());
                if (i != times - 1){
                    sb.append(", ");
                }

            }
            System.out.println(sb.toString());
        }

        data.entrySet().stream().filter(entry -> entry.getValue() > 0).forEach(entry -> System.out.printf("%s: %d%n",entry.getKey(),entry.getValue()));






    }
}
