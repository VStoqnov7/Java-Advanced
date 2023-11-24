package JavaAdvanced.P05SetsAndMapsAdvancedLab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());


        Map<String, List<Double>> products = new TreeMap<>();

        for (int i = 0; i < n; i++) {


            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double grades = Double.parseDouble(input[1]);



            if (products.containsKey(name)){

                products.get(name).add(grades);

            }else {

                products.put(name,new ArrayList<>());
                products.get(name).add(grades);


            }


        }

        products.entrySet().forEach(entry -> {

            System.out.print(entry.getKey() + " -> ");

            double average = 0;

            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("%.2f ",entry.getValue().get(i));
                average += entry.getValue().get(i);
            }

            System.out.printf("(avg: %.2f)",average/entry.getValue().size());
            System.out.println();

        });



    }
}
