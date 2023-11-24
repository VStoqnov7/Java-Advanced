package JavaAdvanced.P02StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] num = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = num[0];
        int s = num[1];
        int x = num[2];

        boolean isValid = false;

        int[] numToStack = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        ArrayDeque<Integer> queue = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            queue.offer(numToStack[i]);
        }

        for (int i = 0; i < s; i++) {
            queue.poll();

        }

        if (queue.contains(x)) {
            System.out.println("true");

        } else {

            if (queue.isEmpty()) {
                System.out.println("0");

            } else {

                System.out.println(Collections.min(queue));

            }
        }


    }
}
