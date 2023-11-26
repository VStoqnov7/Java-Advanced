package JavaAdvanced.P14GenericsExercises.box;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        1.
//        int n = Integer.parseInt(scanner.nextLine());
//
//        Box<String> box = new Box<>();
//
//        for (int i = 0; i < n; i++) {
//            String element = scanner.nextLine();
//            box.add(element);
//        }
//
//        System.out.println(box);

//        2.
//        int n = Integer.parseInt(scanner.nextLine());
//
//        Box<Integer> box = new Box<>();
//
//        for (int i = 0; i < n; i++) {
//            int element = Integer.parseInt(scanner.nextLine());
//            box.add(element);
//        }
//
//        System.out.println(box);


//        3.
//        int n = Integer.parseInt(scanner.nextLine());
//        Box<String> box = new Box<>();
//
//        for (int i = 0; i < n; i++) {
//            String element = scanner.nextLine();
//            box.add(element);
//        }
//        String[] indices = scanner.nextLine().split(" ");
//        int firstIndex = Integer.parseInt(indices[0]);
//        int secondIndex = Integer.parseInt(indices[1]);
//        box.swap(firstIndex, secondIndex);
//
//        System.out.println(box);

//        4.
//        int n = Integer.parseInt(scanner.nextLine());
//        Box<Integer> box = new Box<>();
//
//        for (int i = 0; i < n; i++) {
//            int element = Integer.parseInt(scanner.nextLine());
//            box.add(element);
//        }
//        String[] indices = scanner.nextLine().split(" ");
//        int firstIndex = Integer.parseInt(indices[0]);
//        int secondIndex = Integer.parseInt(indices[1]);
//        box.swap(firstIndex, secondIndex);
//
//        System.out.println(box);

//        5.
//        Box<String> box = new Box<>();
//
//        int n = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < n; i++) {
//            String element = scanner.nextLine();
//            box.add(element);
//        }
//
//        String command = scanner.nextLine();
//        System.out.println(box.countOfGreaterItems(command));
//

        Box<Double> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            double element = Double.parseDouble(scanner.nextLine());
            box.add(element);
        }

        double command = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countOfGreaterItems(command));


    }
}
