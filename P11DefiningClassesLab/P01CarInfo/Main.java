package JavaAdvanced.P11DefiningClassesLab.P01CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String name = command[0];
            String model = command[1];
            int hp = Integer.parseInt(command[2]);


            Car cars = new Car(name,model,hp);


            System.out.println(cars.toString());





        }


    }
}
