package JavaAdvanced.P14GenericsExercises.treeuple;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String name = input[0] + " " + input[1];
        String address = input[2];
        String city = input[3];
        Tuple<String, String, String> firstTuple = new Tuple<>(name,address,city);

        input = scanner.nextLine().split(" ");
        String firstName = input[0];
        Integer litersOfBeer = Integer.parseInt(input[1]);
        String drunkOrNot = input[2];
        boolean isValid = false;
        switch (drunkOrNot){
            case "drunk":
                isValid = true;
                break;
            case "not":
                isValid = false;
                break;
        }
        Tuple<String, Integer, Boolean> secondTuple = new Tuple<>(firstName, litersOfBeer,isValid);


        input = scanner.nextLine().split(" ");
        String number = input[0];
        Double decimal = Double.parseDouble(input[1]);
        String bankName = input[2];

        Tuple<String, Double, String> thirdTuple = new Tuple<>(number, decimal,bankName);

        System.out.println(firstTuple);
        System.out.println(secondTuple);
        System.out.println(thirdTuple);


    }
}
