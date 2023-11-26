package JavaAdvanced.P12DefiningClassesExercises.P09CatLady.P09CatLady;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();

        while (!command.equals("End")) {

            String[] input = command.split("\\s+");
            String breed = input[0];
            String name = input[1];
            double earFurLengthDecibelsOfMeows = Double.parseDouble(input[2]);


            switch (breed) {
                case "StreetExtraordinaire":
                    StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(name, earFurLengthDecibelsOfMeows);
                    data.putIfAbsent(name, streetExtraordinaire);
                    break;
                case "Siamese":
                    Siamese siamese = new Siamese(name, earFurLengthDecibelsOfMeows);
                    data.putIfAbsent(name, siamese);
                    break;
                case "Cymric":
                    Cymrik cymrik = new Cymrik(name, earFurLengthDecibelsOfMeows);
                    data.putIfAbsent(name, cymrik);
                    break;
            }


            command = scanner.nextLine();
        }

        String name = scanner.nextLine();

        for (Map.Entry<String, Object> entry : data.entrySet()) {
            if (entry.getKey().equals(name)){
                System.out.println(entry.getValue().toString());


            }
        }


    }
}
