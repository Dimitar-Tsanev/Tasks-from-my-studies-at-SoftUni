package StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        /*Create 2 TreeSets of type Person,
        the first should implement the name comparator,
        and the second should implement the age comparator.*/

        Set<Person> personToCompareByName = new TreeSet<> (new PersonNameComparator ());
        Set<Person> personToCompareByAge = new TreeSet<> (new PersonAgeComparator ());

        /*On the first line of input, you will receive a number N.
        On each of the next N lines, you will receive information about people
        in the format "{name} {age}".
        Add the people from the input into both sets
        (both sets should hold all the people passed in from the input).*/

        int peopleNumber = Integer.parseInt ( scanner.nextLine () );

        for ( int i = 0 ; i < peopleNumber ; i++ ) {
            String[] personData = scanner.nextLine ().split ( "\\s+" );
            String name = personData[0];
            int age = Integer.parseInt ( personData[1] );

            Person person = new Person ( name, age );

            personToCompareByName.add ( person );
            personToCompareByAge.add ( person );
        }

        personToCompareByName.forEach ( System.out::println );

        personToCompareByAge.forEach ( System.out::println );
    }
}
