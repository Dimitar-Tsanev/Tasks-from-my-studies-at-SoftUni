import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String input = scanner.nextLine ( );

        int coolThreshold = 1;

        Pattern digitPattern = Pattern.compile ( "[0-9]" );
        Matcher digitMatcher = digitPattern.matcher ( input );

        while (digitMatcher.find ( )) {
            coolThreshold *= Integer.parseInt ( digitMatcher.group ( ) );

        }
        Pattern emojiPattern = Pattern.compile ( "(\\*{2}|:{2})(?<emoji>[A-Z][a-z]{2,})\\1" );
        Matcher emojiMatcher = emojiPattern.matcher ( input );

        List<String> allEmoji = new ArrayList<> ( );
        List<String> coolEmoji = new ArrayList<> ( );

        while (emojiMatcher.find ( )) {
            String emoji = emojiMatcher.group ( "emoji" );
            int emojiThreshold = 0;

            for ( char character : emoji.toCharArray ( ) ) {
                emojiThreshold += character;

            }
            allEmoji.add ( emojiMatcher.group ( ) );

            if ( emojiThreshold > coolThreshold ) {
                coolEmoji.add ( emojiMatcher.group ( ) );

            }
        }
        System.out.println ( "Cool threshold: " + coolThreshold );
        System.out.println ( allEmoji.size ( ) + " emojis found in the text. The cool ones are:" );

        coolEmoji.forEach ( System.out::println );
    }
}
