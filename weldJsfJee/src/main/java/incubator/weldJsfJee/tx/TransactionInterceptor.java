package incubator.weldJsfJee.tx;

import incubator.weldJsfJee.controller.CustomerController;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.UserTransaction;

/**
 * Interceptor for Transaction-Handling.
 * 
 * Implements Serializable due to: "A managed bean is passivation capable if and
 * only if the bean class is serializable and all interceptors and decorators of
 * the bean are serializable." cdi spec 1.0 6.6.1
 * 
 * 
 * @see beans.xml
 * 
 * @author schuetz
 * @date 17.01.2010
 */
@Transactional
@Interceptor
public class TransactionInterceptor implements Serializable {

	@Inject
	private UserTransaction tx;

	/**
	 * Equals REQUIRES_NEW Transaction.
	 * 
	 * TODO required new<br>
	 * TODO is AOP better suited?
	 */
	@AroundInvoke
	public Object manageTransaction(InvocationContext ctx) throws Exception {

		// TODO use ThreadLocal to avoid dependency on CustomerController (worse alternative: SuperController class)
		CustomerController cc = (CustomerController) ctx.getTarget();

		// begin TX
		tx.begin();

		cc.getEm().joinTransaction();

		// invoke intercepted method
		Object result = ctx.proceed();

		// commit TX
		tx.commit();

		return result;
	}

}
