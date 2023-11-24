package JavaAdvanced.P05SetsAndMapsAdvancedLab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int rotation = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> products = new LinkedHashMap<>();

        for (int i = 0; i < rotation; i++) {
            String[] commandArr = scanner.nextLine().split("\\s+");
            String continent = commandArr[0];
            String country = commandArr[1];
            String city = commandArr[2];

            if (!products.containsKey(continent)) {
                products.put(continent, new LinkedHashMap<>());
                products.get(continent).put(country, new ArrayList<>());
                products.get(continent).get(country).add(city);
            } else {
                if (!products.get(continent).containsKey(country)){
                    products.get(continent).put(country, new ArrayList<>());
                    products.get(continent).get(country).add(city);
                } else {
                    products.get(continent).get(country).add(city);
                }
            }
        }

        products.forEach((continent, countries) -> {
            System.out.println(continent + ":");
            countries.forEach((country, cities) ->
                    System.out.println(country + " -> " + String.join(", ", cities)));
        });

    }
}