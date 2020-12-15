package com.lambdaschool.schools.services;

import com.lambdaschool.schools.models.Instructor;

/**
 * The interface Instructor service.
 */
public interface InstructorService
{
	/**
	 * Find instructor by id instructor.
	 *
	 * @param id the id
	 * @return the instructor
	 */
	Instructor findInstructorById(long id);
}
