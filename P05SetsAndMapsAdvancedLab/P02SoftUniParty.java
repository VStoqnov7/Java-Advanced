package JavaAdvanced.P05SetsAndMapsAdvancedLab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();


        Set<String> guest = new TreeSet<>();
        Set<String> vipGuest = new TreeSet<>();


        while (!command.equals("PARTY")) {

            boolean isValid = isValid(command);


            if (isValid) {

                char firstLetter = command.charAt(0);
                if (Character.isDigit(firstLetter)) {
                    vipGuest.add(command);
                } else {
                    guest.add(command);
                }

            }


            command = scanner.nextLine();
        }


        String nextCommand = scanner.nextLine();

        while (!nextCommand.equals("END")) {

            boolean isValid = isValid(nextCommand);


            if (isValid) {

                char firstLetter = nextCommand.charAt(0);
                if (Character.isDigit(firstLetter)) {
                    vipGuest.remove(nextCommand);
                } else {
                    guest.remove(nextCommand);
                }

            }

            nextCommand = scanner.nextLine();

        }




        System.out.println(vipGuest.size() + guest.size());


        while (!vipGuest.isEmpty()){


            String currentName = vipGuest.iterator().next();

            System.out.println(currentName);

            vipGuest.remove(currentName);

        }

        while (!guest.isEmpty()){

            String currentName = guest.iterator().next();
            System.out.println(currentName);
            guest.remove(currentName);

        }




    }

    private static boolean isValid(String command) {

        if (command.length() != 8) {
            return false;
        } else {
            return true;

        }


    }
}
