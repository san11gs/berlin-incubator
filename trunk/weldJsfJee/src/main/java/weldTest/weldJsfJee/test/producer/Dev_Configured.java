package weldTest.weldJsfJee.test.producer;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * Qualifier fuer DEVELOPMENT-Config.
 * 
 * @author schuetz
 * @date 13.01.2010
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { TYPE, METHOD, FIELD })
@Qualifier
public @interface Dev_Configured {
}
