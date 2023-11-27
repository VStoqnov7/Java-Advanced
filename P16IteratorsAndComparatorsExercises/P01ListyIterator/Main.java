package JavaAdvanced.P16IteratorsAndComparatorsExercises.P01ListyIterator;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1)
                .toArray(String[]::new);
        ListyIterator listyIterator = new ListyIterator(elements);

        String command;
        while (!(command = scanner.nextLine()).equals("END")) {
            try {
                switch (command) {
                    case "Move":
                        System.out.println(listyIterator.move());
                        break;
                    case "HasNext":
                        System.out.println(listyIterator.hasNext());
                        break;
                    case "Print":
                        listyIterator.print();
                        break;
                }
            } catch (IllegalStateException e) {
                System.out.println("Invalid Operation!");
            }
        }
    }
}

