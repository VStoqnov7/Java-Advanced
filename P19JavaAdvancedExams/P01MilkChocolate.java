package JavaAdvanced.P19JavaAdvancedExams;

import java.util.*;

public class P01MilkChocolate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Double> queue = new ArrayDeque<>();
        Stack<Double> stack = new Stack<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).forEach(queue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).forEach(stack::push);

        TreeMap<String,Integer> data = new TreeMap<>();
        data.put("Milk Chocolate",0);
        data.put("Dark Chocolate",0);
        data.put("Baking Chocolate",0);

        boolean isValidMilkChocolate = false;
        boolean isValidDarkChocolate = false;
        boolean isValidBakingChocolate = false;
        boolean allIsValid = false;

        while (!queue.isEmpty() && !stack.isEmpty()){

            double currentMilk = queue.peek();
            double currentCacao = stack.peek();

            double result = currentCacao / (currentMilk + currentCacao);

            if (result == 0.3){
                data.put("Milk Chocolate",data.get("Milk Chocolate") + 1);
                queue.poll();
                stack.pop();
                isValidMilkChocolate = true;
            } else if (result == 0.5) {
                data.put("Dark Chocolate",data.get("Dark Chocolate") + 1);
                queue.poll();
                stack.pop();
                isValidDarkChocolate = true;
            } else if (result == 1) {
                data.put("Baking Chocolate",data.get("Baking Chocolate") + 1);
                queue.poll();
                stack.pop();
                isValidBakingChocolate = true;
            }else {
                stack.pop();
                queue.poll();
                queue.addLast(currentMilk + 10);
            }



            if (isValidMilkChocolate && isValidDarkChocolate && isValidBakingChocolate){
                allIsValid = true;
            }

        }


        if (allIsValid){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");

        }else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");

        }

        data.entrySet().stream().filter(entry -> entry.getValue() > 0).forEach(entry -> System.out.printf("# %s --> %d%n",entry.getKey(),entry.getValue()));




    }
}
