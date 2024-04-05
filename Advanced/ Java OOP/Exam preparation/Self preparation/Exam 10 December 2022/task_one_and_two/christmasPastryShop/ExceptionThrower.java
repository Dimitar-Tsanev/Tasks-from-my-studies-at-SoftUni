package christmasPastryShop;


import christmasPastryShop.repositories.interfaces.Repository;

import static christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;

public class ExceptionThrower {
    private ExceptionThrower () {
    }
    public static void throwIfEmptyString (String string, String exceptionMessage ){
        if (string == null || string.trim ().isEmpty ()){
            throw new IllegalArgumentException ( exceptionMessage);
        }
    }
    public static void throwIfNumberIsLessOrZero (double number, String exceptionMessage ){
        if (number <= 0){
            throw new IllegalArgumentException ( exceptionMessage);
        }
    }
    public static void throwIfNumberIsNegative (double number, String exceptionMessage ){
        if (number < 0){
            throw new IllegalArgumentException ( exceptionMessage);
        }
    }
}
