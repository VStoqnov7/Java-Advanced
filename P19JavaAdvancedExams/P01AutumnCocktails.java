package JavaAdvanced.P19JavaAdvancedExams;

import java.util.*;

public class P01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(queue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(stack::push);

        TreeMap<String,Integer> data = new TreeMap<>();
        data.put("Pear Sour",0);
        data.put("The Harvest",0);
        data.put("Apple Hinny",0);
        data.put("High Fashion",0);

        boolean isValid1 = false;
        boolean isValid2 = false;
        boolean isValid3 = false;
        boolean isValid4 = false;


        while (!queue.isEmpty() && !stack.isEmpty()){


            int ingredients = queue.peek();
            int freshness = stack.peek();
            int result = ingredients * freshness;

            if (queue.peek() == 0){
                queue.poll();
                continue;
            }

            if (result == 150){
                data.put("Pear Sour",data.get("Pear Sour") + 1);
                queue.poll();
                stack.pop();
                isValid1 = true;
            } else if (result == 250) {
                data.put("The Harvest",data.get("The Harvest") + 1);
                queue.poll();
                stack.pop();
                isValid2 = true;
            } else if (result == 300) {
                data.put("Apple Hinny",data.get("Apple Hinny") + 1);
                queue.poll();
                stack.pop();
                isValid3 = true;
            } else if (result == 400) {
                data.put("High Fashion",data.get("High Fashion") + 1);
                queue.poll();
                isValid4 = true;
                stack.pop();
            } else {
                stack.pop();
                queue.poll();
                queue.addLast(ingredients + 5);
            }


        }


        if (isValid1 && isValid2 && isValid3 && isValid4){

            System.out.println("It's party time! The cocktails are ready!");


        }else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");

        }

        if (!queue.isEmpty()){
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                sum += queue.poll();
            }

            System.out.printf("Ingredients left: %d%n",sum);

        }


        data.entrySet().stream().filter(entry -> entry.getValue() > 0).forEach(entry -> System.out.printf(" # %s --> %d%n",entry.getKey(),entry.getValue()));









    }
}
