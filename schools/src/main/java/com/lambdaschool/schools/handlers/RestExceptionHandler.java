package com.lambdaschool.schools.handlers;

import com.lambdaschool.schools.exceptions.ResourceNotFoundException;
import com.lambdaschool.schools.models.ErrorDetail;
import com.lambdaschool.schools.services.HelperFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{
	@Autowired
	private HelperFunctions helperFunctions;
	
	public RestExceptionHandler()
	{
		super();
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfe)
	{
		ErrorDetail errorDetail = new ErrorDetail();
		
		errorDetail.setTimestamp(new Date());
		errorDetail.setTitle("Resource Not Found");
		errorDetail.setStatus(NOT_FOUND.value());
		errorDetail.setDeveloperMessage(rnfe.getClass().getName());
		errorDetail.setDetail(rnfe.getMessage());
		errorDetail.setErrors(helperFunctions.getConstraintViolation(rnfe));
		
		return new ResponseEntity<>(errorDetail, NOT_FOUND);
	}
	
	@Override protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
	                                                                   HttpStatus status, WebRequest request)
	{
		ErrorDetail errorDetail = new ErrorDetail();
		
		errorDetail.setTimestamp(new Date());
		errorDetail.setTitle("Rest Internal Error");
		errorDetail.setDetail(ex.getMessage());
		errorDetail.setStatus(status.value());
		errorDetail.setDeveloperMessage(ex.getClass().getName());
		errorDetail.setErrors(helperFunctions.getConstraintViolation(ex));
		
		return new ResponseEntity<>(errorDetail, status);
	}
}
