package JavaAdvanced.P06SetsAndMapsAdvancedExercises;

import java.util.*;

public class P13DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, TreeMap<String, ArrayList<Double>>> dragons = new LinkedHashMap<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");

            //{type} {name} {damage} {health} {armor}
            String type = tokens[0];
            String name = tokens[1];
            double damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);
            double health = tokens[3].equals("null") ? 250 : Integer.parseInt(tokens[3]);
            double armor = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);

            if(!dragons.containsKey(type)){
                dragons.put(type, new TreeMap<>(){{
                    put(name, new ArrayList<>(){{
                        add(damage);
                        add(health);
                        add(armor);
                    }});
                }});
            }else{
                if(!dragons.get(type).containsKey(name)){
                    dragons.get(type).put(name, new ArrayList<>(){{
                        add(damage);
                        add(health);
                        add(armor);
                    }});
                }else {
                    dragons.get(type).get(name).add(0, damage);
                    dragons.get(type).get(name).add(1, health);
                    dragons.get(type).get(name).add(2, armor);
                }
            }
        }

        for (String type : dragons.keySet()) {
            double damageSum = 0;
            double healthSum = 0;
            double armorSum = 0;

            StringBuilder builder = new StringBuilder();

            for (String name : dragons.get(type).keySet()) {
                double tempDamage = dragons.get(type).get(name).get(0);
                double tempHealth = dragons.get(type).get(name).get(1);
                double tempArmor = dragons.get(type).get(name).get(2);

                builder.append(String.format("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n", name, tempDamage, tempHealth, tempArmor));

                damageSum += tempDamage;
                healthSum += tempHealth;
                armorSum += tempArmor;
            }
            damageSum /= dragons.get(type).keySet().size();
            healthSum /= dragons.get(type).keySet().size();
            armorSum /= dragons.get(type).keySet().size();

            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", type, damageSum, healthSum, armorSum));
            System.out.print(builder.toString());


        }
    }
}

//        int n = Integer.parseInt(scanner.nextLine());
//
//        LinkedHashMap<String, TreeMap<String, List<Integer>>> dragon = new LinkedHashMap<>();
//
//
//        for (int i = 0; i < n; i++) {
//
//            String[] command = scanner.nextLine().split("\\s+");
//            String type = command[0];
//            String name = command[1];
//            int damage = 0;
//
//            if (command[2].equals("null")){
//                damage = 45;
//
//            }else {
//                damage = Integer.parseInt(command[2]);
//
//            }
//
//            int health = 0;
//
//            if (command[3].equals("null")){
//                health = 250;
//
//            }else {
//                health = Integer.parseInt(command[3]);
//
//            }
//
//            int armor = 0;
//
//            if (command[4].equals("null")){
//                armor = 10;
//
//            }else {
//                armor = Integer.parseInt(command[4]);
//
//            }
//
//
//
//
//
//
//
//
//            if (dragon.containsKey(type) && dragon.get(type).containsKey(name)){
//
//
//                dragon.get(type).get(name).set(0,damage);
//                dragon.get(type).get(name).set(1,health);
//                dragon.get(type).get(name).set(2,armor);
//
//
//
//
//            }else {
//                dragon.putIfAbsent(type,new TreeMap<>());
//                dragon.get(type).putIfAbsent(name,new ArrayList<>());
//            dragon.get(type).get(name).add(damage);
//            dragon.get(type).get(name).add(health);
//            dragon.get(type).get(name).add(armor);
//            }
//
//
//        }
//
//
//
//
//
//
//        dragon.entrySet().forEach(entry -> {
//
//
//            AtomicReference<Double> sumDamage = new AtomicReference<>((double) 0);
//            AtomicReference<Double> sumHealth = new AtomicReference<>((double) 0);
//            AtomicReference<Double> sumArmor = new AtomicReference<>((double) 0);
//
//            entry.getValue().forEach((k,v) -> {
//
//                sumDamage.updateAndGet(v1 -> (double) (v1 + v.get(0)));
//                sumHealth.updateAndGet(v1 -> (double) (v1 + v.get(1)));
//                sumArmor.updateAndGet(v1 -> (double) (v1 + v.get(2)));
//
//            });
//
//            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",entry.getKey(),sumDamage.get()/entry.getValue().size(),sumHealth.get()/entry.getValue().size(),sumArmor.get()/entry.getValue().size());
//
//           entry.getValue().forEach((k,v) -> {
//               System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",k,v.get(0),v.get(1),v.get(2));
//           });
//
//
//
//
//
//
//
//
//
//        });
//
//
//
//
//
//
//
//
//
//
//    }
//}
