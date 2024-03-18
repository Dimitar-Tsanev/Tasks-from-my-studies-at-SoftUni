package coding_tracker;

import java.lang.reflect.Method;

class Tracker {
    @Author(name = "Random name")
    public static void main ( String[] args ) {
        printMethodsByAuthor ( Tracker.class );

    }
    @Author (name = "Some name")
    private static void printMethodsByAuthor (Class<?> clazz){
        Method[] methods = clazz.getDeclaredMethods ();
        for ( Method method: methods ){
            if (method.isAnnotationPresent ( Author.class )){
                System.out.println ( method.getName () + " : " + method.getAnnotation ( Author.class ).name () );
            }
        }
    }
}
