import java.util.Scanner;

public class BackIn30Minutes {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int hours = Integer.parseInt ( scan.nextLine () );
        int mins = Integer.parseInt ( scan.nextLine () );
        mins += 30;
        if (mins > 59){
            mins -= 60;
            hours++;
            if (hours > 23){
                hours = 0;
            }
        }
        System.out.printf("%d:%02d", hours, mins);
    }
}
