package GenericCountMethodStrings;

class Box <T extends Comparable<T>> {

   private T element;
   public Box (T element){
       this.element = element;

   }

    public T getElement () {
        return this.element;
    }
    public boolean compare (Box<T> box){
        return this.element.compareTo ( box.getElement ( ) ) > 0;
    }
}

