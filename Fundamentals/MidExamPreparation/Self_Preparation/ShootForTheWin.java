import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        int [] targets = Arrays.stream ( scan.nextLine ().split ( " " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        int shootCounter = 0;
        String input = scan.nextLine ();

        while (!input.equals ( "End" )){
            int targetIndex = Integer.parseInt ( input );
            if ( targetIndex >= 0 && targetIndex < targets.length){
                if ( targets [targetIndex] != -1){
                    shootCounter ++;
                    int shotValue = targets [targetIndex];
                    targets [targetIndex] = -1;
                    manipulateLeftedTargets ( targets, shotValue );
                }
            }
            input = scan.nextLine ( );
        }
        System.out.printf ( "Shot targets: %d -> ", shootCounter );
        System.out.println ( String.join ( " ", Arrays.toString ( targets ).replaceAll ( "[\\[\\],]", "" ) ));
    }
    public static void manipulateLeftedTargets ( int [] targets, int value ){
        for (int i =0; i < targets.length; i++ ){
            if ( targets [i] != -1 ){
                if ( targets [i] > value){
                    targets [i] -= value;
                } else {
                    targets [i] += value;
                }
            }
        }
    }
}
