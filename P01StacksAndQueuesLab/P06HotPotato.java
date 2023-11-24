package JavaAdvanced.P01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] names = scanner.nextLine().split(" ");

        int n = Integer.parseInt(scanner.nextLine());


        ArrayDeque<String> queue = new ArrayDeque<>();


        for (int i = 0; i < names.length; i++) {

            queue.offer(names[i]);

        }

        while (queue.size() > 1) {


            String name = "";

            for (int i = 1; i < n; i++) {

                name = queue.poll();
                queue.offer(name);

            }

            if (queue.size() == 1) {
                break;
            }


            System.out.println("Removed " + queue.poll());

        }

        System.out.println("Last is " + queue.peek());

    }
}
