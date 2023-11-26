package JavaAdvanced.P06SetsAndMapsAdvancedExercises;


import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        TreeMap <Character, Integer> symbolsCount = new TreeMap<>();
        //символ -> бр. срещанията

        for (int index = 0; index < text.length(); index++) {
            char currentSymbol = text.charAt(index);
            //символът вече да съм го срещала
            if (symbolsCount.containsKey(currentSymbol)) {
                int currentCount = symbolsCount.get(currentSymbol);
                symbolsCount.put(currentSymbol, currentCount + 1);
            }//символът да не съм го срещала
            else {
                symbolsCount.put(currentSymbol, 1);
            }
        }
        //символ: бр.срещания time/s
        symbolsCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s"));
    }
}

//        TreeMap<Character, Integer> products = new TreeMap<>();
//
//        String command = scanner.nextLine();
//
//
//        for (int i = 0; i < command.length(); i++) {
//
//            char symbol = command.charAt(i);
//
//            if (products.containsKey(symbol)) {
//
//                products.put(symbol, products.get(symbol) + 1);
//
//            } else {
//
//                products.put(symbol, 1);
//            }
//
//
//        }
//
//
//        products.entrySet().forEach(entry -> {
//            System.out.printf("%s: %d time/s%n",entry.getKey(),entry.getValue());
//        });
//
//
//    }
//}
