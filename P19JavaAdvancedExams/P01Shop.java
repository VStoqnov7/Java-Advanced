package JavaAdvanced.P19JavaAdvancedExams;

import java.util.*;
import java.util.stream.Collectors;

public class P01Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(queue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(stack::push);

        LinkedHashMap<String,Integer> data = new LinkedHashMap<>();
        data.put("Biscuit",0);
        data.put("Cake",0);
        data.put("Pie",0);
        data.put("Pastry",0);

        boolean isValid1 = false;
        boolean isValid2 = false;
        boolean isValid3 = false;
        boolean isValid4 = false;


        while (!queue.isEmpty() && !stack.isEmpty()){


            int liquid = queue.peek();
            int ingredient = stack.peek();
            int result = liquid + ingredient;

            if (result == 25){
                data.put("Biscuit", data.get("Biscuit") + 1);
                queue.poll();
                stack.pop();
                isValid1 = true;
            } else if (result == 50) {
                data.put("Cake", data.get("Cake") + 1);
                queue.poll();
                stack.pop();
                isValid2 = true;
            } else if (result == 75) {
                data.put("Pastry", data.get("Pastry") + 1);
                queue.poll();
                stack.pop();
                isValid3 = true;
            } else if (result == 100) {
                data.put("Pie", data.get("Pie") + 1);
                queue.poll();
                stack.pop();
                isValid4 = true;
            }else {
                queue.poll();
                stack.pop();
                stack.push(ingredient + 3);

            }


        }


        if (isValid1 && isValid2 && isValid3 && isValid4){
            System.out.println("Great! You succeeded in cooking all the food!");

        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");

        }




        if (queue.isEmpty()){
            System.out.println("Liquids left: none");

        }else {

            StringBuilder sb = new StringBuilder();
            sb.append("Liquids left: ");
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                sb.append(String.valueOf(queue.poll()));
                if (i != size - 1){
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
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                sb.append(String.valueOf(stack.pop()));
                if (i != size - 1){
                    sb.append(", ");
                }
            }

            System.out.println(sb.toString());
        }


        data.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
//        System.out.println("Biscuit: " + data.get("Biscuit"));
//        System.out.println("Cake: " + data.get("Cake"));
//        System.out.println("Pie: " + data.get("Pie"));
//        System.out.println("Pastry: " + data.get("Pastry"));




    }
}
