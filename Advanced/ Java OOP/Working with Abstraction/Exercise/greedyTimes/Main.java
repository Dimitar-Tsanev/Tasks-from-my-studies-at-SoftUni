
package greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Bag bag = new Bag ( bagCapacity );

        for (int i = 0; i < safe.length; i++) {
            String name = safe[i];
            long amount = Long.parseLong(safe[++i]);

            bag.addItem ( name,amount );
        }

        System.out.println ( bag );
    }
}