package com.lambdaschool.schools.handlers;

import com.lambdaschool.schools.models.ErrorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ResponseEntityExecptionHandler extends ResponseEntityExceptionHandler
{
	@Autowired
	private HelperFunctions helperFunctions;
	
	public ResponseEntityExecptionHandler()
	{
		super();
	}
	
	@Override protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
	                                                                   HttpStatus status, WebRequest request)
	{
		ErrorDetail errorDetail = new ErrorDetail();
		
		errorDetail.setTimestamp(new Date());
		errorDetail.setStatus(status.value());
		errorDetail.setTitle("Rest Internal Exception");
		errorDetail.setDevMessage(ex.getClass().getName());
		errorDetail.setValidationErrors(helperFunctions.getConstraintViolation(ex));
		
		return new ResponseEntity<>(errorDetail, null, status);
	}
}
