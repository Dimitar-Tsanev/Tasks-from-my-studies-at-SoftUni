package random_ArrayList;

import java.util.ArrayList;
import java.util.Random;

class RandomArrayList<T> extends ArrayList<T> {
    private final Random randomInt;

    public RandomArrayList ( ) {
        super();
        this.randomInt = new Random ( );
    }

    public Object getRandomElement(){
        int index = this.randomInt.nextInt (super.size ());

        Object element = super.get ( index );
        super.remove ( element );

        return element;
    }

}
