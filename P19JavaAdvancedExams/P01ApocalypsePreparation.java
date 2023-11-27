package JavaAdvanced.P19JavaAdvancedExams;

import java.util.*;

public class P01ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] command1 = scanner.nextLine().split("\\s+");
        String[] command2 = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> queueTextile = new ArrayDeque<>();
        Stack<Integer> stackMedicament = new Stack<>();

        TreeMap<String, Integer> data = new TreeMap<>();
        data.put("Patch", 0);
        data.put("Bandage", 0);
        data.put("MedKit", 0);


        Arrays.stream(command1).mapToInt(Integer::parseInt).forEach(queueTextile::offer);
        Arrays.stream(command2).mapToInt(Integer::parseInt).forEach(stackMedicament::push);


        while (true) {

            int textile = queueTextile.peek();
            int medicament = stackMedicament.peek();

            int result = textile + medicament;

            if (result == 30) {
                data.put("Patch", data.get("Patch") + 1);
                queueTextile.poll();
                stackMedicament.pop();
            } else if (result == 40) {
                data.put("Bandage", data.get("Bandage") + 1);
                queueTextile.poll();
                stackMedicament.pop();
            } else if (result >= 100) {
                data.put("MedKit", data.get("MedKit") + 1);
                stackMedicament.pop();
                queueTextile.poll();
                if (result - 100 > 0) {
                    int sumToAdd = result - 100;
                    int current = stackMedicament.pop();
                    stackMedicament.push(current + sumToAdd);

                }

            } else {
                queueTextile.poll();
                int current = stackMedicament.pop() + 10;
                stackMedicament.push(current);
            }

            if (stackMedicament.isEmpty() || queueTextile.isEmpty()) {
                break;
            }

        }
        StringBuilder sb = new StringBuilder();
        boolean isValid = true;

        if (queueTextile.isEmpty() && stackMedicament.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
            isValid = false;

        } else if (queueTextile.isEmpty()) {
            int numberOfStack = stackMedicament.size();
            for (int i = 1; i <= numberOfStack; i++) {
                if (i == 1){
                    sb.append("Medicaments left: ");
                }
                sb.append(stackMedicament.pop());
                if (i != numberOfStack) {
                    sb.append(", ");
                }

            }
            System.out.println("Textiles are empty.");


        } else if (stackMedicament.isEmpty()) {
            int numberOfQueue = queueTextile.size();
            for (int i = 1; i <= numberOfQueue; i++) {
                if (i == 1){
                    sb.append("Textiles left: ");

                }
                sb.append(queueTextile.pop());
                if (i != numberOfQueue) {
                    sb.append(", ");
                }
            }
            System.out.println("Medicaments are empty.");
        }

        data.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> {
                    if (entry.getValue() != 0) System.out.println(entry.getKey() + " - " + entry.getValue());
                });

        if (isValid) {
            System.out.println(sb.toString());
        }




    }
}