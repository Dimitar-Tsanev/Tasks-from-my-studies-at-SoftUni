package StrategyPattern;

import java.util.Comparator;

class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare ( Person person1, Person person2 ) {
        int ageOfPerson1 = person1.getAge ();
        int ageOfPerson2 = person2.getAge ();

        if (ageOfPerson1 > ageOfPerson2){
            return 1;

        }else if ( ageOfPerson1 == ageOfPerson2 ){
            return 0;

        }
        return -1;
    }
}
