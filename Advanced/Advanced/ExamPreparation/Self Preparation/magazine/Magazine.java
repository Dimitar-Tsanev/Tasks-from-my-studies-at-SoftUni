package magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine ( String type, int capacity ) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<> ( );

    }

    public void addCloth ( Cloth cloth ) {
        if ( capacity > this.data.size ( ) ) {
            this.data.add ( cloth );
        }
    }

    public boolean removeCloth ( String color ) {
        Cloth cloth = this.data.stream ( )
                .filter ( d -> d.getColor ( ).equals ( color ) )
                .findFirst ( )
                .orElse ( null );

        return cloth != null && this.data.remove ( cloth );
    }

    public Cloth getSmallestCloth () {
        return data.stream ( )
                .min ( Comparator.comparing ( Cloth::getSize ) )
                .orElse ( null );
    }

    public Cloth getCloth ( String color ) {
        return data.stream ( )
                .filter ( d -> d.getColor ( ).equals ( color ) )
                .findFirst ( )
                .orElse ( null );

    }

    public int getCount () {
        return this.data.size ();
    }

    public String report () {
        String firstLine = type + " magazine contains:";
        StringBuilder clothes = new StringBuilder ( );

        this.data.forEach ( v -> clothes.append ( System.lineSeparator ( ) ).append ( v ) );

        return firstLine + clothes;
    }
}
