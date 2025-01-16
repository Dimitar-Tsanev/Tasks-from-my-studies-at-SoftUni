package smartwallet.shared.utils.validation.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.stereotype.Component;
import smartwallet.shared.utils.validation.anotations.UniqueUsername;
import smartwallet.user.service.UserService;

@Component
@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private String message;

    private final UserService userService;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if ( username == null || username.isEmpty ( ) ) {
            return true;
        }

        boolean b = !userService.isUsernameOccupied ( username );

        if (!b) {
            constraintValidatorContext.unwrap( HibernateConstraintValidatorContext.class)
                    .buildConstraintViolationWithTemplate(message)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return b;
    }
}
