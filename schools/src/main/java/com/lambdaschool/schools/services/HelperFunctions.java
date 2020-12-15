package com.lambdaschool.schools.services;

import com.lambdaschool.schools.models.Advice;
import com.lambdaschool.schools.models.ValidationError;

import java.util.List;

/**
 * The interface Helper functions.
 */
public interface HelperFunctions
{
	/**
	 * Gets constraint violation.
	 *
	 * @param cause the cause
	 * @return the constraint violation
	 */
	List<ValidationError> getConstraintViolation(Throwable cause);
	
	/**
	 * Gets advice per instructor.
	 *
	 * @param searchTerm the search term
	 * @return the advice per instructor
	 */
	Advice getAdvicePerInstructor(String searchTerm);
}
