package JavaAdvanced.P19JavaAdvancedExams;

import java.util.*;
import java.util.stream.Collectors;

public class P01ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> peaks = new ArrayDeque<>(Arrays.asList("Vihren", "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza"));
        HashMap<String, Integer> peakAndLevel = new LinkedHashMap<>(Map.of("Vihren", 80,
                "Kutelo", 90,
                "Banski Suhodol", 100,
                "Polezhan", 60,
                "Kamenitza", 70));

        List conqueredPeaks = new ArrayList<String>();
        ArrayDeque<Integer> foodPortions = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> staminaQuan = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        while (!peakAndLevel.isEmpty() && !foodPortions.isEmpty() && !staminaQuan.isEmpty()) {
            String currentPeakName = peaks.getFirst();
            if (foodPortions.getLast() + staminaQuan.getFirst() >= peakAndLevel.get(currentPeakName)) {
                conqueredPeaks.add(currentPeakName);
                staminaQuan.removeFirst();
                foodPortions.removeLast();
                peakAndLevel.remove(currentPeakName);
                peaks.remove(currentPeakName);
            } else {
                staminaQuan.removeFirst();
                foodPortions.removeLast();
            }
        }

        if (peakAndLevel.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!conqueredPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            System.out.println(conqueredPeaks.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator())));
        }
    }
}


//
////        Vihren	         80
////        Kutelo	         90
////        Banski Suhodol	 100
////        Polezhan	         60
////        Kamenitza	         70
//
//
//        String[] command = scanner.nextLine().split(", ");
//        String[] commandStamina = scanner.nextLine().split(", ");
//
//        Stack<Integer> stack = new Stack<>();
//        ArrayDeque<Integer> queue = new ArrayDeque<>();
//
//        Arrays.stream(command)
//                .mapToInt(Integer::parseInt)
//                .forEach(stack::push);
//        Arrays.stream(commandStamina)
//                .mapToInt(Integer::parseInt)
//                .forEach(queue::offer);
//
//        LinkedHashMap<String, Integer> data = new LinkedHashMap<>();
//        data.put("Vihren", 80);
//        data.put("Kutelo", 90);
//        data.put("Banski Suhodol", 100);
//        data.put("Polezhan", 60);
//        data.put("Kamenitza", 70);
//
//
//        List<String> save = new ArrayList<>();
//
//        int days = 7;
//
//
//        while (days >= 0) {
//
//            if (data.isEmpty()){
//                System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
//                System.out.println("Conquered peaks:");
//                save.forEach(System.out::println);
//                return;
//
//            }
//
//
//            if (!stack.isEmpty() && !queue.isEmpty()) {
//                int firstFood = stack.pop();
//                int secondFood = queue.poll();
//
//                int result = firstFood + secondFood;
//
//
//                for (Map.Entry<String, Integer> entry : data.entrySet()) {
//
//                    if (result >= entry.getValue()) {
//                        save.add(entry.getKey());
//                        data.remove(entry.getKey());
//
//                    }
//                    break;
//                }
//
//
//            } else {
//                break;
//            }
//
//
//            days--;
//
//
//
//        }
//            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
//
//        if (!save.isEmpty()){
//            System.out.println("Conquered peaks:");
//            save.forEach(System.out::println);
//
//        }
//
//
//
//    }
//}
