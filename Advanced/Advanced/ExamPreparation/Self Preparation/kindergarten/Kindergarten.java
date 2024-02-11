package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten ( String name, int capacity ) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<> (  );
    }
    public boolean addChild (Child child){
        if(capacity > this.registry.size ()){
            return this.registry.add ( child );
        }
        return false;
    }
    public boolean removeChild(String firstName){
        for ( Child child: registry ){
            if (child.getFirstName ().equals ( firstName )){
                return this.registry.remove ( child );

            }
        }
        return false;
    }
    public int getChildrenCount(){
        return this.registry.size ();
    }
    public Child getChild(String firstName){
        return registry.stream ()
                .filter ( c-> c.getFirstName ().equals ( firstName ) )
                .findFirst ()
                .orElse ( null );

    }
    public String registryReport(){
        String firstLine = String.format ( "Registered children in %s:", name);
        StringBuilder registryString = new StringBuilder ();

        this.registry.stream ()
                .sorted ( Comparator.comparing(Child::getAge)
                        .thenComparing(Child::getFirstName)
                        .thenComparing(Child::getLastName) )
                .forEach ( c-> registryString.append ( System.lineSeparator () ).append ( c ) );
        return firstLine + registryString;
    }
}
