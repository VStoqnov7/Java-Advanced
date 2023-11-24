package JavaAdvanced.P05SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double[] num = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();



        Map<Double, Integer> products = new LinkedHashMap<>();


        for (int i = 0; i < num.length; i++) {

            double input = num[i];

            if (products.containsKey(input)){

                products.put(input,products.get(input) + 1);

            }else {

                products.put(input,1);
            }

        }



        products.forEach((key, value) -> {
            System.out.printf("%.1f -> %d", key, value);
            System.out.println();
        });











    }
}
