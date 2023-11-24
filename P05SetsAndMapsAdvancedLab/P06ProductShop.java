package JavaAdvanced.P05SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();

        Map<String, Map<String,Double>> products = new TreeMap<>();


        while (!command.equals("Revision")){

            String store = command.split(",\\s+")[0];
            String product = command.split(",\\s+")[1];
            double price = Double.parseDouble(command.split(",\\s+")[2]);


            if (products.containsKey(store)){

                products.get(store).put(product,price);

            }else {

                products.put(store,new LinkedHashMap<>());
                products.get(store).put(product,price);


            }

            command = scanner.nextLine();

        }




        products.entrySet().forEach(entry -> {

            System.out.printf("%s->%n",entry.getKey());
            entry.getValue().entrySet().forEach(values -> {

                System.out.printf("Product: %s, Price: %.1f%n",values.getKey(),values.getValue());

            });

        });



    }
}
