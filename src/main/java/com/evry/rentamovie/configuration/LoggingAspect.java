package com.evry.rentamovie.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	//private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Around(value = "execution(* com.evry.rentamovie.controller.*.*(..)) "
			+ "|| execution(* com.evry.rentamovie.service.*.*(..))" )
	public Object logging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		ObjectMapper objectMapper = new ObjectMapper();
		String methodName = proceedingJoinPoint.getSignature().getName();
		String className = proceedingJoinPoint.getTarget().getClass().toString();
		Object[] arguments = proceedingJoinPoint.getArgs();
		log.info("Call from " + className + ":" + methodName + "()" + "Arguments :"
				+ objectMapper.writeValueAsString(arguments));
		Object response = proceedingJoinPoint.proceed();
		log.info("Response from " + className + ":" + methodName + "()" + "Response :"
				+ objectMapper.writeValueAsString(response));

		return response;
	}
}