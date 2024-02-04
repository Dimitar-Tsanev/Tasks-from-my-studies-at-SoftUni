package GenericCountMethodStrings;

public class Box <T extends Comparable<T>> {

   private T element;
   public Box (T element){
       this.element = element;

   }

    public T getElement () {
        return this.element;
    }
    public boolean compare (Box box){
        return this.element.compareTo ( (T) box.getElement ( ) ) > 0;
    }
}

