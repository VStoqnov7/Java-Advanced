package JavaAdvanced.P19JavaAdvancedExams;

import java.util.*;

public class P01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(queue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(stack::push);

        TreeMap<String,Integer> data = new TreeMap<>();
        data.put("Bread",0);
        data.put("Cake",0);
        data.put("Pastry",0);
        data.put("Fruit Pie",0);

        boolean isValid1 = false;
        boolean isValid2 = false;
        boolean isValid3 = false;
        boolean isValid4 = false;

        while (!queue.isEmpty() && !stack.isEmpty()){

            int liquid = queue.peek();
            int ingredient = stack.peek();
            int result = liquid + ingredient;

            if (result == 25){
                data.put("Bread",data.get("Bread") + 1);
                queue.poll();
                stack.pop();
                isValid1 = true;
            } else if (result == 50) {
                data.put("Cake",data.get("Cake") + 1);
                queue.poll();
                stack.pop();
                isValid2 = true;
            } else if (result == 75) {
                data.put("Pastry",data.get("Pastry") + 1);
                queue.poll();
                stack.pop();
                isValid3 = true;
            } else if (result == 100) {
                data.put("Fruit Pie",data.get("Fruit Pie") + 1);
                queue.poll();
                stack.pop();
                isValid4 = true;
            }else {
                queue.poll();
                stack.pop();
                int sumToAdd = ingredient + 3;
                stack.push(sumToAdd);
            }

        }



        if (isValid1 && isValid2 && isValid3 && isValid4){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }


        if (queue.isEmpty()){
            System.out.println("Liquids left: none");

        }else {
            StringBuilder sb = new StringBuilder();
            sb.append("Liquids left: ");
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
            System.out.println("Ingredients left: none");

        }else {
            StringBuilder sb = new StringBuilder();
            sb.append("Ingredients left: ");
            int times = stack.size();
            for (int i = 0; i < times; i++) {
                sb.append(stack.pop());
                if (i != times - 1){
                    sb.append(", ");
                }

            }
            System.out.println(sb.toString());

        }



        data.entrySet().forEach(entry -> System.out.printf("%s: %d%n",entry.getKey(),entry.getValue()));




    }
}
