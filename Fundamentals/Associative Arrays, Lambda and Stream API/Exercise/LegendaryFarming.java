import java.util.*;

public class LegendaryFarming {
    public static void main ( String[] args ) throws InterruptedException {
        Scanner scanner = new Scanner ( System.in );

        HashMap<String, Integer> materialsQuantity = new HashMap<> ( );
        LinkedHashMap<String, Integer> otherItemsQuantity = new LinkedHashMap<> ( );

        String lineNew = scanner.nextLine ( );

        String materialForCraft = "";

        while (!lineNew.isEmpty ( )) {
            String[] line = lineNew.toLowerCase ( ).split ( " " );

            for ( int i = 1 ; i < line.length; i += 2 ) {
                String material = line [i];
                int quantity = Integer.parseInt ( line[ i-1 ] );

                if ( material.equals ( "shards" ) ||
                        material.equals ( "fragments" ) ||
                        material.equals ( "motes" ) ) {

                    if ( materialsQuantity.containsKey ( material ) ) {
                        materialsQuantity.put ( material, materialsQuantity.get ( material ) + quantity );

                    } else {
                        materialsQuantity.put ( material, quantity );
                    }

                    if ( materialsQuantity.get ( material ) >= 250 ) {
                        materialForCraft = material;
                        break;
                    }

                } else {
                    if ( otherItemsQuantity.containsKey ( material ) ) {
                        otherItemsQuantity.put ( material, otherItemsQuantity.get ( material ) + quantity );
                    } else {
                        otherItemsQuantity.put ( material, quantity );
                    }
                }
            }
            if (materialForCraft.isEmpty ()) {
                lineNew = scanner.nextLine ( );
            }else{
                break;
            }
        }
        switch (materialForCraft) {
            case "shards":
                System.out.println ( "Shadowmourne obtained!" );
                materialsQuantity.put ( "shards", materialsQuantity.get ( "shards" ) - 250 );
                break;

            case "fragments":
                System.out.println ( "Valanyr obtained!" );
                materialsQuantity.put ( "fragments", materialsQuantity.get ( "fragments" ) - 250 );
                break;

            case "motes":
                System.out.println ( "Dragonwrath obtained!" );
                materialsQuantity.put ( "motes", materialsQuantity.get ( "motes" ) - 250 );
                break;
        }
        if (materialsQuantity.get ( "shards" ) == null ){
            System.out.printf ( "shards: %d%n", 0 );
        }else{
            System.out.printf ( "shards: %d%n", materialsQuantity.get ( "shards" ) );
        }
        if(materialsQuantity.get ( "fragments" ) == null){
            System.out.printf ( "fragments: %s%n", 0 );
        }else {
            System.out.printf ( "fragments: %s%n", materialsQuantity.get ( "fragments" ) );
        }
        if (materialsQuantity.get ( "motes" ) == null){
            System.out.printf ( "motes: %d%n", 0 );
        }else {
            System.out.printf ( "motes: %d%n", materialsQuantity.get ( "motes" ) );
        }
        otherItemsQuantity.forEach ( ( key, value ) -> System.out.printf ( "%s: %d%n", key, value ) );
    }
}
