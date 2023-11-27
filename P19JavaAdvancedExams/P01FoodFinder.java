package JavaAdvanced.P19JavaAdvancedExams;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class P01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        LinkedHashMap<String, TreeMap<String,Integer>> data = new LinkedHashMap<>();

        ArrayDeque<Character> queue = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();

        fillData(data);

        Set<String> words = new TreeSet<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(str -> str.charAt(0))
                .forEach(queue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(str -> str.charAt(0))
                .forEach(stack::push);

        while (!stack.isEmpty()){


            char symbolQueue = queue.poll();
            char symbolStack = stack.pop();


            for (Map.Entry<String, TreeMap<String, Integer>> item : data.entrySet()) {

                TreeMap<String,Integer> current = item.getValue();

                for (Map.Entry<String, Integer> item2 : current.entrySet()) {

                    String letter = item2.getKey();
                    char currentSymbol = letter.charAt(0);
                    if (currentSymbol == symbolQueue || symbolStack == currentSymbol){
                        item.getValue().put(currentSymbol + "",item.getValue().get(currentSymbol + "") + 1);

                    }
                }


            }

                queue.addLast(symbolQueue);



        }

        int counts = 0;

        List<String> list = new ArrayList<>();


        TreeMap<String, Integer> innerMap1 = data.get("pear");
        boolean pear = innerMap1.values().stream().allMatch(count -> count > 0);
        TreeMap<String, Integer> innerMap2 = data.get("flour");
        boolean flour = innerMap2.values().stream().allMatch(count -> count > 0);
        TreeMap<String, Integer> innerMap3 = data.get("pork");
        boolean pork = innerMap3.values().stream().allMatch(count -> count > 0);
        TreeMap<String, Integer> innerMap4 = data.get("olive");
        boolean olive = innerMap4.values().stream().allMatch(count -> count > 0);

        if (pear){
            counts++;
            list.add("pear");
        }
        if (flour){
            counts++;
            list.add("flour");
        }
        if (pork){
            counts++;
            list.add("pork");
        }
        if (olive){
            counts++;
            list.add("olive");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Words found: ").append(counts);
        System.out.println(sb.toString());
        list.forEach(System.out::println);


    }

    private static void fillData(LinkedHashMap<String, TreeMap<String, Integer>> data) {
        data.put("pear",new TreeMap<>());
        data.put("flour",new TreeMap<>());
        data.put("pork",new TreeMap<>());
        data.put("olive",new TreeMap<>());

        data.entrySet().stream().forEach(entry -> {
            String key = entry.getKey();
            TreeMap<String, Integer> innerMap = entry.getValue();

            AtomicInteger index = new AtomicInteger();
            key.chars().mapToObj(c -> String.valueOf((char) c))
                    .forEach(letter -> innerMap.put(letter, 0));
        });

    }


}
