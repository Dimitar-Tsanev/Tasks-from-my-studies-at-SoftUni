package coding_tracker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target (ElementType.METHOD)
@Retention ( RetentionPolicy.RUNTIME )

@interface Author {
    String name() default "";
}
