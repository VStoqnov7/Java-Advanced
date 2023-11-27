package JavaAdvanced.P19JavaAdvancedExams;

import java.util.*;


public class P01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> milligramsSequence = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinksSequence = new ArrayDeque<>();
        int maximumCaffeineInput = 300;
        int totalCaffeineInput = 0;
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(milligramsSequence::push);
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(energyDrinksSequence::offer);

        while (!milligramsSequence.isEmpty() && !energyDrinksSequence.isEmpty()) {
            int currentMilligrams = milligramsSequence.peek();
            int currentEnergyDrink = energyDrinksSequence.peek();
            int currentCalculatedAmount = currentMilligrams * currentEnergyDrink;
            if (currentCalculatedAmount + totalCaffeineInput <= maximumCaffeineInput) {
                totalCaffeineInput += currentCalculatedAmount;
                milligramsSequence.pop();
                energyDrinksSequence.poll();
            } else {
                milligramsSequence.pop();
                energyDrinksSequence.poll();
                energyDrinksSequence.offer(currentEnergyDrink);
                if (totalCaffeineInput >= 30) {
                    totalCaffeineInput -= 30;
                }
            }
        }
        if (!energyDrinksSequence.isEmpty()) {
            System.out.printf("Drinks left: %s%n", String.join(", ", Arrays.asList(energyDrinksSequence.toString().
                    substring(1, energyDrinksSequence.toString().length() - 1))));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %s mg caffeine.", totalCaffeineInput);
    }
}



//        int[] command1 = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
//        int[] command2 = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
//
//        Stack<Integer> caffeine = new Stack<>();
//        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();
//
//
//        for (Integer item : command1) {
//            caffeine.push(item);
//
//        }
//        for (Integer item : command2) {
//            energyDrinks.offer(item);
//        }
//
//        int stamatCaffeine = 0;
//        int maxCaffeine = 300;
//
//
//
//        while (true){
//
//            if (caffeine.isEmpty() || energyDrinks.isEmpty()){
//                break;
//            }
//
//            int currentCaffeine = caffeine.peek();
//            int currentEnergyDrinks = energyDrinks.peek();
//
//            int result = currentCaffeine * currentEnergyDrinks;
//
//            if (result  + stamatCaffeine <= maxCaffeine){
//                caffeine.pop();
//                energyDrinks.poll();
//                stamatCaffeine += result;
//
//
//            }else {
//                caffeine.pop();
//                energyDrinks.poll();
//                energyDrinks.offer(currentEnergyDrinks);
//                if (stamatCaffeine - 30 >= 0){
//                stamatCaffeine -= 30;
//
//                }
//            }
//
//
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        if (!energyDrinks.isEmpty()){
//            int size = energyDrinks.size();
//            sb.append("Drinks left: ");
//            for (Integer item : energyDrinks) {
//                sb.append(item);
//                size--;
//                if (size > 0){
//                    sb.append(", ");
//                }
//            }
//
//            System.out.println(sb.toString());
//
//        }else {
//            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
//
//        }
//
//
//        System.out.printf("Stamat is going to sleep with %d mg caffeine.",stamatCaffeine);
//
//    }
//}
