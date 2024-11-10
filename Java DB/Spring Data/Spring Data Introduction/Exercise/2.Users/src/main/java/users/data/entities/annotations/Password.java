package users.data.entities.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import users.util.PasswordValidator;

import java.lang.annotation.*;


@Documented
@Constraint(
        validatedBy = {PasswordValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message () default "Invalid password";

    int minLength () default 0;

    int maxLength () default Integer.MAX_VALUE;

    boolean constraintDigit () default false;

    boolean constraintLowercase () default false;

    boolean constraintUppercase () default false;

    boolean constraintSpecialSymbol () default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
