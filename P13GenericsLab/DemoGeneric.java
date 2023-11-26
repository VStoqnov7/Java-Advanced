package JavaAdvanced.P13GenericsLab;

import java.util.ArrayList;
import java.util.List;

public class DemoGeneric {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Desi");
        list.add("Ivan");
        System.out.println(getElementAtIndex(list, 1));

        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(4);
        System.out.println(getElementAtIndex(numbers, 1));


    }
    //Generics -> универсални решения за всички типове
    //generic method -> универсален (работи с всички типове)
    public static <T> T getElementAtIndex (List<T> list, int index) {
        T element = list.get(index);
        return element;
    }


    //метод, който връща текст на даден индекс от лист
    public static String getAtIndex(List<String> list, int index) {
        String element = list.get(index);
        return element;
    }

    //метод, който връща цяло число на даден индекс от лист
    public static int getIntAtIndex (List<Integer> list, int index) {
        int numberAtIndex = list.get(index);
        return numberAtIndex;
    }
}