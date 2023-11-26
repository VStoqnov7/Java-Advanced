package JavaAdvanced.P10FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P02KnightsOfHonor {
    public static void main(String[] args) {
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> връща true / false -> test
        //BiFunction<приема1, приема2, връща> -> apply
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); //"Peter George Alex"
        String[] names = input.split("\\s+"); //["Peter", "George", "Alex"]

        //име -> отпечатам "Sir " + име
        Consumer<String> printName = name -> System.out.println("Sir " + name);
        Arrays.stream(names).forEach(printName);

        /*for (String name : names) {
            printName.accept(name);
        }*/
    }
}

//        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
//
//
//        Consumer<List<String>> printNames = nameLists -> nameLists.forEach(name -> System.out.println("Sir " + name));
//
//        printNames.accept(list);
//
//    }
//}
