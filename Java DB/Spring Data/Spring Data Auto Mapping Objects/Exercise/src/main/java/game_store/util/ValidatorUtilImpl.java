package game_store.util;

import game_store.util.interfacces.ValidatorUtil;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ValidatorUtilImpl implements ValidatorUtil {
    private final Validator validator;

    @Autowired
    public ValidatorUtilImpl(Validator validator){
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
