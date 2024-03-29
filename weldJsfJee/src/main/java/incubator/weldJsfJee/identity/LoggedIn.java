package incubator.weldJsfJee.identity;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * Qualifier for LoggedIn-State.
 * 
 * @author schuetz
 * @date 14.01.2010
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { TYPE, METHOD, FIELD })
@Qualifier
public @interface LoggedIn {
}
