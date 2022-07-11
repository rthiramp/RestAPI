package com.evry.rentamovie.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import com.evry.rentamovie.exceptions.AccessDeniedException;
import com.evry.rentamovie.exceptions.DataInvalidException;
import com.evry.rentamovie.exceptions.ErrorResponse;
import com.evry.rentamovie.exceptions.ForbiddenException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { DataInvalidException.class })
	protected ResponseEntity<Object> handleInvaildData(DataInvalidException ex, WebRequest request) {

		log.error("DataInvalidException : " + ex.toString());
		log.debug(ex.getMessage(), ex);

		ErrorResponse response = new ErrorResponse(ex.getMessage());
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(value = { ForbiddenException.class })
	protected ResponseEntity<Object> handleInvaildData(ForbiddenException ex, WebRequest request) {

		log.error("ForbiddenException : " + ex.toString());
		log.debug(ex.getMessage(), ex);

		ErrorResponse response = new ErrorResponse(ex.getMessage());
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
	}
	
	@ExceptionHandler(value = { AccessDeniedException.class })
	protected ResponseEntity<Object> handleInvaildData(AccessDeniedException ex, WebRequest request) {

		log.error("AccessDeniedException : " + ex.toString());
		log.debug(ex.getMessage(), ex);

		ErrorResponse response = new ErrorResponse(ex.getMessage());
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
	}
	
	@ExceptionHandler(value = { ConstraintViolationException.class })
	protected ResponseEntity<Object> handleInvaildData(ConstraintViolationException ex, WebRequest request) {

		log.error(ex.getMessage() + ex.toString());
		log.debug(ex.getMessage(), ex);
		
		List<String> messageList = new ArrayList<>();
		
		for(ConstraintViolation<?> constraintViolation :  ex.getConstraintViolations()) {
			messageList.add(constraintViolation.getMessage());
		}
		
		ErrorResponse response = new ErrorResponse(messageList.stream().collect(Collectors.joining("\n")));
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleInvaildData(Exception ex, WebRequest request) {

		log.error("Exception : " + ex.toString());
		log.debug(ex.getMessage(), ex);

		ErrorResponse response = new ErrorResponse(ex.getMessage());
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	protected ResponseEntity<Object> handleInvaildData(RuntimeException ex, WebRequest request) {

		log.error("RuntimeException : " + ex.toString());
		log.debug(ex.getMessage(), ex);

		ErrorResponse response = new ErrorResponse(ex.getMessage());
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		log.error("MethodArgumentNotValidException : " + ex.toString());
		log.debug(ex.getMessage(), ex);

		String message = "";
		FieldError error = ex.getBindingResult().getFieldError();
		if (error != null) {
			message = error.getDefaultMessage();
		} else {
			ObjectError objError = ex.getBindingResult().getGlobalError();
			if(objError != null) {
				message = objError.getDefaultMessage();
			}
		}
		ErrorResponse response = new ErrorResponse(message);
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

		if(!(body instanceof ErrorResponse)) {
			log.info("System Exception : " + ex.toString());
			log.debug(ex.getMessage(), ex);
			body = new ErrorResponse(ex.getMessage());
		}

		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, RequestAttributes.SCOPE_REQUEST);
		}
		return new ResponseEntity<>(body, headers, status);
	}
	
	@ExceptionHandler(value = { NumberFormatException.class })
	protected ResponseEntity<Object> handleInvaildData(NumberFormatException ex, WebRequest request) {

		log.error("NumberFormatException : " + ex.toString());
		log.debug(ex.getMessage(), ex);

		ErrorResponse response = new ErrorResponse(ex.getMessage());
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
}
