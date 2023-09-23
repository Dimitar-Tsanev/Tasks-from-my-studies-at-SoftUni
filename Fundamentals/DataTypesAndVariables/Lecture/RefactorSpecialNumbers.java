package DataTypesAndVariablesLecture;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner (System.in);
        int endNumber = Integer.parseInt(scanner.nextLine());
        for (int currentNumber = 1; currentNumber <= endNumber; currentNumber++) {
            int sumOfDigits = 0;
            int numberForOperations = currentNumber;
            while (numberForOperations > 0) {
                sumOfDigits += numberForOperations % 10;
                numberForOperations = numberForOperations / 10;
            }
            boolean isSpecialNum = (sumOfDigits == 5) || (sumOfDigits == 7) || (sumOfDigits == 11);
            String s = String.valueOf (isSpecialNum);
            String res = s.substring(0, 1).toUpperCase() + s.substring(1);
            System.out.printf("%d -> %s%n", currentNumber, res);
        }
    }
}
