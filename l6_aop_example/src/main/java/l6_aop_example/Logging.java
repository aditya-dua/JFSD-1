package l6_aop_example;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logging {
	
	@Pointcut("execution(* l6_aop_example.*.*(..))")
	private void selectAll() {
		
	}
	
	@Before("selectAll()")
	public void beforeAdvise() {
		System.out.println("Going to setup Logging");
		
	}
	
	@After("selectAll()")
	public void afterAdvise() {
		System.out.println("After Going to setup Logging");
		
	}
	
	@AfterReturning(pointcut="selectAll()", returning = "retVal")
	public void afterReturningAdvice(Object retVal) {
		System.out.println("Returning:: "+retVal.toString());
	}
	@AfterThrowing(pointcut = "selectAll()", throwing = "ex")
	public void AfterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("THere was an Exception:"+ex);
	}
}
