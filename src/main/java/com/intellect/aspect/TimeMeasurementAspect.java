package com.intellect.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@Log4j2
public class TimeMeasurementAspect {
	@Around("hello()")
	public void measure(ProceedingJoinPoint pjp)throws Throwable{
		long start = System.currentTimeMillis();
		pjp.proceed();
		log.info(pjp.getTarget().getClass().getName()+ "took" + (System.currentTimeMillis()-start));
	}

	@Pointcut("execution(* com.intellect.controller.hello())")
	private void hello() {
		
	}
	
	@Pointcut("execution(* (@org.springframework.stereotype.service *).*(..))")
	private void hello() {
		
	}
	
	@Pointcut("within(com.intellect.*)")
	private void hello() {
		
	}
	
	
}
