package JavaAdvanced.P05SetsAndMapsAdvancedLab;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class P03WarNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));


        for (int i = 0; i < 50; i++) {

            if (firstPlayer.isEmpty() && secondPlayer.size() > 0) {
                System.out.println("Second player win!");
                return;

            } else if (secondPlayer.isEmpty() && firstPlayer.size() > 0) {
                System.out.println("First player win!");
                return;

            }

            int firstCard = firstPlayer.iterator().next();
            int secondCard = secondPlayer.iterator().next();

            firstPlayer.remove(firstCard);
            secondPlayer.remove(secondCard);

            if (firstCard > secondCard) {

                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);

            } else if (secondCard > firstCard) {
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);


            }else {

                firstPlayer.add(firstCard);
                secondPlayer.add(secondCard);

            }


        }

        if (firstPlayer.size() > secondPlayer.size()){
            System.out.println("First player win!");

        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");

        }else {
            System.out.println("Draw");

        }


    }
}
