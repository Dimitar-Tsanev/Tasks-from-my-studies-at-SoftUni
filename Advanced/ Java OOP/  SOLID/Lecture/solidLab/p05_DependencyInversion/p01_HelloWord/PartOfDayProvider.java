package solidLab.p05_DependencyInversion.p01_HelloWord;

import java.time.LocalDateTime;

class PartOfDayProvider {
    private PartOfDayProvider () {
    }
    public static String partOfDay () {
        if ( LocalDateTime.now ( ).getHour ( ) < 12 ) {
            return  "morning";

        }
        if ( LocalDateTime.now ( ).getHour ( ) < 18 ) {
            return  "afternoon";

        }
        return "evening";
    }

}
