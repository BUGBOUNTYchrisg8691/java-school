package com.lambdaschool.schools.services;

import com.lambdaschool.schools.models.Advice;
import com.lambdaschool.schools.models.ValidationError;

import java.util.List;

public interface HelperFunctions
{
	List<ValidationError> getConstraintViolation(Throwable cause);
	
	Advice getAdvicePerInstructor(String searchTerm);
}
