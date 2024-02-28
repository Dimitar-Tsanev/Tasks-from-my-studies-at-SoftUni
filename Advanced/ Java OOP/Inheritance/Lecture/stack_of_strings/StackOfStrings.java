package stack_of_strings;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class StackOfStrings{
    private List<String> data;

    public StackOfStrings (  ) {
        setContainer ();
    }
    private void setContainer ( ) {
        this.data = new ArrayList<> ();
    }
    public void push(String element) {
        this.data.add ( element );
    }
    public String peek(){
        if (data.isEmpty ()){
            throw new NoSuchElementException ( "StackOfStrings is empty" );
        }
        return this.data.get ( this.data.size () - 1);

    }
    public String pop(){
        peek ();
        return this.data.remove ( this.data.size () - 1 );

    }
    public boolean isEmpty(){
        return this.data.isEmpty ();
    }
}
