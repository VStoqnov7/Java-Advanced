package JavaAdvanced.P05SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> products = new TreeMap<>();


        for (int i = 0; i < n; i++) {

            String name = scanner.nextLine();
            List<Double> scoreList = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

            if (products.containsKey(name)) {
                for (int j = 0; j < scoreList.size(); j++) {
                    double score = scoreList.get(j);
                    products.get(name).add(score);

                }

            } else {
                products.put(name, new ArrayList<>());

                for (int j = 0; j < scoreList.size(); j++) {
                    double score = scoreList.get(j);
                    products.get(name).add(score);

                }

            }


        }


        products.entrySet().forEach(entry -> {

            double average = getSum(entry.getValue()) / entry.getValue().size();

            System.out.println(String.format("%s is graduated with %s", entry.getKey(), average));

        });


    }

    private static double getSum(List<Double> value) {
        double sum = 0;


        for (int i = 0; i < value.size(); i++) {

            sum += value.get(i);

        }
        return sum;

    }
}
