package halloween;

import java.util.ArrayList;
import java.util.List;

class House {
    private int capacity;
    private List<Kid> data;

    public House ( int capacity ) {
        this.capacity = capacity;
        this.data = new ArrayList<> ();

    }
    public void addKid(Kid kid){
        if (this.data.size () < this.capacity){
            this.data.add ( kid );

        }
    }
    public boolean removeKid(String name){
        for ( Kid kid: data ){
            if (kid.getName ().equals ( name )){
                return data.remove ( kid );

            }
        }
        return false;
    }
    public Kid getKid(String street){
        for ( Kid kid: data ){
            if (kid.getStreet ().equals ( street )){
                return kid;

            }
        }
        return null;
    }
    public int getAllKids() {
        return this.data.size ();
    }
    public String getStatistics(){
        StringBuilder report = new StringBuilder ();

        report.append ( "Children who visited a house for candy:" );
        report.append ( System.lineSeparator () );

        for ( Kid kid: data ){
            report.append ( String.format ( "%s from %s street",
                    kid.getName (),
                    kid.getStreet () ));

            report.append ( System.lineSeparator () );

        }
        return report.toString ();
    }
}
