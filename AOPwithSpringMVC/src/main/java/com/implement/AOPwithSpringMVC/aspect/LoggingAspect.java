package com.implement.AOPwithSpringMVC.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.implement.AOPwithSpringMVC.controller.*.*(..))")
	private void forControllerPackage() {}

	@Pointcut("execution(* com.implement.AOPwithSpringMVC.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.implement.AOPwithSpringMVC.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	private void before(JoinPoint theJoinPoint) {
		logger.info("\n ===> in @Before Advice.");
		//display method name.
		String methodSig = theJoinPoint.getSignature().toString();
		logger.info("\n Method: " + methodSig);
		
		//display arguments to the method.
		Object arg[] = theJoinPoint.getArgs();
		
		for(Object tempArg : arg) {
			logger.info("\n ===> arguments: " + tempArg);
		}
	}
	
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		logger.info("\n ===> in @AfterReturning Advice.");
		//display method name.
		String methodSig = theJoinPoint.getSignature().toString();
		logger.info("\n Method: " + methodSig);
		
		//display arguments to the method.
		Object arg[] = theJoinPoint.getArgs();
		
		for(Object tempArg : arg) {
			logger.info("\n ===> arguments: " + tempArg);
		}
	}
	
}
