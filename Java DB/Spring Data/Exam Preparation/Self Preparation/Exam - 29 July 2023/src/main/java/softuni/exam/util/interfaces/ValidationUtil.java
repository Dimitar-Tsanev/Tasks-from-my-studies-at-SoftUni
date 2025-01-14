package softuni.exam.util.interfaces;


import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {

    <E> Set<ConstraintViolation<E>> validate ( E e);

    <E> boolean isValid(E e);
}