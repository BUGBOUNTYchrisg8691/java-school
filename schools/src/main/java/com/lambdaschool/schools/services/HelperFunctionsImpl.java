package com.lambdaschool.schools.services;

import com.lambdaschool.schools.models.ValidationError;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

@Service(value = "helperFunctions")
public class HelperFunctionsImpl implements HelperFunctions
{
	@Override public List<ValidationError> getConstraintViolation(Throwable cause)
	{
		while (cause != null && !(cause instanceof ConstraintViolationException || cause instanceof MethodArgumentNotValidException))
		{
			cause = cause.getCause();
			
		}
		
		List<ValidationError> veList = new ArrayList<>();
		
		if (cause != null)
		{
			if (cause instanceof ConstraintViolationException)
			{
				ConstraintViolationException ex = (ConstraintViolationException) cause;
				ValidationError newVe = new ValidationError();
				newVe.setCode(ex.getMessage());
				newVe.setMessage(ex.getConstraintName());
				veList.add(newVe);
			} else
			{
				if (cause instanceof MethodArgumentNotValidException)
				{
					MethodArgumentNotValidException ex = (MethodArgumentNotValidException) cause;
					List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
					for (FieldError err : fieldErrors)
					{
						ValidationError newVe = new ValidationError();
						newVe.setCode(err.getField());
						newVe.setMessage(err.getDefaultMessage());
						veList.add(newVe);
					}
				} else
				{
					System.out.println("We have an error in helper functions");
				}
			}
		}
		return veList;
	}
}
