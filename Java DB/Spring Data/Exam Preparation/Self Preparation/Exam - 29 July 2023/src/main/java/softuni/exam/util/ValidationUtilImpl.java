package softuni.exam.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import softuni.exam.util.interfaces.ValidationUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


@Component
public class ValidationUtilImpl implements ValidationUtil {
    private final Validator validator;

    @Autowired
    public ValidationUtilImpl(Validator validator){
        this.validator = validator;
    }

    @Override
    public <E> Set<ConstraintViolation<E>> validate ( E e ) {
        return validator.validate ( e );
    }

    @Override
    public <E> boolean isValid ( E e ) {
        return validate ( e ).isEmpty ();
    }
}
