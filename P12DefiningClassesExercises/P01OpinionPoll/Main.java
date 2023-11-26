package JavaAdvanced.P12DefiningClassesExercises.P01OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> data = new ArrayList<>();



        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String name = command[0];
            int age = Integer.parseInt(command[1]);

            Person person = new Person(name,age);

            data.add(person);



        }


        data.sort(Comparator.comparing(person -> person.getName()));
        for (Person personData : data) {
            Person person = personData;

            if (person.getAge() > 30){
                System.out.println(person.getName() + " - " + person.getAge());
            }
        }


//        List<Person> filteredPeople = people.stream()
//                .filter(person -> person.getAge() > 30)
//                .sorted(Comparator.comparing(Person::getName))
//                .collect(Collectors.toList());
//
//        for (Person person : filteredPeople) {
//            System.out.println(person.getName() + " - " + person.getAge());
//        }


    }
}
