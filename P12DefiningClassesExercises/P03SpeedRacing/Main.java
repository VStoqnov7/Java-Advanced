package JavaAdvanced.P12DefiningClassesExercises.P03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Car> data = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuel = Double.parseDouble(input[1]);
            double priceForOneKm = Double.parseDouble(input[2]);

            Car car = new Car(model, fuel, priceForOneKm);

            if (!data.containsKey(model)) {
                data.put(model, car);
            }


        }


        String command = scanner.nextLine();


        while (!command.equals("End")) {

            String[] input = command.split("\\s+");
            String Drive = input[0];
            String model = input[1];
            int distance = Integer.parseInt(input[2]);

            Car car = data.get(model);

            double fuelCar = car.getFuel();
            double priceForOneKm = car.getPriceForOneKilometer();

            if (fuelCar >= distance * priceForOneKm) {
                double newFuel = fuelCar - (distance * priceForOneKm);
                int currentDistance = car.getDistance();
                int newDistance = currentDistance + distance;
                Car carDrive = new Car(model, newFuel, priceForOneKm, newDistance);


                data.put(model, carDrive);


            }else {
                System.out.println("Insufficient fuel for the drive");

            }


            command = scanner.nextLine();
        }

        data.entrySet().forEach(entry ->{

            System.out.println(entry.getKey() + entry.getValue());

        });

    }

}
