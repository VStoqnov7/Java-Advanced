package JavaAdvanced.P05SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();

        Set<String> data = new LinkedHashSet<>();


        while (!command.equals("END")){

            String[] input = command.split(", ");

            String inOrOut = input[0];
            String carsNum = input[1];

            if (inOrOut.equals("IN")){
                data.add(carsNum);


            } else if (inOrOut.equals("OUT")) {
                data.remove(carsNum);



            }


            command = scanner.nextLine();
        }


        if (data.isEmpty()){

            System.out.println("Parking Lot is Empty");

        }else {

            while (!data.isEmpty()) {

                String numberCars = data.iterator().next();

                System.out.println(numberCars);

                data.remove(numberCars);

            }





        }













    }
}
