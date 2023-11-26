package JavaAdvanced.P11DefiningClassesLab.P02Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");


            if (command.length == 1) {

                String name = command[0];

                Car cars = new Car(name);

                System.out.println(cars.toString());

            } else if (command.length == 2) {
                String name = command[0];
                String model = command[1];


                Car cars = new Car(name, model);

                System.out.println(cars.toString());

            } else if (command.length == 3) {
                String name = command[0];
                String model = command[1];
                int hp = Integer.parseInt(command[2]);


                Car cars = new Car(name, model, hp);

                System.out.println(cars.toString());


            }
        }


    }
}
