package JavaAdvanced.P09FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни
        String input = scanner.nextLine();
        List<String> words = Arrays.stream(input.split("\\s+")).collect(Collectors.toList()); //лист със всички думи в текста

        //дума -> true (ако започва с главна буква) / false (ако не започва с главна буква)
        Predicate<String> isUppercase = word -> Character.isUpperCase(word.charAt(0));
        words = words.stream().filter(isUppercase).collect(Collectors.toList());

        //words -> имаме само думи, които започват с главна буква
        System.out.println(words.size());
        System.out.println(String.join("\n", words));

    }
}

//        List<String> newList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
//
//
//        Predicate<Character> isValid = word -> Character.isUpperCase(word);
//
//
//        List<String> result = new ArrayList<>();
//
//
//        for (String word : newList) {
//
//            char symbol = word.charAt(0);
//            if (isValid.test(symbol)) {
//                result.add(word);
//            }
//
//
//        }
//
//
//        System.out.println(result.size());
//        result.stream().forEach(System.out::println);
//
//
//    }
//}
