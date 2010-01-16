package weldTest.weldJsfJee.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.UserTransaction;

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

	@AroundInvoke
	public Object manageTransaction(InvocationContext ctx) throws Exception {

		System.out.println("-- Invoking method: " + ctx.getMethod());
		// TODO TX-Verhalten
//		tx.begin();

		// TODO
		// Aufruf kurz vor Abschluss??? --> 2 Interceptor bauen: TX_BEGIN, TX_COMMIT --> Multiple with one @Transactional
		// tx.commit();

		return ctx.proceed();
	}

}
