package StrategyPattern;

import java.util.Comparator;

class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare ( Person person1, Person person2 ) {
        String nameOfPerson1 = person1.getName ();
        String nameOfPerson2 = person2.getName ();

       if (nameOfPerson1.length () == nameOfPerson2.length ()){
           if(nameOfPerson1.toLowerCase ( ).charAt ( 0 ) == nameOfPerson2.toLowerCase ( ).charAt ( 0 )){
                   return 0;


           } else if ( nameOfPerson1.toLowerCase ( ).charAt ( 0 ) > nameOfPerson2.toLowerCase ( ).charAt ( 0 ) ) {
               return 1;

           }
           return -1;

       } else if ( nameOfPerson1.length () > nameOfPerson2.length () ) {
           return 1;

       }
       return -1;
    }
}
