package JavaAdvanced.P19JavaAdvancedExams;

import java.util.*;

public class P01RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] programmersString = scanner.nextLine().split("\\s+");
        String[] tasksString = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        Map<String, Integer> givenDucks = new LinkedHashMap<>();
        givenDucks.put("Darth Vader Ducky", 0);
        givenDucks.put("Thor Ducky", 0);
        givenDucks.put("Big Blue Rubber Ducky", 0);
        givenDucks.put("Small Yellow Rubber Ducky", 0);

        Arrays.stream(programmersString)
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);

        Arrays.stream(tasksString)
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        while (!queue.isEmpty() && !stack.isEmpty()){
            int currentProgrammer = queue.peek();
            int currentTask = stack.peek();
            int timeTaken = currentProgrammer * currentTask;

            if (timeTaken > 0 && timeTaken <= 60){
                givenDucks.put("Darth Vader Ducky", givenDucks.get("Darth Vader Ducky") + 1);
                queue.poll();
                stack.pop();
            }else if(timeTaken > 60 && timeTaken <= 120){
                givenDucks.put("Thor Ducky", givenDucks.get("Thor Ducky") + 1);
                queue.poll();
                stack.pop();
            }else if(timeTaken > 120 && timeTaken <= 180){
                givenDucks.put("Big Blue Rubber Ducky", givenDucks.get("Big Blue Rubber Ducky") + 1);
                queue.poll();
                stack.pop();
            }else if(timeTaken > 180 && timeTaken <= 240){
                givenDucks.put("Small Yellow Rubber Ducky", givenDucks.get("Small Yellow Rubber Ducky") + 1);
                queue.poll();
                stack.pop();
            }else{
                queue.offerLast(queue.poll());
                stack.push(stack.pop() - 2);
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded: ");

        for (Map.Entry<String, Integer> entry : givenDucks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}


//
//
//        int[] command1 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        int[] command2 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//
//        int darthVaderDucky = 0;
//        int thorDucky = 0;
//        int bigBlueRubberDucky = 0;
//        int smallYellowRubberDucky = 0;
//
//
//        Queue<Integer> queue = new ArrayDeque<>();
//        Stack<Integer> stack = new Stack<>();
//
//
//        for (int i = 0; i < command1.length ; i++) {
//            queue.offer(command1[i]);
//
//        }
//
//        for (int i = 0; i < command2.length ; i++) {
//            stack.push(command2[i]);
//
//        }
//
//        while (!queue.isEmpty() && !stack.isEmpty()){
//            int numQueue = queue.peek();
//            int numStack = stack.peek();
//
//            int result = numQueue * numStack;
//
//
//            if (result > 0 && result <= 60){
//                darthVaderDucky++;
//                queue.poll();
//                stack.pop();
//
//            } else if (result > 60 && result <= 120) {
//                thorDucky++;
//                queue.poll();
//                stack.pop();
//
//            } else if (result > 120 && result <= 180) {
//                bigBlueRubberDucky++;
//                queue.poll();
//                stack.pop();
//
//            } else if (result > 180 && result <= 240) {
//                smallYellowRubberDucky++;
//                queue.poll();
//                stack.pop();
//            }else {
//                int num = numStack - 2;
//
//                stack.pop();
//                stack.push(num);
//
//                queue.poll();
//                queue.offer(numQueue);
//
//
//
//            }
//        }
//
//        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
//        System.out.println("Darth Vader Ducky: " + darthVaderDucky);
//        System.out.println("Thor Ducky: " + thorDucky);
//        System.out.println("Big Blue Rubber Ducky: " + bigBlueRubberDucky);
//        System.out.println("Small Yellow Rubber Ducky: " + smallYellowRubberDucky);
//
//
//
//
//    }
//}
