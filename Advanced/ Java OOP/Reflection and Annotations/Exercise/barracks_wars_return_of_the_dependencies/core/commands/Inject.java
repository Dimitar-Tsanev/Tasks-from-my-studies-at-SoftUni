package barracks_wars_return_of_the_dependencies.core.commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target ( ElementType.FIELD )
@Retention (RetentionPolicy.RUNTIME)
public @interface Inject {
}
