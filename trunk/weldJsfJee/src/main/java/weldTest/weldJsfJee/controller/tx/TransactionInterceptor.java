package weldTest.weldJsfJee.controller.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.UserTransaction;

import weldTest.weldJsfJee.controller.PersonController;

/**
 * Interceptor fuer Transaction-Handling.
 * 
 * implements Serializable wegen: "A managed bean is passivation capable if and
 * only if the bean class is serializable and all interceptors and decorators of
 * the bean are serializable." cdi spec 1.0 6.6.1
 * 
 * 
 * @see beans.xml
 * @author schuetz
 * 
 */
@Transactional
@Interceptor
public class TransactionInterceptor implements Serializable {

	@Inject
	private UserTransaction tx;

	/**
	 * Entspricht eine REQUIRES_NEW Ttansaction
	 * 
	 * TODO required new<br>
	 * TODO AOP-Ansatz besser geeignet?
	 */
	@AroundInvoke
	public Object manageTransaction(InvocationContext ctx) throws Exception {

		// TODO generisch via ThreadLocal?
		PersonController pc = (PersonController) ctx.getTarget();

		// begin TX
		tx.begin();

		pc.getEm().joinTransaction();

		// Aufruf der intercepteten Methode
		Object result = ctx.proceed();

		// commit TX
		tx.commit();

		return result;
	}

}
