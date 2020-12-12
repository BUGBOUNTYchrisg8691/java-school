package com.lambdaschool.schools.handlers;

import com.lambdaschool.schools.models.ValidationError;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Component
public class HelperFunctions
{
	public List<ValidationError> getConstraintViolation(Throwable cause)
	{
		while (cause != null && !(cause instanceof ConstraintViolationException || cause instanceof MethodArgumentNotValidException))
		{
			System.out.println(cause.getClass().toString());
			cause = cause.getCause();
		}
		
		List<ValidationError> veLst = new ArrayList<>();
		if (cause instanceof ConstraintViolationException)
		{
			ConstraintViolationException ex = (ConstraintViolationException) cause;
			ValidationError newVe = new ValidationError();
			newVe.setCode(ex.getMessage());
			newVe.setMessage(String.valueOf(ex.getConstraintViolations()));
			veLst.add(newVe);
		} else
		{
			if (cause instanceof  MethodArgumentNotValidException)
			{
				MethodArgumentNotValidException ex = (MethodArgumentNotValidException) cause;
				List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
				for (FieldError err : fieldErrors)
				{
					ValidationError newVe = new ValidationError();
					newVe.setCode(err.getField());
					newVe.setMessage(err.getDefaultMessage());
					veLst.add(newVe);
				}
			} else
			{
				System.out.println("Error in producing constraint violations exceptions. " +
						"If we see this in the console a major logic error has occurred in the " +
						"helperfunction.getConstraintViolation method that we should investigate. " +
						"Note the application will keep running as this only affects exception reporting!");
			}
		}
		return veLst;
	}
}
