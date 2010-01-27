package incubator.weldJsfJee.tx;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/**
 * Annotation to mark methods applicable for transactional behavior.
 * 
 * @see TransactionInterceptor
 * 
 * @author schuetz
 * @date 11.01.2010
 */
@InterceptorBinding
@Target( { ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Transactional {

}
