package users.util;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

import users.data.entities.annotations.Password;

import java.lang.invoke.MethodHandles;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, CharSequence> {
    private static final String PATTERN_TEMPLATE = "[A-Za-z\\d!@#$%%^&*()_+<>?]%s$";

    private static final String ONE_DIGIT = "(?=.*\\d)";
    private static final String LOWER_CASE = "(?=.*[a-z])";
    private static final String UPPER_CASE = "(?=.*[A-Z])";
    private static final String SPECIAL_CHAR = "(?=.*[!@#$%^&*()_+<>?])";
    private static final String NO_SPACE = "(?=\\S+$)";

    private static final String MIN_MAX_CHAR_TEMPLATE = "{%s,%s}";

    private static final Log LOG = LoggerFactory.make( MethodHandles.lookup() );

    private int minLength;
    private int maxLength;
    private boolean constraintDigit;
    private boolean constraintLowercase;
    private boolean constraintUppercase;
    private boolean constraintSpecialSymbol;

    @Override
    public void initialize ( Password constraint ) {
        this.minLength = constraint.minLength ();
        this.maxLength = constraint.maxLength ();
        this.constraintDigit = constraint.constraintDigit ();
        this.constraintLowercase = constraint.constraintLowercase ();
        this.constraintUppercase = constraint.constraintUppercase ();
        this.constraintSpecialSymbol = constraint.constraintSpecialSymbol ();
    }

    @Override
    public boolean isValid ( CharSequence value, ConstraintValidatorContext context ) {
        if ( value == null || value.isEmpty ( ) ) {
            return false;
        }

        String pattern;

        if ( isValidLength ( value )) {
            String charsLength = String.format ( MIN_MAX_CHAR_TEMPLATE, minLength,maxLength);
            pattern = String.format ( PATTERN_TEMPLATE, charsLength );

        }else {
            return false;

        }

        pattern = getPatternBuilder ( ) + pattern;

        Pattern regex = Pattern.compile ( pattern );

        Matcher matcher = regex.matcher(value);

        return matcher.matches();
    }

    private boolean isValidLength(CharSequence value){
        if ( value == null ) {
            return true;
        }
        validateParameters();

        int length = value.length();

        return length >= minLength && length <= maxLength;
    }

    private StringBuilder getPatternBuilder () {
        StringBuilder patternBuilder = new StringBuilder ();

        patternBuilder.append ( "^" );
        patternBuilder.append ( NO_SPACE );

        if (this.constraintDigit) {
            patternBuilder.append (ONE_DIGIT);
        }
        if (this.constraintLowercase) {
            patternBuilder.append (LOWER_CASE);
        }
        if (this.constraintUppercase) {
            patternBuilder.append (UPPER_CASE);
        }
        if (this.constraintSpecialSymbol) {
            patternBuilder.append (SPECIAL_CHAR);
        }
        return patternBuilder;
    }

    private void validateParameters() {
        if ( minLength < 0 ) {
            throw LOG.getMinCannotBeNegativeException();
        }
        if ( maxLength < 0 ) {
            throw LOG.getMaxCannotBeNegativeException();
        }
        if ( maxLength < minLength ) {
            throw LOG.getLengthCannotBeNegativeException();
        }
    }
}


